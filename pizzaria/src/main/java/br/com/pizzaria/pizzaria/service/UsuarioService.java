/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.pizzaria.service;

import br.com.pizzaria.pizzaria.entity.Usuario;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author joliveira
 */
public interface UsuarioService extends Serializable {
    
    public List<Usuario> listar();
    
    public List<Usuario> listarPorRole(String roleUser);
    
    public Usuario obter(Long codigoUser);
    
    public Usuario obterPorName(String name);
    
    public void incluir(Usuario user);
    
    public void alterar(Usuario user);
    
    public void remover(Long codigoUser);
    
    public List<Usuario> pesquisar(String pesquisa);
}
