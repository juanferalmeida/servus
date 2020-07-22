package com.servus.login;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * The resource for the JAX-RS HelloWorld example.
 *
 * @author Manfred Riem (mriem@manorrock.com)
 */
@Path("helloWorld")
public class HelloWorldResource {

    /**
     * Hello World method.
     *
     * @return "Hello World"
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String helloWorld() {
        return "Hello World";
    }
}