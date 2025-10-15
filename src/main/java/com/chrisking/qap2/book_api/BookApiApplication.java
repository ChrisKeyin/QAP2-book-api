package com.chrisking.qap2.book_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for starting the Book API Spring Boot application.
 */
@SpringBootApplication
public class BookApiApplication {

    /**
     * Application entry point.
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(BookApiApplication.class, args);
    }

}
