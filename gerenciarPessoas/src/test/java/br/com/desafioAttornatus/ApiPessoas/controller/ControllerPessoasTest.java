package br.com.desafioAttornatus.ApiPessoas.controller;

import br.com.desafioAttornatus.ApiPessoas.model.ModelPessoa;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PessoaControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;


    @Test
    @Order(1)
    @DisplayName("Criar pessoa")
    public void deveCriarUmaPessoa() {
        HttpEntity<ModelPessoa> requisicao = new HttpEntity<ModelPessoa>(
                new PessoaModel(0L, "Alexandre", "25/09/1990")
        );

        ResponseEntity<ModelPessoa> resposta = testRestTemplate.exchange("/pessoas/criar", HttpMethod.POST,
                requisicao, PessoaModel.class);

        assertEquals(HttpStatus.CREATED, resposta.getStatusCode());

    }
}
