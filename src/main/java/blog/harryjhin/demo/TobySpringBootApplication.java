package blog.harryjhin.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

// @SpringBootApplication
public class TobySpringBootApplication {

    public static void main(String[] args) {
        // original
        // SpringApplication.run(TobySpringBootApplication.class, args);

        // tomcat servlet container
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        WebServer webServer = factory.getWebServer(servletContext -> {
            HelloController helloController = new HelloController();
            servletContext.addServlet("frontController", new HttpServlet() {
                @Override
                protected void service(HttpServletRequest req, HttpServletResponse resp)
                    throws ServletException, IOException {

                    // 프론트 컨트롤러에서 수행하는 인증, 보안 등의 공통 기능이 구현됨.

                    // hello 요청에 대한 처리
                    if (req.getRequestURI().equals("/hello") &&
                        req.getMethod().equals(HttpMethod.GET.name())
                    ) {
                        String name = req.getParameter("name");
                        String hello = helloController.hello(name);

                        resp.setContentType(MediaType.TEXT_PLAIN_VALUE);
                        resp.getWriter().println(hello);
                    } else { // 그 외의 요청에 대한 처리
                        resp.setStatus(HttpStatus.NOT_FOUND.value());
                    }
                }
            }).addMapping("/*");
        });
        webServer.start();
    }

}
