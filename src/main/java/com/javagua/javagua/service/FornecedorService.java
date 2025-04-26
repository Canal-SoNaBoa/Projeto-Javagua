package com.javagua.javagua.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javagua.javagua.model.FornecedorModel;
import com.javagua.javagua.repository.FornecedorRepository;

// Service. É o responsável por conter a lógica de negócio da aplicação.

@Service // Marca a classe como um serviço do Spring
public class FornecedorService {

    // Injeção de dependência: o Spring vai criar automaticamente uma instância do
    // FornecedorRepository
    // para que possamos usar aqui dentro da classe sem precisar instanciar
    // manualmente.
    @Autowired
    private FornecedorRepository fornecedorRepository;

    // Método responsável por cadastrar um novo fornecedor no banco de dados
    public FornecedorModel cadastrarFornecedor(FornecedorModel fornecedor) {

        // Chama o método save do repository, salvando o fornecedor no banco e
        // retornando o objeto salvo
        return fornecedorRepository.save(fornecedor);

    }

    // Método responsável por listar todos os fornecedores cadastrados no banco
    public List<FornecedorModel> listarFornecedores() {
        // Chama o método findAll ( Encontrar tudo) do repository, buscando todos os
        // registros da tabela
        // de fornecedores
        return fornecedorRepository.findAll();
    }

    // Método responsável por editar (atualizar) os dados de um fornecedor existente
    public FornecedorModel editarFornecedor(Long id, FornecedorModel fornecedorAtualizado) {

        // Busca o fornecedor pelo ID informado, encapsulado dentro de um Optional
        Optional<FornecedorModel> fornecedorOptional = fornecedorRepository.findById(id);

        // Verifica se o fornecedor foi encontrado (se está presente no banco)
        if (fornecedorOptional.isPresent()) {
            // Obtém o fornecedor existente a partir do Optional
            FornecedorModel fornecedorExistente = fornecedorOptional.get();

            // Atualiza os dados do fornecedor existente com os dados recebidos no corpo da
            // requisição
            fornecedorExistente.setNome(fornecedorAtualizado.getNome());
            fornecedorExistente.setCnpj(fornecedorAtualizado.getCnpj());
            fornecedorExistente.setEmail(fornecedorAtualizado.getEmail());

            // Salva novamente o fornecedor atualizado no banco de dados
            return fornecedorRepository.save(fornecedorExistente);
        } else {
            // Se o fornecedor não for encontrado, retorna null
            // (em breve, podemos melhorar lançando uma exceção personalizada para tratar
            // esse caso)
            return null;
        }
    }

    // Método responsável por deletar (remover) um fornecedor do banco de dados pelo
    // ID
    public void deletarFornecedor(Long id) {
        // Chama o método deleteById do repository, removendo o fornecedor
        // correspondente ao ID informado
        fornecedorRepository.deleteById(id);
    }

}
