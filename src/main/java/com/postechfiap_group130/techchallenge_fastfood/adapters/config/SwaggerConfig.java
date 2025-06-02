package com.postechfiap_group130.techchallenge_fastfood.adapters.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Techchallenge_fastfood API")
                        .version("1.0")
                        .description("Documentação da API com Swagger"));
    }
}
