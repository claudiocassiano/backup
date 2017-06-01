/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projetopi.DAO;

import Projetopi.model.Cliente;
import java.util.List;
/**
 *
 * @author Claudio Cassiano
 */
public interface interfaceCliente {

    public Cliente getCliente(Long id);

    public void adicionar(Cliente cliente);

    public void excluir(Cliente cliente);

    public void atualizar(Cliente cliente);

    public List<Cliente> list();

}
