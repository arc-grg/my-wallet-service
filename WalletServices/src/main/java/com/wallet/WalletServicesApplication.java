package com.wallet;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EnableSwagger2
public class WalletServicesApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(WalletServicesApplication.class, args);
		
	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
//	@Bean
//	   public Docket productApi() {
//	      return new Docket(DocumentationType.SWAGGER_2).select()
//	         .apis(RequestHandlerSelectors.basePackage("com.wallet")).build();
//	   }

}
