package com.javagua.javagua.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Indica que essa classe é uma entidade do banco de dados
public class FornecedorModel {

    @Id // Identificador único do fornecedor (chave primária)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Id será gerado automaticamente pelo banco
    private Long id;

    private String nome; // Nome do fornecedor

    private String cnpj; // CNPJ do fornecedor

    private String email; // Email do fornecedor

    private String telefone; // Telefone do fornecedor

    // Data em que o fornecedor foi cadastrado
    private LocalDateTime dataCadastro = LocalDateTime.now();

    // Construtores

    // Construtor vazio (obrigatório para o JPA funcionar corretamente)
    public FornecedorModel() {
    }

    // Construtor com argumentos – facilita a criação de objetos com dados
    public FornecedorModel(String nome, String cnpj, String email, String telefone) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone = telefone;
        this.dataCadastro = LocalDateTime.now();
    }

    // Métodos getters e setters – permitem acessar e alterar os dados do objeto
    // Getters - É um método de acesso que permite ler o valor de um atributo de uma
    // classe.
    // Setters - É um método que define ou atualiza o valor de um atributo de uma
    // classe.

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

}
