package com.doudh.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger文档
 * 
 * @author
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2).
				groupName("doudh的swagger接口文档")
				.apiInfo(new ApiInfoBuilder().title("doudh的swagger接口文档").version("1.0").build())
				.select()
				.paths(Predicates.not(PathSelectors.regex("/error.*")))//错误路径不监控
				.paths(PathSelectors.regex("/.*"))// 对根下所有路径进行监控
				.build();
	}

	// http://ip:端口/swagger-ui.html
}
