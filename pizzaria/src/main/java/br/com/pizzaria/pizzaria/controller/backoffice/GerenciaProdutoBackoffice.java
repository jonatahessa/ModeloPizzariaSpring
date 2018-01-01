/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.pizzaria.controller.backoffice;

import br.com.pizzaria.pizzaria.entity.Produto;
import br.com.pizzaria.pizzaria.service.ProdutoService;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author joliveira
 */
@Controller
@RequestMapping("/manutencao")
public class GerenciaProdutoBackoffice {

    @Autowired
    private ProdutoService produtoService;

    @RequestMapping
    public ModelAndView abrirTelaInicialBackoffice() {
        List<Produto> produtos = produtoService.listarBackoffice();
        return new ModelAndView("backoffice/unicos/listaDeProdutos").addObject("produtos", produtos);
    }

    @RequestMapping("/novo")
    public ModelAndView abrirTelaNovoBackoffice() {
        return new ModelAndView("backoffice/unicos/produtoAdicionarAlterar").addObject("produto", new Produto());
    }
    
    @RequestMapping("/editar/{id}")
    public ModelAndView abrirTelaEditarBackoffice(@PathVariable("id") Long idProduto) {
        Produto produto = produtoService.obter(idProduto);
        return new ModelAndView("backoffice/unicos/produtoAdicionarAlterar").addObject("produto", produto);
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public ModelAndView salvar(
            @ModelAttribute("produto") @Valid Produto p,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("backoffice/unicos/produtoAdicionarAlterar")
                    .addObject("produto", p);
        }
        boolean inclusao = (p.getCodigoProduto() == null);

        if (inclusao) {
            p.setEnabledProduto(true);
            produtoService.incluir(p);
        } else {
            produtoService.alterar(p);
        }

        redirectAttributes.addFlashAttribute("msgSucesso",
                "Produto " + p.getNomeProduto() + " cadastrado com sucesso");
        return new ModelAndView("redirect:/manutencao");
    }

    @RequestMapping(value = "/ativar", method = RequestMethod.POST)
    public void ativarProduto(Long id) {
        Produto produto = produtoService.obter(id);
        produto.setEnabledProduto(Boolean.TRUE);
        produtoService.alterar(produto);
    }

    @RequestMapping(value = "/desativar", method = RequestMethod.POST)
    public void desativarProduto(Long id) {
        Produto produto = produtoService.obter(id);
        produto.setEnabledProduto(Boolean.FALSE);
        produtoService.alterar(produto);
    }
}
