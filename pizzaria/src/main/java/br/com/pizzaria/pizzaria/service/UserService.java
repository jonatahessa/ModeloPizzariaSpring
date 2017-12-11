/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.pizzaria.service;

import br.com.pizzaria.pizzaria.entity.User;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author joliveira
 */
public interface UserService extends Serializable {
    
    public List<User> listar();
    
    public List<User> listarPorRole(String roleUser);
    
    public User obter(Long codigoUser);
    
    public void incluir(User user);
    
    public void alterar(User user);
    
    public void remover(Long codigoUser);
    
    public List<User> pesquisar(String pesquisa);
}
