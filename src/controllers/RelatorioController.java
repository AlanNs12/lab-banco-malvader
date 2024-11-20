package controllers;

import views.RelatorioView;
import models.Conta;
import dao.ContaDAO;

public class RelatorioController {

    private ContaDAO contaDAO;

    public RelatorioController() {
        this.contaDAO = new ContaDAO();  // Inicializa o DAO de Conta
    }

    // gera relatório de saldos
    public String gerarRelatorio() {
        List<Conta> contas = contaDAO.buscarTodos();
        double totalSaldos = 0;
        StringBuilder relatorio = new StringBuilder("Relatório de Saldos:\n");

        for (Conta conta : contas) {
            totalSaldos += conta.getSaldo();
            relatorio.append("Conta: ").append(conta.getNumero())
                    .append(" - Saldo: ").append(conta.getSaldo())
                    .append("\n");
        }

        relatorio.append("\nTotal de Saldos: ").append(totalSaldos);
        return relatorio.toString();
    }
}
