/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.pizzaria.repository;

import br.com.pizzaria.pizzaria.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author joliveira
 */
@Repository
public interface UserRepository extends CrudRepository<Usuario, Long> {
    
}
