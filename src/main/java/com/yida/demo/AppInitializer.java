package com.yida.demo;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by helloz on 2016/7/27.
 */
public class AppInitializer implements WebApplicationInitializer {

    private static final String CONFIG_LOCATION = "com.yida.demo.config";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("Initializing Application for " + servletContext.getServerInfo());

        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.setConfigLocation(CONFIG_LOCATION);

        DispatcherServlet dispatcherServlet = new DispatcherServlet(ctx);
        ServletRegistration.Dynamic servlet = servletContext.addServlet("mvc", dispatcherServlet);
        servlet.addMapping("/");
        servlet.setAsyncSupported(true);
        servlet.setLoadOnStartup(1);

    }
}
