/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.pizzaria.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author joliveira
 */
@Entity
@Table(name = "TB_PRODUTO")
public class Produto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUTO")
    private Long codigoProduto;
    
    @NotBlank
    @Size(max = 50, message = "O nome é obrigatório!")
    @Column(name = "NM_PRODUTO", length = 50, nullable = false)
    private String nomeProduto;
    
    @NotBlank
    @Size(max = 1000, message = "A descrição é obrigatória!")
    @Column(name = "DS_PRODUTO", length = 1000, nullable = false)
    private String descricaoProduto;
    
    @NotNull
    @DecimalMin(value = "0.01", message = "Preço inválido!")
    @Digits(integer = 6, fraction = 2, message = "Preço inválido!")
    @Column(name = "VL_PRODUTO", precision = 6, scale = 2, nullable = false)
    private BigDecimal valorProduto;
    
    @NotBlank
    @Size(max = 30)
    @Column(name = "TP_PRODUTO", length = 30, nullable = false)
    private String tipoProduto;
    
    @NotNull
    @Column(name = "EN_PRODUTO", nullable = false)
    private Boolean enabledProduto;

    public Produto() {
    }
    
    public Long getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(Long codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public BigDecimal getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(BigDecimal valorProduto) {
        this.valorProduto = valorProduto;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public Boolean getEnabledProduto() {
        return enabledProduto;
    }

    public void setEnabledProduto(Boolean enabledProduto) {
        this.enabledProduto = enabledProduto;
    }
    
    
    
    
}
