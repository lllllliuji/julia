package com.lzw.julia.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI().info(new io.swagger.v3.oas.models.info.Info()
                .description("julia 描述")
                .version("1.0.0")
                .contact(new Contact().name("lllllliuji@qq.com"))
                .title("julia 接口文档"));
    }

}

