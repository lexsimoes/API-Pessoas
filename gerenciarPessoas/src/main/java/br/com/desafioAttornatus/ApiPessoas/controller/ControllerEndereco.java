package br.com.desafioAttornatus.ApiPessoas.controller;

import br.com.desafioAttornatus.ApiPessoas.model.ModelEndereco;
import br.com.desafioAttornatus.ApiPessoas.repository.EnderecoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/enderecos")
@CrossOrigin(origins = "*")
public class EnderecoController {

    @Autowired
    private EnderecoRepository repository;

    @GetMapping
    public ResponseEntity<List<ModelEndereco>> trazerTodos() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModelEndereco> trazerPorId(@PathVariable Long id){
        return repository.findById(id)
                .map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/criar")
    public ResponseEntity<ModelEndereco> post(@Validated @RequestBody ModelEndereco endereco){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(endereco));
    }

    @PutMapping("/editar")
    public ResponseEntity<ModelEndereco> put(@Validated @RequestBody ModelEndereco endereco){
        return repository.findById(endereco.getEnderecoId())
                .map(resp -> ResponseEntity.ok().body(repository.save(endereco)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
