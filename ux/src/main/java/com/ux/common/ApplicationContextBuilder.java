package com.ux.common;


import org.jetbrains.annotations.NotNull;


public class ApplicationContextBuilder {


    private ApplicationContextBuilder() {

    }


    public static IApplicationContext buildForWebapp() {

        @NotNull final HsqldbConnectionFactory jdbcConnectionFactory = new HsqldbConnectionFactory();
        return new ApplicationContex(jdbcConnectionFactory);
    }

}
