package br.com.desafioAttornatus.ApiPessoas.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ConfigSwagger {


     // utilizei a anotação bean para poder injetar em qualquer classe/método
    @Bean
    public OpenAPI springBlogPessoalOpenAPI() {
        // gera documentação Swagger
        return new OpenAPI().info(new Info().title("Avaliação Dev Backend Java").description("Desafio prático").version("v1.0") // Versão do projeto
                .license(new License().name("Alexandre Simões").url("https://www.linkedin.com/in/lexsimoes/")) // Informações  da empresa
                .contact(new Contact().name("Alexandre Simões").url("https://github.com/lexsimoes").email("lexsimoes@yahoo.com"))).externalDocs(new ExternalDocumentation().description("LinkedIn").url("https://www.linkedin.com/in/lexsimoes"));
    }

    
    // personaliza mensagens para as respostas HTTP
    @Bean
    public OpenApiCustomiser customerGlobalHeaderOpenApiCustomiser() {
        return openApi -> {
            openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {
                ApiResponses apiResponses = operation.getResponses();

                apiResponses.addApiResponse("200", createApiResponse("Sucesso!"));
                apiResponses.addApiResponse("201", createApiResponse("Objeto persistido!"));
                apiResponses.addApiResponse("204", createApiResponse("Objeto excluído!"));
                apiResponses.addApiResponse("400", createApiResponse("Erro na requisição!"));
                apiResponses.addApiResponse("401", createApiResponse("Acesso não autorizado!"));
                apiResponses.addApiResponse("404", createApiResponse("Objeto não encontrado!"));
                apiResponses.addApiResponse("500", createApiResponse("Erro na aplicação!"));
            }));
        };
    }


    // adiciona uma mensagem a cada resposta HTTP
    private ApiResponse createApiResponse(String message) {
        return new ApiResponse().description(message);
    }
}
