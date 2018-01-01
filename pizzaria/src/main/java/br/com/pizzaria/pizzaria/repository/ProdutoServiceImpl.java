/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.pizzaria.repository;

import br.com.pizzaria.pizzaria.entity.Produto;
import br.com.pizzaria.pizzaria.service.ProdutoService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author joliveira
 */
@Repository
public class ProdutoServiceImpl implements ProdutoService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Produto> listarClientside() {
        Query query = entityManager.createQuery(
                "SELECT p FROM Produto p "
                + "WHERE p.enabledProduto = true");
        return query.getResultList();
    }

    @Override
    public List<Produto> listarBackoffice() {
        Query query = entityManager.createQuery(
                "SELECT p FROM Produto p");
        return query.getResultList();
    }

    @Override
    public List<Produto> listarPorTipo(String tipo) {
        Query query = entityManager.createQuery(
                "SELECT p FROM Produto p "
                + "WHERE p.tipoProduto = :tipo").setParameter("tipo", tipo);
        return query.getResultList();
    }

    @Override
    public Produto obter(Long codigoProduto) {
        Query query = entityManager.createQuery(
                "SELECT p FROM Produto p "
                + "WHERE p.codigoProduto = :id").setParameter("id", codigoProduto);
        return (Produto) query.getSingleResult();
    }

    @Override
    @Transactional
    public void incluir(Produto produto) {
        entityManager.persist(produto);
    }

    @Override
    @Transactional
    public void alterar(Produto produto) {
        entityManager.merge(produto);
    }

    @Override
    public void remover(Long codigoProduto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Produto> pesquisar(String pesquisa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
