package com.rupesh.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebConfig implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// Creating Container object
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(LoverCalcServletContext.class);

		// Creating DispatcherServlet object
		DispatcherServlet dispatcherServlet = new DispatcherServlet(context);

		// register DispatcherServlet object to the servletContext object
		ServletRegistration.Dynamic addServlet = servletContext.addServlet("love-calc-servlet", dispatcherServlet);

		// load on register
		addServlet.setLoadOnStartup(1);

		// url patter
		addServlet.addMapping("/");

		// close container object
		context.close();

	}

}
