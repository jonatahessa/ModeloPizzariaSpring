/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.pizzaria.service;

import br.com.pizzaria.pizzaria.entity.Produto;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author joliveira
 */
public interface ProdutoService extends Serializable {
    
    public List<Produto> listarClientside();
    
    public List<Produto> listarBackoffice();
    
    public List<Produto> listarPorTipo(String tipo);
    
    public Produto obter(Long codigoProduto);
    
    public void incluir(Produto produto);
    
    public void alterar(Produto produto);
    
    public void remover(Long codigoProduto);
    
    public List<Produto> pesquisar(String pesquisa);
}
