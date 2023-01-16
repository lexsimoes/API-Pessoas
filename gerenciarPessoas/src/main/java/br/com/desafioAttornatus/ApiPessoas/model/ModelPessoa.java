package br.com.desafioAttornatus.ApiPessoas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="PESSOAS")
public class ModelPessoa {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "PESSOA_ID")
  private Long pessoaId;
  private String nome;
  private String dataNascimento;

  // tabelas

  @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
  @JsonIgnoreProperties("pessoa")
  private List<ModelEndereco> endereco;


  // método construtor de pessoas
  public ModelPessoa(){

  }

  // criando setters e getters

  public ModelPessoa(Long pessoaId, String nome, String dataNascimento){
    this.pessoaId = pessoaId;
    this.nome = nome;
    this.dataNascimento = dataNascimento;
  }

  public Long getPessoaId(){
    return pessoaId;
  }

  public void setPessoaId(Long pessoaId){
    this.pessoaId = pessoaId;
  }

  public String getNome(){
    return nome;
  }

  public void setNome(String nome){
    this.nome = nome;
  }

  public String getDataNascimento(){
    return dataNascimento;
  }

  public void setDataNascimento(String dataNascimento){
    this.dataNascimento = dataNascimento;
  }

  public List<ModelEndereco> getEndereco(){
    return endereco;
  }

  public void setEndereco(List<ModelEndereco> endereco){
    this.endereco = endereco;
  }



}
