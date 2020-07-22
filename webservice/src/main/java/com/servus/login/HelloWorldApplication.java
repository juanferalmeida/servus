package com.servus.login;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * A request scoped bean for the JAX-RS HelloWorld example.
 * 
 * @author Manfred Riem (mriem@manorrock.com)
 */
@ApplicationPath("rest")
public class HelloWorldApplication extends Application {

    /**
     * Get the classes.
     * 
     * @return the classes.
     */
    @Override
    public Set<Class<?>> getClasses() {
        HashSet classes = new HashSet();
        classes.add(HelloWorldResource.class);
        return classes;
    }
}