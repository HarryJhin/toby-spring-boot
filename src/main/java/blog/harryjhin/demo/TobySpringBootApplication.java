package blog.harryjhin.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;

// @SpringBootApplication
public class TobySpringBootApplication {

    public static void main(String[] args) {
        // original
        // SpringApplication.run(TobySpringBootApplication.class, args);

        // tomcat servlet container
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        WebServer webServer = factory.getWebServer();
        webServer.start();
    }

}
