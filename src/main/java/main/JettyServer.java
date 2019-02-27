package main;


import config.JerseyConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

public final class JettyServer {
    private static final String JERSEY_SERVLET_NAME = "jersey-container-servlet";

    public static void main(String[] args) throws Exception
    {
        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(server, "/*");

        ServletHolder servlet = new ServletHolder(JERSEY_SERVLET_NAME,new ServletContainer(new JerseyConfiguration()));
        context.addServlet(servlet, "/*");

        try {
            server.start();
            server.join();
        } finally {
            server.destroy();
        }
    }
}
