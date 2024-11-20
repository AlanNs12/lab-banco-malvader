package views;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private String tipoUsuario;

    public MainFrame(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
        setTitle("Menu Principal");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // menu
        JMenuBar menuBar = new JMenuBar();

        if (tipoUsuario.equals("funcionario")) {

            JMenu menuFuncionario = new JMenu("Funcionário");
            JMenuItem itemAberturaConta = new JMenuItem("Abertura de Conta");
            JMenuItem itemEncerrarConta = new JMenuItem("Encerrar Conta");
            JMenuItem itemConsultaDados = new JMenuItem("Consulta de Dados");
            JMenuItem itemAlteracaoDados = new JMenuItem("Alteração de Dados");
            JMenuItem itemCadastroFuncionario = new JMenuItem("Cadastro de Funcionários");
            JMenuItem itemRelatorios = new JMenuItem("Geração de Relatórios");
            JMenuItem itemSair = new JMenuItem("Sair");


            JMenu submenuAbertura = new JMenu("Abertura de Conta");
            JMenuItem itemContaPoupanca = new JMenuItem("Conta Poupança");
            JMenuItem itemContaCorrente = new JMenuItem("Conta Corrente");
            submenuAbertura.add(itemContaPoupanca);
            submenuAbertura.add(itemContaCorrente);


            menuFuncionario.add(submenuAbertura);
            menuFuncionario.add(itemEncerrarConta);
            menuFuncionario.add(itemConsultaDados);
            menuFuncionario.add(itemAlteracaoDados);
            menuFuncionario.add(itemCadastroFuncionario);
            menuFuncionario.add(itemRelatorios);
            menuFuncionario.add(itemSair);

            itemAberturaConta.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(MainFrame.this, "Abrindo conta...");
                }
            });

            itemEncerrarConta.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    JOptionPane.showMessageDialog(MainFrame.this, "Encerrando conta...");
                }
            });

            itemConsultaDados.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    JOptionPane.showMessageDialog(MainFrame.this, "Consultando dados...");
                }
            });

            itemAlteracaoDados.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    JOptionPane.showMessageDialog(MainFrame.this, "Alterando dados...");
                }
            });

            itemCadastroFuncionario.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    JOptionPane.showMessageDialog(MainFrame.this, "Cadastrando funcionário...");
                }
            });

            itemRelatorios.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Lógica para gerar relatórios
                    JOptionPane.showMessageDialog(MainFrame.this, "Gerando relatórios...");
                }
            });

            itemSair.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);  // Encerra o programa
                }
            });

            menuBar.add(menuFuncionario);
        } else if (tipoUsuario.equals("cliente")) {
            // menu Cliente
            JMenu menuCliente = new JMenu("Cliente");
            JMenuItem itemSaldo = new JMenuItem("Consultar Saldo");
            JMenuItem itemDeposito = new JMenuItem("Depositar");
            JMenuItem itemSaque = new JMenuItem("Sacar");
            JMenuItem itemExtrato = new JMenuItem("Extrato");
            JMenuItem itemLimite = new JMenuItem("Consultar Limite");
            JMenuItem itemSair = new JMenuItem("Sair");

            menuCliente.add(itemSaldo);
            menuCliente.add(itemDeposito);
            menuCliente.add(itemSaque);
            menuCliente.add(itemExtrato);
            menuCliente.add(itemLimite);
            menuCliente.add(itemSair);

            itemSaldo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Lógica para consultar saldo
                    JOptionPane.showMessageDialog(MainFrame.this, "Consultando saldo...");
                }
            });

            itemDeposito.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Lógica para realizar depósito
                    JOptionPane.showMessageDialog(MainFrame.this, "Depositando...");
                }
            });

            itemSaque.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Lógica para realizar saque
                    JOptionPane.showMessageDialog(MainFrame.this, "Sacando...");
                }
            });

            itemExtrato.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Lógica para exibir extrato
                    JOptionPane.showMessageDialog(MainFrame.this, "Exibindo extrato...");
                }
            });

            itemLimite.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Lógica para consultar limite
                    JOptionPane.showMessageDialog(MainFrame.this, "Consultando limite...");
                }
            });

            itemSair.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);  // Encerra o programa
                }
            });

            menuBar.add(menuCliente);
        }

        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame("funcionario").setVisible(true);  // Teste para funcionário
            }
        });
    }
}
