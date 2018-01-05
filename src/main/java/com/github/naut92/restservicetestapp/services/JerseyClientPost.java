package com.github.naut92.restservicetestapp.services;

import com.github.naut92.restservicetestapp.entities.ClientSMSEntity;
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
        final String host = "https://api.infobip.com";
        final String baseURL = "/sms/1/text/single HTTP/1.1";
        final String authorization = "Basic QWxhZGRpbjpvcGVuIHNlc2FtZQ==";
        final String contentType = "application/json";
        final String accept = "application/json";

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
        Client client = ClientBuilder.newClient(config);

        //POST Request
        //final Response response = client.target("").request().post();

    }
}
