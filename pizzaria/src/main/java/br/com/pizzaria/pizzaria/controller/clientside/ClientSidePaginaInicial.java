/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.pizzaria.controller.clientside;

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
@RequestMapping("/")
public class ClientSidePaginaInicial {
    
    @Autowired
    private ProdutoService produtoService;
    
    @RequestMapping
    public ModelAndView abrirTelaInicial() {
        List<Produto> pizzas = produtoService.listarPorTipo("Pizza");
        List<Produto> bebidas = produtoService.listarPorTipo("Bebida");
        List<Produto> promocoes = produtoService.listarPorTipo("Promo");
        return new ModelAndView("clientside/paginaInicialClientside")
                .addObject("promocoes", promocoes)
                .addObject("pizzas", pizzas)
                .addObject("bebidas", bebidas);
    }
}
