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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class CardResourceGetTest {
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
    public void whenGetAllItemsInTheCard() throws IOException {
        HttpURLConnection http = (HttpURLConnection)new URL("http://0.0.0.0:8080/card").openConnection();
        http.setRequestMethod("GET");
        http.connect();
        BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            sb.append(line+"\n");
        }
        br.close();

        assertTrue(http.getResponseCode() == 200);

    }

}