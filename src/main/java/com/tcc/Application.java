package com.tcc;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import jakarta.annotation.PostConstruct;


@SpringBootApplication
@EnableAsync
public class Application {

   @PostConstruct
    public void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("America/Bogota"));
    }

	public static void main(String[ ]  args) {
		SpringApplication.run(Application.class, args);
	}

    

}
