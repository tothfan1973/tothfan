package com.ux.common;

import org.jetbrains.annotations.NotNull;

public class ApplicationInitializer {

    private ApplicationInitializer() {

    }

    @NotNull
    public static ApplicationInitializer create() {

        return new ApplicationInitializer();
    }

    public void initialize() {

        final IApplicationContext argAppContext = ApplicationContextBuilder.buildForWebapp();
        ApplicationContextRegistry.register(argAppContext);
    }

}
