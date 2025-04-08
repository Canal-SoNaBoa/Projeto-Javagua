package com.javagua.javagua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javagua.javagua.model.FornecedorModel;

// Interface  = Proporciona uma ligação física ou lógica entre dois sistemas ou partes de um sistema que não
// poderiam ser conectados diretamente.

// ( Dependencia JPA)
// Ela herda de JpaRepository, que já vem com métodos como save, findAll, findById, delete... 

// extends = Significa "estende". Aqui, indica que FornecedorRepository está herdando comportamentos prontos
// da interface JpaRepository. Com isso ganhamos vários métodos úteis automaticamente, sem precisar implementar nada.

public interface FornecedorRepository extends JpaRepository< FornecedorModel, Long>{
    
    // Aqui iremos criar métodos personalizados em breve... 
    
}
