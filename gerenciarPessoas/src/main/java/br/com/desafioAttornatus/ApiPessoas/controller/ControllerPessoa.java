package br.com.desafioAttornatus.ApiPessoas.controller;

import br.com.desafioAttornatus.ApiPessoas.model.ModelPessoa;
import br.com.desafioAttornatus.ApiPessoas.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/pessoas")
@CrossOrigin(origins = "*")
public class PessoaController {

    @Autowired
    private PessoaRepository repository;

    @GetMapping
    public ResponseEntity<List<ModelPessoa>> trazerTodos() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModelPessoa> trazerPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<ModelPessoa>> trazerPorNome(@PathVariable String nome) {
        return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
    }

    @PostMapping("/criar")
    public ResponseEntity<ModelPessoa> post(@Validated @RequestBody ModelPessoa pessoa) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(pessoa));
    }

    @PutMapping("/editar")
    public ResponseEntity<ModelPessoa> put(@Validated @RequestBody ModelPessoa pessoa) {
        return repository.findById(pessoa.getPessoaId())
                .map(resp -> ResponseEntity.ok().body(repository.save(pessoa)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
