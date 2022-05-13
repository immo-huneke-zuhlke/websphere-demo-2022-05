package com.zuhlke.training.pact.restdemotest;

import java.io.Serializable;

public class RequestBody implements Serializable {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "RequestBody{" +
                "state='" + state + '\'' +
                '}';
    }
}
