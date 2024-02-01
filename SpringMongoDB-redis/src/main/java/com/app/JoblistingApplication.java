package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Emp;
import com.app.repository.EmpRepo;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableCaching
public class JoblistingApplication implements CommandLineRunner{

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).paths(PathSelectors.any())
				.build().apiInfo(apiInfo()).useDefaultResponseMessages(false);
	}

	@Bean
	public ApiInfo apiInfo() {
		final ApiInfoBuilder builder = new ApiInfoBuilder();
		return builder.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(JoblistingApplication.class, args);
	}

	@Autowired
	private EmpRepo empRepo;
	@Override
	public void run(String... args) throws Exception {
		Emp emp1 = new Emp("dinesh", "d@123", "male", 30);
		emp1.setId("01");
		Emp emp2 = new Emp("abhi", "abhi@12", "male", 30);
		emp2.setId("02");
		empRepo.save(emp1);
		empRepo.save(emp2);
	}
	
	
	
	

}
