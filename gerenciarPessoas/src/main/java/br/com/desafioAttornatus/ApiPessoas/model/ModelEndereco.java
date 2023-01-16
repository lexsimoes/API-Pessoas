package br.com.desafioAttornatus.ApiPessoas.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;

import javax.persistence.*;

@Entity
@Table(name="ENDEREÇOS")
public class ModelEndereco {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long enderecoId;
  private String logradouro;
  private String cep;
  private String numero;
  private String cidade;
  private boolean enderecoPrincipal;

  // criar relação das tabelas

  @ManyToOne
  @JsonIgnoreProperties("endereco")
  private ModelPessoa pessoa;

  // cria método construtor

  public ModelEndereco(){

  }
  public ModelEndereco(Long enderecoId, String logradouro, String cep, String numero, String cidade, boolean enderecoPrincipal){
    this.enderecoId = enderecoId;
    this.logradouro = logradouro;
    this.cep = cep;
    this.numero = numero;
    this.cidade = cidade;
    this.enderecoPrincipal = enderecoPrincipal;
  }

  // cria setters e getters para o modelo de endereços

  public Long getEnderecoId(){
    return enderecoId;
  }
  public void setEnderecoId(Long enderecoId){
    this.enderecoId = enderecoId;
  }
  public String getLogradouro() {
    return logradouro;
  }

  public void setLogradouro(String logradouro) {
      this.logradouro = logradouro;
  }

  public String getCep() {
      return cep;
  }

  public void setCep(String cep) {
      this.cep = cep;
  }

  public String getNumero() {
      return numero;
  }

  public void setNumero(String numero) {
      this.numero = numero;
  }

  public String getCidade() {
      return cidade;
  }

  public void setCidade(String cidade) {
      this.cidade = cidade;
  }

  public boolean isEndPrincipal() {
      return endPrincipal;
  }

  public void setEndPrincipal(boolean endPrincipal) {
      this.endPrincipal = endPrincipal;
  }

  public ModelPessoa getPessoa() {
      return pessoa;
  }

  public void setPessoa(ModelPessoa pessoa) {
      this.pessoa = pessoa;
  }
}
