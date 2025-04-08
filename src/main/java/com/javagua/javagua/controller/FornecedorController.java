package com.javagua.javagua.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javagua.javagua.model.FornecedorModel;
import com.javagua.javagua.repository.FornecedorRepository;

@RestController // // @RestController = Indica que essa classe é um controller REST, ou seja, que responderá a requisições HTTP (ex: GET, POST)
@RequestMapping("/fornecedores") // @RequestMapping = Define o caminho base para as rotas dessa controller 
//                                  [ http://localhost:8080/fornecedores ]
public class FornecedorController {
    
    // Injeção de dependência: estamos dizendo para o Spring criar uma instância do repository
    // e entregar aqui automaticamente (sem precisar instanciar com "new")
    private final FornecedorRepository fornecedorRepository;

    // Construtor que recebe o repository via injeção de dependência (boa prática)
    public FornecedorController(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }


    // Método POST = Usado para cadastrar um novo fornecedor
    // @RequestBody = Diz ao Spring para pegar o JSON que vem na requisição e transformar em um FornecedorModel
    @PostMapping(value = "/cadastrar")    
    public FornecedorModel cadastrarFornecedor(@RequestBody FornecedorModel fornecedor) {
        return fornecedorRepository.save(fornecedor); // Salva o fornecedor no banco e retorna o que foi salvo
        // http://localhost:8080/fornecedores/cadastrar
    }

    // Método GET = Usado para listar todos os fornecedores cadastrados
    @GetMapping(value = "/listar")
    public List<FornecedorModel> listarFornecedores() {
        return fornecedorRepository.findAll(); // Busca todos os fornecedores no banco de dados
        // http://localhost:8080/fornecedores/listar
    }


    // Método PUT = Edita um fornecedor existente
    // @PathVariable = Captura o {id} da URL
    // URL: http://localhost:8080/fornecedores/editar/1
    @PutMapping("/editar/{id}")
    public FornecedorModel editarFornecedor(@PathVariable Long id, @RequestBody FornecedorModel fornecedorAtualizado) {
        // Verifica se o fornecedor com o ID existe
        Optional<FornecedorModel> fornecedorOptional = fornecedorRepository.findById(id);

        if (fornecedorOptional.isPresent()) {
            // Se existe, atualiza os dados
            FornecedorModel fornecedorExistente = fornecedorOptional.get();
            fornecedorExistente.setNome(fornecedorAtualizado.getNome());
            fornecedorExistente.setCnpj(fornecedorAtualizado.getCnpj());
            fornecedorExistente.setEmail(fornecedorAtualizado.getEmail());

            return fornecedorRepository.save(fornecedorExistente); // Salva e retorna o atualizado
        } else {
            return null; // Em uma próxima etapa, podemos retornar um erro 404 customizado
        }
    }

    // Método DELETE = Remove um fornecedor pelo ID
    // URL: http://localhost:8080/fornecedores/deletar/1
    @DeleteMapping("/deletar/{id}")
    public void deletarFornecedor(@PathVariable Long id) {
        fornecedorRepository.deleteById(id); // Remove o fornecedor pelo ID
    }

}





// Dica DevSoNaBoa :

// "Aqui a gente usa injeção de dependência via construtor. Isso melhora a testabilidade,
//  evita problemas com reflexão e ajuda a manter o código mais limpo e seguro, principalmente
//  em sistemas maiores. Mas em projetos menores, pode usar @Autowired no campo que também vai funcionar."