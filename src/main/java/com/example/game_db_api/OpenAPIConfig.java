package com.example.game_db_api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("API de Gerenciamento de Jogos")
                        .description("API para gerenciar informações sobre jogos. Agenda pessoal de jogos")
                        .version("v1.0.0")
                        .contact(new Contact().name("Maria Eduarda").email("seuemail@example.com")
                                .url("https://github.com/DudaSheep")));
    }
}
