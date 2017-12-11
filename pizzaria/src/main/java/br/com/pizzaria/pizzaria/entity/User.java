/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.pizzaria.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author joliveira
 */
@Entity
@Table(name = "TB_USER")
public class User implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USER")
    private Long codigoUser;
    
    @NotBlank(message = "O Login é obrigatório!")
    @Size(min = 6, max = 20, message = "O login deve conter no mínimo 6 e no máximo 20 caractéres!")
    @Column(name = "LG_USER", length = 20, nullable = false)
    private String loginUser;
    
    @NotBlank(message = "A senha é obrigatória!")
    @Size(min = 8, max = 20, message = "A senha deve conter no mínimo 8 e no máximo 20 caractéres!")
    @Column(name = "PW_USER", length = 20, nullable = false)
    private String passwordUser;
    
    @NotBlank(message = "O grupo de acesso do usuário é obrigatório!")
    @Size(max = 10, message = "O grupo de acesso do usuário deve conter no máximo 10 caractéres!")
    @Column(name = "RL_USER")
    private String roleUser;

    public User() {
    }

    public Long getCodigoUser() {
        return codigoUser;
    }

    public void setCodigoUser(Long codigoUser) {
        this.codigoUser = codigoUser;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public String getRoleUser() {
        return roleUser;
    }

    public void setRoleUser(String roleUser) {
        this.roleUser = roleUser;
    }
    
    
    
}
