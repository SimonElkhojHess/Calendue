package dk.kea.calendue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})//Excludes spring security login page
public class CalendueApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalendueApplication.class, args);
    }

}
