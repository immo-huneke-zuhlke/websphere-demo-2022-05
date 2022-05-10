package com.zuhlke.training.restdemo;

import com.zuhlke.training.restdemo.resources.UserResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class RestDemoApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() { Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(UserResource.class);
        s.add(CORSFilter.class);
        return s;}
}