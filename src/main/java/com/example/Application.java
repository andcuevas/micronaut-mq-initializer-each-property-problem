package com.example;

import io.micronaut.runtime.Micronaut;

public class Application {

    public static void main(String[] args) {
        long pid = ProcessHandle.current().pid();
        System.setProperty("pid", Long.toString(pid));
        Micronaut.run(Application.class);
    }
}