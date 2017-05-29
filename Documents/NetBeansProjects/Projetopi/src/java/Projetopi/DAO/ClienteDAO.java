/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projetopi.DAO;

import Projetopi.model.Cliente;
import Projetopi.util.HibernateUtil;
import static java.util.Collections.list;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Claudio Cassiano
 */
public class ClienteDAO implements interfaceCliente {

    @Override
    public Cliente getCliente(Long id) {
        Session ss = HibernateUtil.getSessionFactory().getCurrentSession();
        return (Cliente) ss.load(Cliente.class, id);

    }

    @Override
    public void salvar(Cliente cliente) {
        Session ss = HibernateUtil.getSessionFactory().getCurrentSession();

        Transaction t = null;
        if (!ss.getTransaction().isActive()) {
            t = ss.beginTransaction();
        } else {
            t = ss.getTransaction();
        }

        ss.save(cliente);
        t.commit();

    }

    @Override
    public void excluir(Cliente cliente) {
        
        Session ss = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction t = ss.beginTransaction();
        ss.delete(cliente);
        t.commit();

    }
  
    @Override
    public void atualizar(Cliente cliente) {
        Session ss = HibernateUtil.getSessionFactory().getCurrentSession();
        ss.beginTransaction();
        ss.update(cliente);
        ss.beginTransaction().commit();

    }

    @Override
    public List<Cliente> list() {
         HibernateUtil.getSessionFactory().getCurrentSession().close();
         
         Session ss =  HibernateUtil.getSessionFactory().openSession();
        
        List lista = ss.createQuery("From cliente ").list();
        
        return lista;

    }

}
