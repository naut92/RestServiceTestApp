package com.github.naut92.restservicetestapp.services;

import com.github.naut92.restservicetestapp.entities.ClientSMSEntity;
import org.apache.catalina.WebResource;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.*;
import javax.ws.rs.core.Response;
import java.io.IOException;

/************
 * https://api.infobip.com/sms/1/text/single
 * =========================================
 * POST /sms/1/text/single HTTP/1.1
 * Host: api.infobip.com
 * Authorization: Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==
 * Content-Type: application/json
 * Accept: application/json
 *
 * {
 * "from":"InfoSMS",
 * "to":"41793026727",
 * "text":"Test SMS."
 *}
 *
 *
 */

public class JerseyClientPost {
    public static  void main(String[] args) {
/*
        try {
            Client client = Client.create();

            WebResource webResource = client.resource(baseuri);

            String input = "{\"switch\": \"00:00:00:00:00:00:00:01\", "
                    + "\"name\":\"flow-mod-1\", \"priority\":\"32768\", "
                    + "\"ingress-port\":\"1\",\"active\":\"true\", "
                    + "\"actions\":\"output=2\"}";

            // POST method
            ClientResponse response = webResource.accept("application/json")
                    .type("application/json").post(ClientResponse.class, input);

            // check response status code
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }

            // display response
            String output = response.getEntity(String.class);
            System.out.println("Output from Server .... ");
            System.out.println(output + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

*/

        //*
        //final String host = "https://api.infobip.com";
        //final String baseURL = "/sms/1/text/single HTTP/1.1";
        final String host = "http://localhost:8080";
        final String baseURL = "/index";
        final String authorization = "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==";
        final String contentType = "application/json";
        final String accept = "application/json";

        String input = "{\"from\": \"InfoSMS RestServiceTestApp\", "
                + "\"to\":\"38267427802\", "
                + "\"text\":\"Test SMS\"}";

        // Headers for client.
        ClientRequestFilter clientRequestFilter = new ClientRequestFilter() {
            @Override
            public void filter(ClientRequestContext clientRequestContext) throws IOException {
                clientRequestContext.getHeaders().add("POST", baseURL);
                clientRequestContext.getHeaders().add("Host", host);
                clientRequestContext.getHeaders().add("Authorization", authorization);
                clientRequestContext.getHeaders().add("Content-Type", contentType);
                clientRequestContext.getHeaders().add("Accept", accept);
            }

        };

        ClientConfig config = new ClientConfig();
        config.register(clientRequestFilter);
        Client client = ClientBuilder.newBuilder().newClient(config);

        //POST Request
        //final Response response = client.target("").request().post();
        ClientSMSEntity clientSMSEntity = new ClientSMSEntity("InfoSMS RestServiceTestApp", "38267427802", "Test SMS");

        //WebTarget webTarget = client.target("https://api.infobip.com/sms/1/text/single");
        WebTarget webTarget = client.target(host + baseURL);
        Response response = webTarget.request("application/json").post(Entity.json(input));




        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }
        String output = response.readEntity(String.class);
        System.out.println("Output from Server... \n");
        System.out.println(output);
        client.close();
//*/
    }
}
