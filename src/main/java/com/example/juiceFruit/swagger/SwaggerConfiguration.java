package com.example.juiceFruit.swagger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	@Bean
	public Docket detalheApi() {

		Docket docket = new Docket(DocumentationType.SWAGGER_2);

		docket.select().apis(RequestHandlerSelectors.basePackage("com.example.juiceFruit")).paths(PathSelectors.any())
				.build().apiInfo(this.informacoesApi().build());

		return docket;
	}

	private ApiInfoBuilder informacoesApi() {
		 
		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
 
		apiInfoBuilder.title("API - JuiceFuit:");
		apiInfoBuilder.description("Aluno: Professor estou cansado!!! Tio Carlos: Porque macho?... você estava capinando mato?");
		 
		apiInfoBuilder.version("1.0");
		apiInfoBuilder.termsOfServiceUrl("Termo de uso: Projeto Final Web - Tio Carlos.");
		apiInfoBuilder.license("Projeto Final - Tio Carlos");
		apiInfoBuilder.licenseUrl("https://www.dropbox.com/home/Aplicativos/My.DropPages/tiocarlos.mysite.droppages.com/Public?preview=TioCarlos.pdf");
		apiInfoBuilder.build();
 
		return apiInfoBuilder;
}
	
}