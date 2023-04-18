package apiforreactapp1.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.swagger.models.Path;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Collection;
import java.util.Collections;
/**
 * 
 */
@Configuration
@EnableWebMvc

public class VisileanConfig {
    

    @Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2)
		.apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
	}


	private ApiInfo apiInfo() {
		return new ApiInfo("Application : For Visilean", "this is a lean base  company", "1.0", "Team of service", 
		new Contact("Visilean", "https://github.com/raju-kumar21", "raju.kumar@visilean.com") , "Licence of APIS","API licence url", Collections.emptyList());
	}



}
