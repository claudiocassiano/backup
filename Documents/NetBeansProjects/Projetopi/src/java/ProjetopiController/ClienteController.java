/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetopiController;

import Projetopi.model.Cliente;
import Projetopi.DAO.ClienteDAO;
import Projetopi.DAO.interfaceCliente;
import java.util.Collection;
import java.util.Iterator;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import java.util.List;
import java.util.ListIterator;
import javax.faces.event.ActionEvent;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Claudio Cassiano
 */
@ManagedBean
@SessionScoped
public class ClienteController {

    private Cliente cliente;
    private DataModel listaCliente;

    public Cliente getCliente() {
        if (this.cliente == null) {
            this.cliente = new Cliente();
        }
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public DataModel getListaCliente() {
        List<Cliente> lista = new ClienteDAO().list();
        listaCliente = new ListDataModel(lista);
        return listaCliente;

    }

    public void prepararAdicionarCliente(ActionEvent actionEvent) {
        cliente = new Cliente();
    }

    public void prepararAlterarCliente(ActionEvent actionEvent) {
        cliente = (Cliente) (listaCliente.getRowData());
    }

    
    public void adicionar(Cliente cliente) {
        interfaceCliente dao = new ClienteDAO();
        dao.adicionar(cliente);
        this.cliente = new Cliente();
        
    }
    public void alterar(ActionEvent actionEvent) {
        interfaceCliente dao = new ClienteDAO();
        dao.atualizar(cliente);
    }

    public String excluir(Cliente cliente) {
        Cliente Cliente = (Cliente)(listaCliente.getRowData());
        interfaceCliente dao = new ClienteDAO();
        dao.excluir(cliente);
        return "index";
        
    }
}
