package resources;

import config.JerseyConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import resources.connection.JettyServerTest;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class CardResourcePostTest {
    private JettyServerTest jettyServerTest = new JettyServerTest();

    @BeforeEach
    public void setup() throws Exception
    {
        jettyServerTest.startServer();
    }
    @AfterEach
    public void closeConnection() throws Exception {
       jettyServerTest.stopServer();
    }

    @Test
    public void whenAddItemIsNotCorrectAddItem() throws IOException {
        HttpURLConnection http = (HttpURLConnection)new URL("http://0.0.0.0:8080/card").openConnection();
        http.setRequestMethod("POST");
        http.connect();

        assertTrue(http.getResponseCode() == 400);
    }
    @Test
    public void whenAddCorrectItems() throws IOException {
        String json = "{\"priceItem\":\"10€\" , \"nameItem\":\"coke\"}";

        HttpURLConnection http = (HttpURLConnection)new URL("http://0.0.0.0:8080/card").openConnection();
        http.setRequestMethod("POST");
        http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        http.setDoOutput(true);

        OutputStream os = http.getOutputStream();

        os.write(json.getBytes("UTF-8"));
        os.close();
        http.connect();

        assertTrue(http.getResponseCode() == 201);
    }

}