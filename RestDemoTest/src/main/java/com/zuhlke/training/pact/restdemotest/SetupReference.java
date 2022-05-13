package com.zuhlke.training.pact.restdemotest;

interface SetupInterface{
    void setupMethod();
}
public class SetupReference {
    public static void setupImpl(){
        System.out.println("setupImpl method running");
    }

    public static void main(String[] args) {
        SetupInterface setupImpl = SetupReference::setupImpl;
        setupImpl.setupMethod();
    }
}
