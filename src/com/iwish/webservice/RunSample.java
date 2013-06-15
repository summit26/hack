package com.iwish.webservice;

import java.util.Map;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.spi.container.servlet.ServletContainer;

public class RunSample {

	public static void main(String argv[])
	{
	    try
	    {
	        // from http://wiki.eclipse.org/Jetty/Tutorial/Embedding_Jetty
	        Server server = new Server(8080);
	        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
	        contextHandler.setContextPath("/");
	        server.setHandler(contextHandler);

	        // http://stackoverflow.com/questions/9670363/how-do-i-programmatically-configure-jersey-to-use-jackson-for-json-deserializa
	        final PackagesResourceConfig prc = new PackagesResourceConfig("com.iwish.webservice");
	        final Map<String, Object> prcProperties = prc.getProperties();
	        prcProperties.put(JSONConfiguration.FEATURE_POJO_MAPPING, true);

	        // from http://stackoverflow.com/questions/7421574/embedded-jetty-with-jersey-or-resteasy
	        contextHandler.addServlet(new ServletHolder(new ServletContainer(prc)), "/rest/*");

	        server.start();
	        server.join();
	    }
	    catch(Exception e)
	    {
	        System.out.println(e);
	    }
	
	}
}
	
