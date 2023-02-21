package com.mini.money.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
public class SwaggerConfig{
    private static final String REFERENCE = "Bearer";
    @Bean
    public Docket api() {
        Server serverLocal = new Server("local", "http://localhost:8080", "for local", Collections.emptyList(), Collections.emptyList());
//        Server devServer = new Server("test", "http://52.78.32.230:8080/", "for test", Collections.emptyList(), Collections.emptyList());
        return new Docket(DocumentationType.OAS_30)
                .servers(serverLocal)
                .apiInfo(swaggerInfo())
                .groupName("6조 미니 프로젝트")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mini.money"))
                .paths(PathSelectors.any())
                .build()
                .ignoredParameterTypes(AuthenticationPrincipal.class)
                .securityContexts(List.of(securityContext()))
                .securitySchemes(List.of(bearerAuthSecurityScheme()));
    }


    private ApiInfo swaggerInfo() {
        return new ApiInfoBuilder()
                .title("6조 미니 프로젝트")
                .description("금융상품 추천 서비스 API")
                .license("")
                .version("1.0")
                .build();
    }


    private HttpAuthenticationScheme bearerAuthSecurityScheme() {
        return HttpAuthenticationScheme.JWT_BEARER_BUILDER
                .name(REFERENCE).build();
    }

    //JWT SecurityContext 구성
    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEveryThing");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference(REFERENCE, authorizationScopes));
    }
}
