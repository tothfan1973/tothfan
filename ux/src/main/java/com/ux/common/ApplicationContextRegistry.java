package com.ux.common;


public class ApplicationContextRegistry {

    private static IApplicationContext appContext;

    private ApplicationContextRegistry() {

    }

    public static void register(final IApplicationContext argAppContext) {

        appContext = argAppContext;
    }

    public static IApplicationContext getApplicationContext() {

//        if (appContext == null) {
//            throw new ProgrammingException("Application was not properly initialized.");
//        }

        return appContext;
    }


}
