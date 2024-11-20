package views;

import controllers.ClienteController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteView extends JFrame {

    private JTextField txtNome, txtCpf, txtEndereco;
    private JButton btnAdicionar, btnEditar, btnExcluir, btnListar;

    private ClienteController clienteController;

    public ClienteView() {
        setTitle("Gerenciar Clientes");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        clienteController = new ClienteController();

        // layout e componentes
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(4, 2));

        painel.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        painel.add(txtNome);

        painel.add(new JLabel("CPF:"));
        txtCpf = new JTextField();
        painel.add(txtCpf);

        painel.add(new JLabel("Endereço:"));
        txtEndereco = new JTextField();
        painel.add(txtEndereco);

        btnAdicionar = new JButton("Adicionar");
        btnEditar = new JButton("Editar");
        btnExcluir = new JButton("Excluir");
        btnListar = new JButton("Listar");

        painel.add(btnAdicionar);
        painel.add(btnEditar);
        painel.add(btnExcluir);
        painel.add(btnListar);


        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clienteController.adicionarCliente(txtNome.getText(), txtCpf.getText(), txtEndereco.getText());
            }
        });

        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clienteController.editarCliente(txtNome.getText(), txtCpf.getText(), txtEndereco.getText());
            }
        });

        btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clienteController.excluirCliente(txtCpf.getText());
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clienteController.listarClientes();
            }
        });


        add(painel, BorderLayout.CENTER);
    }
}
