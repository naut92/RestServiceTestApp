//var customerlistURL = '/animals-rest/index/customers';
//*for Tomcat
var customerlistURL = '/people';
//*/
var currentCustomer;

//$.ajaxSetup({cache: false});

//add CSRF AJAX/REST protection:
//*
var csrfGet = {make: CSRF};
function CSRF() {
    var token = $("meta[name='_csrf']").attr("content");
    var header = $("meta[name='_csrf_header']").attr("content");
    $(document).ajaxSend(function(e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
}
//*/
/*
$(document).ajaxError(function(event, request, settings) {
	alert("Error accessing the server");
});
*/
//Customers---------------------------------------

// Nothing to delete in initial application state
$('#btnDeleteCustomer').hide();

// Register listeners for customers
$('#btnSearchCustomer').click(function() {
    search($('#searchCustomer').val());
    return false;
});

//инициализация idCustomer:
var idCustomer = 887;

function search(searchKey) {
    if (searchKey == '')
        getCustomerList();
    else if(Math.floor(searchKey) == searchKey && $.isNumeric(searchKey))
        findCustomerById(searchKey);
    else
        findByLName(searchKey);
}

 //Trigger search when pressing 'Return' on search key input field
$('#searchCustomer').keypress(function(e){
    if(e.which == 13) {
        search($('#searchCustomer').val());
        e.preventDefault();
        return false;
    }
});

$('#btnAddCustomer').click(function() {
    $('#searchCustomer').val('');
    $('#customerList li').empty();

    $('#searchAnimals').val('');
    $('#animalsList').empty();
    $('#detailsAnimals li').empty();
    $('#searchAnimalsDetails').val('');
    newCustomer();

    return false;
});

$('#btnSaveCustomer').click(function() {
    if ($('#custId').val() == '')
        addCustomer();
    else
        updateCustomer();
    return false;
});

$('#btnDeleteCustomer').click(function() {
    deleteCustomer();
    return false;
});

function newCustomer() {
    $('#btnDeleteCustomer').hide();
    currentCustomer = {};
    renderDetailsCustomer(currentCustomer); // Display empty form
}

function getCustomerList() {
    console.log('all Customers');
    $.ajax({
        type: 'GET',
        url: customerlistURL,
        dataType: "json", // data type of response
        success: function (data) {
            renderCustomersList(data);
        }
    });
}

function findByLName(searchKey) {
    console.log('findByLName: ' + searchKey);
    $.ajax({
        type: 'GET',
        url: customerlistURL + '/customerLn/' + searchKey,
        dataType: "json",
        success: function (searchKey) {
            renderCustomersList(searchKey);
        },
        error: function(xhr, status) {
            alert(xhr.status + 'Customer not found'); }
    });
}

function findCustomerById(id) {
    console.log('findCustomerById: ' + id);
    $.ajax({
        type: 'GET',
        url: customerlistURL + '/' + id,
        dataType: "json",
        success: function(data){
            $('#btnDeleteCustomer').show();
            console.log('findCustomerById success: ' + data.id);
            currentCustomer = data;
            renderDetailsCustomer(currentCustomer);
            renderCustomersList(currentCustomer);

        },
        error: function(xhr, status) {
            alert(xhr.status + ' Customer not found'); }
    });
}

function addCustomer() {
    console.log('addCustomer');
    //add CSRF AJAX/REST protection:
    csrfGet.make();
    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        url: customerlistURL,
        //when dataType: 'json', I get parseerror in server response
        dataType: 'text',
        data: formToJSONforCustomer(),
        success: function(data, textStatus, jqXHR){
            try {
                var output = JSON.parse(data);
                alert('New customer id: '  + output);
            } catch (e) {
                alert("Output is not valid JSON: " + data);
            }
            alert('Customer created successfully');
            $('#btnDeleteCustomer').show();
            $('#custId').val(data);
        },
        error: function(xhr, status){
            alert(xhr.status + ' add Customer error: Incorrect email/or exist email!');
        }
    });
}

function updateCustomer() {
    console.log('updateCustomer');
    //add CSRF AJAX/REST protection:
    csrfGet.make();
    $.ajax({
        type: 'PUT',
        contentType: 'application/json',
        url: customerlistURL + '/' + $('#custId').val(),
        dataType: 'json',
        data: formToJSONforCustomer(),
        success: function(data, textStatus, jqXHR){
            alert('Customer updated successfully');
        },
        error: function(xhr, status) {
            alert(xhr.status + ' Customer not found'); }
    });
}

function deleteCustomer() {
    console.log('deleteCustomer ' + $('#custId').val());
    csrfGet.make();
    $.ajax({
        type: 'DELETE',
        url: customerlistURL + '/' + $('#custId').val(),
        success: function(data, textStatus, jqXHR){
            alert('Customer deleted successfully');
        },
        error: function(jqXHR, textStatus, errorThrown){
            alert('deleteCustomer error');
        }
    });
}

function renderCustomersList(data) {
    // JAX-RS serializes an empty list as null, and a 'collection of one' as an object (not an 'array of one')
    var list = data == null ? [] : (data instanceof Array ? data : [data]);
    //all clear:
    $('#customerList li').empty();
    $('#animalsList').empty();
    $('#detailsAnimals li').empty();

    $.each(list, function(index, customer) {
        //$('#customerList').append('<li><a href="customers.html#' + customer.id + '">'+customer.firstname +' '+customer.lastname+' '+customer.email+' '+customer.dateborn +'</a></li>');
        $('#customerList').append('<li> Your Id: '+customer.id+'<br> First name: '+customer.firstname+'<br>Last name: '+customer.lastname+'<br> Email: '+customer.email+'<br>  Birthday: '+customer.dateborn+ '<br><br>Your animals: '+'<br></li>');
//animals:
        $.each(customer.animalsById, function (index, animalsById) {
            if (animalsById.id !== null){
                $('#customerList').append('<li> Animal Id: '+animalsById.id+'<br> Name: '+animalsById.animalname+'<br> Birthday: '+animalsById.dateborn+'<br> Sex: '+animalsById.sex+'<br> Type animal: '+animalsById.typesanimalsId+'</li>');
            }
        });
    });
}

function renderDetailsCustomer(customer) {
    //clear another form:
    $('#animalForm')[0].reset();
    $('#searchAnimals').val('');
    $('#searchAnimalsDetails').val('');

    $('#custId').val(customer.id);
    $('#custFn').val(customer.firstname);
    $('#custLn').val(customer.lastname);
    $('#custEmail').val(customer.email);
    $('#custDb').val(customer.dateborn);
    $('#custPass').val(customer.pass);
}

// Helper function to serialize all the form fields into a JSON string
function formToJSONforCustomer() {
    var customerId = $('#custId').val();
    return JSON.stringify({
        "id": customerId == "" ? null : customerId,
        "dateborn": $('#custDb').val(),
        "email": $('#custEmail').val(),
        "firstname": $('#custFn').val(),
        "lastname": $('#custLn').val(),
        "pass": $('#custPass').val()
    });
}


//End Customers--------------------------------------