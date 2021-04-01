package org.example;

import org.apache.log4j.Logger;
import org.example.service.StringReverse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

    private static final Logger log = Logger.getLogger(StringReverse.class);

    public static void main(String[] args) {

        log.debug("Start of Main");

        SpringApplication.run(Application.class, args);

        log.debug("End of Main");
    }
}
