package com.kaibacorp.labpadroesprojetosspring.core.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(info =
@Info(title = "Cliente ",
        version = "v1",
        description = "Aplicação feita para Cadastrar clientes" +
                " consultando seus endereços pro meio de um banco de dados externo"))
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new io.swagger.v3.oas.models.info.Info()
                                .title("Cliente-API ")
                                .version("v1")
                                .license( new License().
                                        name("Apache 2.0").
                                        url("http://springdoc.org")
                                )
                );
    }
}
