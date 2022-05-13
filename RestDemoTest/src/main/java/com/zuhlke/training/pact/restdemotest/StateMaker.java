package com.zuhlke.training.pact.restdemotest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


interface SetupHolder{
    void setup();
}
public class StateMaker {

   static final Map<String, SetupHolder> pactStateMap = new HashMap() {{
            SetupHolder setupHolder = StateMaker :: makeTwoUsers;
            put("database contains two users", setupHolder);
    }};

    static void dispatch(String stateName) throws IllegalArgumentException, InvocationTargetException, IllegalAccessException {
        if(pactStateMap.containsKey(stateName)){
            pactStateMap.get(stateName).setup();
        }else{
            throw new IllegalArgumentException("Illegal State : " + stateName);
        }
    }

    static void makeTwoUsers(){
        System.out.println("makeTwoUsers started");
        UserDao userDao = new UserDao();
        userDao.deleteAll();
        userDao.saveUser(new User(1, "Gayatri","gpotawad@gmail.com"));
        userDao.saveUser(new User(2, "Immo",null));
        System.out.println("makeTwoUsers done");
    }

}
