/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.pizzaria.controller.backoffice;

import br.com.pizzaria.pizzaria.entity.Produto;
import br.com.pizzaria.pizzaria.service.ProdutoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author joliveira
 */
@Controller
@RequestMapping("/backoffice/produto")
public class GerenciaProdutoBackoffice {
    
    @Autowired
    private ProdutoService produtoService;
    
    @RequestMapping
    public ModelAndView abrirTelaInicialBackoffice() {
        List<Produto> produtos = produtoService.listar();
        return new ModelAndView("backoffice/listaDeProdutos").addObject("produtos", produtos);
    }
    
    @RequestMapping("/novo")
    public ModelAndView abrirTelaNovoBackoffice() {
        return new ModelAndView("backoffice/unicos/produtoAdicionarAlterar").addObject("produto", new Produto());
    }
    
    @RequestMapping("/salvar")
    public ModelAndView salvarProduto() {
        return new ModelAndView("");
    }
}
