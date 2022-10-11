package com.ZenPack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ZenPackProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZenPackProjectApplication.class, args);
	}

}
