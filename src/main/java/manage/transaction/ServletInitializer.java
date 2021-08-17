package manage.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
@SpringBootApplication
public class ServletInitializer extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(ServletInitializer.class, args);
        System.out.println("\t\t\t\t\t\t\t\t\t\t**************************************************************************");
        System.out.println("\t\t\t\t\t\t\t\t\t\t**************************************************************************");
        System.out.println("\t\t\t\t\t\t\t\t\t\t**************************************************************************");
        System.out.println("\t\t\t\t\t\t\t\t\t\t**************************************************************************");
        System.out.println("\t\t\t\t\t\t\t\t\t\t**                                                                      **");
        System.out.println("\t\t\t\t\t\t\t\t\t\t**                   Mangeing Transaction is ready                      **");
        System.out.println("\t\t\t\t\t\t\t\t\t\t**                                                                      **");
        System.out.println("\t\t\t\t\t\t\t\t\t\t**************************************************************************");
        System.out.println("\t\t\t\t\t\t\t\t\t\t**************************************************************************");
        System.out.println("\t\t\t\t\t\t\t\t\t\t**************************************************************************");
        System.out.println("\t\t\t\t\t\t\t\t\t\t**************************************************************************");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ServletInitializer.class);
    }

}
