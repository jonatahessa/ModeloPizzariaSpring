/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pizzaria.pizzaria.repository;

import br.com.pizzaria.pizzaria.entity.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import br.com.pizzaria.pizzaria.service.UsuarioService;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author joliveira
 */
@Repository
public class UserServiceImpl implements UsuarioService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Usuario> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> listarPorRole(String roleUser) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario obter(Long codigoUser) {
        Query query = entityManager.createQuery(
                "SELECT u FROM Usuario u "
                + "WHERE u.codigoUser = :id").setParameter("id", codigoUser);
        return (Usuario) query.getSingleResult();
    }

    @Override
    public Usuario obterPorName(String name) {
        Query query = entityManager.createQuery("SELECT u FROM Usuario u WHERE u.loginUser = :username").setParameter("username", name);
        Usuario user = (Usuario) query.getSingleResult();
        if (user == null) {
            return null;
        }
        return user;
    }

    @Override
    public void incluir(Usuario user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public void alterar(Usuario user) {
        entityManager.merge(user);
    }

    @Override
    public void remover(Long codigoUser) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> pesquisar(String pesquisa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
