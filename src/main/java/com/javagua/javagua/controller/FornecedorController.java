package com.javagua.javagua.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javagua.javagua.model.FornecedorModel;
import com.javagua.javagua.service.FornecedorService;

@RestController // // @RestController = Indica que essa classe é um controller REST, ou seja,
                // que responderá a requisições HTTP (ex: GET, POST)
@RequestMapping("/fornecedores") // @RequestMapping = Define o caminho base para as rotas dessa controller
// [ http://localhost:8080/fornecedores ]
public class FornecedorController {

    // Injeção de dependência: estamos dizendo para o Spring criar uma instância do
    // e entregar aqui automaticamente (sem precisar instanciar com "new")
    @Autowired
    private FornecedorService fornecedorService;

    // Teste inicial de controller
    // Endpoint: http://localhost:8080/fornecedores
    @GetMapping
    public String testarAcesso() {
        return "Acesso FornecedorController - Ok " + java.time.LocalDateTime.now();
    }

    // Método POST = Usado para cadastrar um novo fornecedor
    // @RequestBody = Diz ao Spring para pegar o JSON que vem na requisição e
    // transformar em um FornecedorModel
    @PostMapping(value = "/cadastrar")
    public FornecedorModel cadastrarFornecedor(@RequestBody FornecedorModel fornecedor) {
        return fornecedorService.cadastrarFornecedor(fornecedor);
        // http://localhost:8080/fornecedores/cadastrar
    }

    // Método GET = Usado para listar todos os fornecedores cadastrados
    @GetMapping(value = "/listar")
    public List<FornecedorModel> listarFornecedores() {
        return fornecedorService.listarFornecedores(); // Busca todos os fornecedores no banco de dados
        // http://localhost:8080/fornecedores/listar
    }

    // Método PUT = Edita um fornecedor existente
    // @PathVariable = Captura o {id} da URL
    // URL: http://localhost:8080/fornecedores/editar/1
    @PutMapping("/editar/{id}")
    public FornecedorModel editarFornecedor(@PathVariable Long id, @RequestBody FornecedorModel fornecedorAtualizado) {
        return fornecedorService.editarFornecedor(id, fornecedorAtualizado);
    }

    // Método DELETE = Remove um fornecedor pelo ID
    // URL: http://localhost:8080/fornecedores/deletar/1
    @DeleteMapping("/deletar/{id}")
    public void deletarFornecedor(@PathVariable Long id) {
        fornecedorService.deletarFornecedor(id); // Remove o fornecedor pelo ID
    }

}
