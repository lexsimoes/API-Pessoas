package br.com.desafioAttornatus.ApiPessoas.controller;



import br.com.desafioAttornatus.ApiPessoas.model.ModelEndereco;
import br.com.desafioAttornatus.ApiPessoas.repository.EnderecoRepository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EnderecoControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private EnderecoRepository repository;

    @Test
    @Order(1)
    @DisplayName("test1")
    public void deveCriarUmEndereco(){
        HttpEntity<ModelEndereco> requisicao = new HttpEntity<ModelEndereco>(
                new ModelEndereco(0l, "Rua Aruja", "07020240","72","Guarulhos",true)
        );

        ResponseEntity<ModelEndereco> resposta = testRestTemplate.exchange("/enderecos/criar", HttpMethod.POST,
                requisicao, ModelEndereco.class);

        assertEquals(HttpStatus.CREATED, resposta.getStatusCode());
        assertEquals(requisicao.getBody().getCep(), resposta.getBody().getCep());

    }

}
