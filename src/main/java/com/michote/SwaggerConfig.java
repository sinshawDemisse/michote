/**
 * 
 */
package com.michote;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This class is Swagger configuration class for the whole application that used
 * to discover and understand the capabilities of the service without access to
 * source code
 * 
 * @author Abereham wodajie
 * 
 */
@Configuration
@EnableSwagger2
@EnableAutoConfiguration
public class SwaggerConfig {

	@Bean
	@ConditionalOnMissingBean(RequestContextListener.class)
	public RequestContextListener requestContextListener() {
		return new RequestContextListener();
	}

	@Bean
	public Docket documentation() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any()).paths(regex("/.*"))
				.build().pathMapping("/").enableUrlTemplating(false).apiInfo(metadata());

	}

	@Bean
	public UiConfiguration uiConfig() {
		return UiConfiguration.DEFAULT;
	}

	private ApiInfo metadata() {
		Contact contact1 = new Contact("Mahi", "", "Mahi@gmail.com");
		Contact contact2 = new Contact("Sine", "", "Seni@gmail.com");
		Contact contact3 = new Contact("Abereham Wodajie", "", "abereham.wodajie@gmail.com");
		return new ApiInfoBuilder().title("Archtics Api Service")
				.description("Archtics API service is customer authentication api and Demographics api service"
						+ " It is developed based on service template 2.0.  Service Template 2.0 is a development template"
						+ " which is mainly implemented by using Spring Boot 1.2.x along with Spring Framework 4.1.x")
				.version("1.0").contact(contact2).contact(contact3).contact(contact1).build();
	}

}