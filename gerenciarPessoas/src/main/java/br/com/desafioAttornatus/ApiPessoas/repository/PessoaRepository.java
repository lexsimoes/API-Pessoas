package br.com.desafioAttornatus.ApiPessoas.repository;

import br.com.desafioAttornatus.ApiPessoas.model.ModelPessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PessoaRepository extends JpaRepository<ModelPessoa, Long> {

  public Optional<ModelPessoa> findByNome(String nome);
  public List<ModelPessoa> findAllByNomeContainingIgnoreCase(String nome);
}
