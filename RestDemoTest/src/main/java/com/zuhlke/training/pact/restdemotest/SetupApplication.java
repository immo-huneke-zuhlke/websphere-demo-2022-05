package com.zuhlke.training.pact.restdemotest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/setup")
public class SetupApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() { Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(SetupResource.class);
        s.add(CORSFilter.class);
        return s;}
}