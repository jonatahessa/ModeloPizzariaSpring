/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.pizzaria.controller.backoffice;

import br.com.pizzaria.pizzaria.entity.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author joliveira
 */

@Controller
public class GerenciaAcessos {
    
    @RequestMapping("/login")
    public ModelAndView login() {
        
        return new ModelAndView("backoffice/unicos/telaLogin");
    }
    
    @RequestMapping("/login-error")
    public ModelAndView loginError() {
        return new ModelAndView("backoffice/unicos/telaLogin").addObject("erro", "Usuário ou senha incorretos!");
    }
}
