package br.com.desafioAttornatus.ApiPessoas.repository;

import br.com.desafioAttornatus.ApiPessoas.model.ModelPessoa;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PessoaRepositoryTest {

    @Autowired
    private PessoaRepository pessoaRepository;

    @BeforeAll
    void start(){
        pessoaRepository.save(new ModelPessoa(0L, "alexandre simoes", "25/09/1990"));
        pessoaRepository.save(new ModelPessoa(0L, "Thais Simoes", "03/05/1992"));
        pessoaRepository.save(new ModelPessoa(0L, "Jose Simoes", "23/02/1960"));
        pessoaRepository.save(new ModelPessoa(1L, "Silvia Mendes", "03/028/1962"));

    }


    @Test
    @DisplayName("Retorna 1 id")
    public void deveRetornarUmId(){
        Optional<ModelPessoa> pessoa = pessoaRepository.findById(1L);
        assertTrue(pessoa.get().getPessoaId().equals(1L));

    }

    @Test
    @DisplayName("Retorna lista")
    public void deveRetornarSelistaPreenchida(){
        List<ModelPessoa> listaPessoa = pessoaRepository.findAll();
        assertTrue(!listaPessoa.isEmpty());
    }

    @AfterAll
    public void end() {
        pessoaRepository.deleteAll();
    }
}
