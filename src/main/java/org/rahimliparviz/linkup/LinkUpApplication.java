package org.rahimliparviz.linkup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class LinkUpApplication {

    public static void main(String[] args) {
        SpringApplication.run(LinkUpApplication.class, args);
    }

}
