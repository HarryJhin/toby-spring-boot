package blog.harryjhin.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;

// @SpringBootApplication
public class TobySpringBootApplication {

    public static void main(String[] args) {
        // original
        // SpringApplication.run(TobySpringBootApplication.class, args);

        // tomcat servlet container
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        WebServer webServer = factory.getWebServer(servletContext -> {
            servletContext.addServlet("hello", new HttpServlet() {
                @Override
                protected void service(HttpServletRequest req, HttpServletResponse resp)
                    throws ServletException, IOException {
                    resp.setStatus(HttpServletResponse.SC_OK);
                    resp.setHeader("Content-Type", "text/plain");
                    resp.getWriter().println("Hello, " + req.getParameter("name"));
                }
            }).addMapping("/hello");
        });
        webServer.start();
    }

}
