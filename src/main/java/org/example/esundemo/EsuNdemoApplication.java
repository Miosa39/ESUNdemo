package org.example.esundemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.sql.DataSource;

@SpringBootApplication
public class EsuNdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsuNdemoApplication.class, args);
	}

}

