package br.com.desafioAttornatus.ApiPessoas.repository;

import br.com.desafioAttornatus.ApiPessoas.model.ModelEndereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<ModelEndereco, Long> {
}
