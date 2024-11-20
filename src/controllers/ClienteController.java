package controllers;

import views.ClienteView;
import models.Cliente;
import dao.ClienteDAO;

public class ClienteController {

    private ClienteDAO clienteDAO;

    public ClienteController() {
        this.clienteDAO = new ClienteDAO();
    }

    // Adiciona cliente
    public void adicionarCliente(String nome, String cpf, String endereco) {
        Cliente novoCliente = new Cliente(nome, cpf, endereco);
        boolean sucesso = clienteDAO.inserir(novoCliente);
        if (sucesso) {
            JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar cliente.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // edita cliente existente
    public void editarCliente(String nome, String cpf, String endereco) {
        Cliente clienteEditado = new Cliente(nome, cpf, endereco);
        boolean sucesso = clienteDAO.atualizar(clienteEditado);
        if (sucesso) {
            JOptionPane.showMessageDialog(null, "Cliente editado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao editar cliente.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // excluib cliente
    public void excluirCliente(String cpf) {
        boolean sucesso = clienteDAO.excluir(cpf);
        if (sucesso) {
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao excluir cliente.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // lista os clientes
    public void listarClientes() {
        List<Cliente> clientes = clienteDAO.buscarTodos();
        if (clientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há clientes cadastrados.", "Informação", JOptionPane.INFORMATION_MESSAGE);
        } else {
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }
    }
}
