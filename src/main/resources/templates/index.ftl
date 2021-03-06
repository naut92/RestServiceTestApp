<!doctype html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <title>Rest Service Test App</title>
    <meta name="description" content="" />
    <meta name="viewport" content="width=device-width" />
    <!--base href="/" /-->
    <link rel="stylesheet" type="text/css"
          href="/webjars/bootstrap/css/bootstrap.min.css" />
    <script type="text/javascript" src="/webjars/jquery/jquery.min.js"></script>
    <script type="text/javascript"
            src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container unauthenticated">

 <div class="main-content">

        <h1 id="message">REST SERVICE Test APP</h1>

        <div id="info">
        <div id="powered">
            <p id="company-name"></p>
            <div id="united-kingdom"></div>
        </div>
        </div>

        <div id="social-network">
            <div class="container text-danger error" style="display: none">
                There was an error (bad credentials).
            </div>
        <p id="login-with">Login with:</p>
        <a class="tablet-logo" href="/login/facebook"><img class="social-network" src="/res/facebook-tablet.png"></a>
        <a class="tablet-logo" href="/login/github"><img class="social-network" src="/res/github.png"></a>
        <a class="tablet-logo" href="/login/google"><img class="social-network" src="/res/google.png"></a>
        <a class="tablet-logo" href="/login/vk"><img class="social-network" src="/res/vk.png"></a>
        <!--a class="tablet-logo" href="/login/linkedIn">linkedIn</a>
        <a class="tablet-logo" href="/login/twitter">twitter</a-->
        </div>
    </div>

</div>



    <div>
        Неавторизованный контент
    </div>

<div class="container authenticated" style="display: none">
    Logged in as: <span id="user"></span>
    <div>
        <button onClick="logout()" class="btn btn-primary">Logout</button>
    </div>
    <div>
        Авторизованный контент:
        <div>
            <button onClick="sms()" class="btn btn-primary" id="btnPOSTsms">Send SMS</button>
        </div>
    </div>
</div>



<script type="text/javascript"
        src="/webjars/js-cookie/js.cookie.js"></script>
<script type="text/javascript" src="js/login.js"></script>
<script type="text/javascript" src="js/userslist.js"></script>
<script type="text/javascript" src="js/animalslist.js"></script>
</body>
</html>