package br.com.desafioAttornatus.ApiPessoas.repository;

import br.com.desafioAttornatus.ApiPessoas.model.ModelEndereco;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EnderecoRepositoryTest {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @BeforeAll
    void start(){
        enderecoRepository.save(new ModelEndereco(0,"Rua aruja","07020240","12","Guarulhos", true));
        enderecoRepository.save(new ModelEndereco(1,"Av Paulista","07020241","123","Sao Paulo", true ));
        enderecoRepository.save(new ModelEndereco(2,"rua dos Parentes","07020242","124","Jarinu", true));
        enderecoRepository.save(new ModelEndereco(3,"Rua Lucas","07020243","125","Atibaia", false));
    }

    @Test
    @DisplayName("Retorna lista")
    public void deveRetornarSelistaPreenchida(){
        List<ModelEndereco> listaEnderecos = enderecoRepository.findAll();
        assertTrue(!listaEnderecos.isEmpty());
    }

    @Test
    @DisplayName("Encontra 2 cidades")
    public void retornaDuasCidades(){
        List<ModelEndereco> listaDeEndereco = enderecoRepository.findAll();
        assertEquals(3,listaDeEndereco.size());
        assertTrue(listaDeEndereco.get(0).getCidade().equals("Guarulhos"));
        assertTrue(listaDeEndereco.get(1).getCidade().equals("Sao Paulo"));
    }

    @Test
    @DisplayName("Endereco principal")
    public void enderecoPrincipal(){
        List<ModelEndereco> listaDeEndereco = enderecoRepository.findAll();
        assertEquals(3, listaDeEndereco.size());
        assertTrue(listaDeEndereco.get(0).isEndPrincipal() == true);
        assertTrue(listaDeEndereco.get(2).isEndPrincipal() == false);
    }







    @AfterAll
    public void end() {
        enderecoRepository.deleteAll();
    }
}
