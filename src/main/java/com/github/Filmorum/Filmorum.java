package com.github.Filmorum;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
public class Filmorum extends ResourceConfig {
    public Filmorum(){
        packages("com.github.Filmorum");
    }
}