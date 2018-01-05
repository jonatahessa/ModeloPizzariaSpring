/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.pizzaria.controller.backoffice;

import br.com.pizzaria.pizzaria.entity.Usuario;
import br.com.pizzaria.pizzaria.service.UsuarioService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author joliveira
 */
@Controller
public class GerenciaAcessos {
    
    @Autowired
    UsuarioService userService;

    @RequestMapping("/login")
    public ModelAndView login() {

        return new ModelAndView("backoffice/unicos/telaLogin");
    }

    @RequestMapping("/login-error")
    public ModelAndView loginError() {
        return new ModelAndView("backoffice/unicos/telaLogin").addObject("erro", "Usuário ou senha incorretos!");
    }

    @RequestMapping("/trocarsenha")
    public ModelAndView trocaSenha() {
        
        return new ModelAndView("backoffice/unicos/trocaDeSenha");
    }
    
    @RequestMapping(value = "/salvarsenha", method = RequestMethod.POST)
    public ModelAndView salvarSenha(@RequestParam("senha") String senha,
            @RequestParam("senhaconfirm") String confirmaSenha, RedirectAttributes attributes) {
        if (!senha.equals(confirmaSenha)) {
            
            return new ModelAndView("backoffice/unicos/trocaDeSenha").addObject("erro", "As senhas não são iguais!");
        }        
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession sessao = request.getSession();
        Long idUser = (Long) sessao.getAttribute("idUser");
        Usuario usuario = userService.obter(idUser);
        
        System.out.println(usuario.getLoginUser());
        System.out.println(usuario.getEnabledUser());
        System.out.println(usuario.getCodigoUser());
        System.out.println(usuario.getRoleUser());
        System.out.println(usuario.getEnabledUser());
        
        
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(senha);
            usuario.setPasswordUser(hashedPassword);
            userService.alterar(usuario);
            
            return new ModelAndView("redirect:/manutencao");
    }
}
