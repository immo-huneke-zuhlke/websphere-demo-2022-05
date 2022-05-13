package com.zuhlke.training.pact.restdemotest;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


public class StateMaker {

   static final Map<String, Method> pactStateMap = new HashMap() {{
        try {
            put("database contains two users", StateMaker.class.getDeclaredMethod("makeTwoUsers"));
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }};

    static void dispatch(String stateName) throws IllegalArgumentException, InvocationTargetException, IllegalAccessException {
        if(pactStateMap.containsKey(stateName)){
            pactStateMap.get(stateName).invoke(null);
        }else{
            throw new IllegalArgumentException("Illegal State : " + stateName);
        }
    }

    static void makeTwoUsers(){
        System.out.println("makeTwoUsers");
    }

}
