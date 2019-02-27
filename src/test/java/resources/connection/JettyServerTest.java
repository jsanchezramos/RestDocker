package resources.connection;

import config.JerseyConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

public final class JettyServerTest {
    private static final String JERSEY_SERVLET_NAME = "jersey-container-servlet";
    private Server server;

    public void startServer() throws Exception {
        server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(server, "/*");
        ServletHolder servlet = new ServletHolder(JERSEY_SERVLET_NAME,new ServletContainer(new JerseyConfiguration()));
        context.addServlet(servlet, "/*");
        server.start();
    }
    public void stopServer() throws Exception {
        server.stop();
    }
}
