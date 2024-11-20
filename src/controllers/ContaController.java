package controllers;

import views.ContaView;
import models.Conta;
import dao.ContaDAO;

public class ContaController {

    private ContaDAO contaDAO;

    public ContaController() {
        this.contaDAO = new ContaDAO();  // Inicializa o DAO de Conta
    }

    // adiciona nova conta
    public void adicionarConta(String numero, String saldoText, String tipo) {
        try {
            double saldo = Double.parseDouble(saldoText);
            Conta novaConta = new Conta(numero, saldo, tipo);
            boolean sucesso = contaDAO.inserir(novaConta);
            if (sucesso) {
                JOptionPane.showMessageDialog(null, "Conta adicionada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao adicionar conta.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "O saldo deve ser um número válido!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // edita conta exitente
    public void editarConta(String numero, String saldoText, String tipo) {
        try {
            double saldo = Double.parseDouble(saldoText);
            Conta contaEditada = new Conta(numero, saldo, tipo);  // Atualiza os dados
            boolean sucesso = contaDAO.atualizar(contaEditada);
            if (sucesso) {
                JOptionPane.showMessageDialog(null, "Conta editada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao editar conta.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "O saldo deve ser um número válido!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // exclui conta
    public void excluirConta(String numero) {
        boolean sucesso = contaDAO.excluir(numero);
        if (sucesso) {
            JOptionPane.showMessageDialog(null, "Conta excluída com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao excluir conta.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Lista as contas
    public void listarContas() {
        List<Conta> contas = contaDAO.buscarTodos();
        if (contas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há contas cadastradas.", "Informação", JOptionPane.INFORMATION_MESSAGE);
        } else {
            for (Conta conta : contas) {
                System.out.println(conta);
            }
        }
    }
}
