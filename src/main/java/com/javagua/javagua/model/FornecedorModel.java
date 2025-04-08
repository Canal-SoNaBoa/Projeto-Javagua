package com.javagua.javagua.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity // Indica que essa classe é uma entidade do banco de dados
@Table(name = "Tb_fornecedores") // Define o nome da nossa tabela no banco "Tb_fornecedores"
public class FornecedorModel {
    
    @Id // Identificador único do fornecedor (chave primária)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Id será gerado automaticamente pelo banco
    private Long id;
    

    @Column(nullable = false) // nullable = false ( tornando obrigatório passar valor no campo )
    private String nome; // Nome do fornecedor 

    
    @Column(nullable = false, unique = true)  // unique = true ( não pode repetir no banco )
    private String cnpj; // CNPJ do fornecedor – obrigatório e único 

    // Email do fornecedor – opcional
    private String email;

    // Telefone do fornecedor – opcional
    private String telefone;

    // Data em que o fornecedor foi cadastrado – gerado automaticamente com a data atual
    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro = LocalDateTime.now();

    //                               Construtores

    // Construtor vazio (obrigatório para o JPA funcionar corretamente)
    public FornecedorModel() {}


    // Construtor com argumentos – facilita a criação de objetos com dados
    public FornecedorModel(String nome, String cnpj, String email, String telefone) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone = telefone;
        this.dataCadastro = LocalDateTime.now();
    }


    //              Métodos getters e setters – permitem acessar e alterar os dados do objeto
    //              Getters - É um método de acesso que permite ler o valor de um atributo de uma classe.
    //              Setters - É um método que define ou atualiza o valor de um atributo de uma classe. 

    
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
