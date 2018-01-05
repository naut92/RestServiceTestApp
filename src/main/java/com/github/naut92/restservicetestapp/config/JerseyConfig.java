package com.github.naut92.restservicetestapp.config;

import com.github.naut92.restservicetestapp.services.JerseyClientPost;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig{

    public JerseyConfig() {
        register(JerseyClientPost.class);
        //register(AnimalResource.class);
        register(RequestContextFilter.class);
        property(ServerProperties.RESPONSE_SET_STATUS_OVER_SEND_ERROR, true);
    }
}