package com.ux.common;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public final class ContextListener implements ServletContextListener {


    @Override
    public void contextInitialized(final ServletContextEvent servletContextEvent) {

        final ApplicationInitializer applicationInitializer = ApplicationInitializer.create();
        applicationInitializer.initialize();

    }

    @Override
    public void contextDestroyed(final ServletContextEvent servletContextEvent) {

    }
}
