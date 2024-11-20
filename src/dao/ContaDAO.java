package dao;

import models.Conta;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContaDAO {
    private Connection conexao;

    public ContaDAO() {
        try {
            // banco de dados
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/seu_banco", "seu_usuario", "sua_senha");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean inserir(Conta conta) {
        String sql = "INSERT INTO contas (numero_conta, saldo, tipo_conta, data_criacao) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, conta.getNumeroConta());
            stmt.setDouble(2, conta.getSaldo());
            stmt.setString(3, conta.getTipoConta());
            stmt.setDate(4, new java.sql.Date(conta.getDataCriacao().getTime()));
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean atualizar(Conta conta) {
        String sql = "UPDATE contas SET numero_conta = ?, saldo = ?, tipo_conta = ? WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, conta.getNumeroConta());
            stmt.setDouble(2, conta.getSaldo());
            stmt.setString(3, conta.getTipoConta());
            stmt.setInt(4, conta.getId());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean remover(int id) {
        String sql = "DELETE FROM contas WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Conta> buscarTodas() {
        List<Conta> contas = new ArrayList<>();
        String sql = "SELECT * FROM contas";
        try (Statement stmt = conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Conta conta = new Conta(
                        rs.getInt("id"),
                        rs.getString("numero_conta"),
                        rs.getDouble("saldo"),
                        rs.getString("tipo_conta"),
                        rs.getDate("data_criacao")
                );
                contas.add(conta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contas;
    }

    public List<Conta> buscarComFiltros(String numero, String tipo, Double saldoMin, Double saldoMax) {
        List<Conta> contas = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM contas WHERE 1=1");

        // filtros dinamicos
        if (numero != null && !numero.isEmpty()) {
            sql.append(" AND numero_conta = ?");
        }
        if (tipo != null && !tipo.isEmpty()) {
            sql.append(" AND tipo_conta = ?");
        }
        if (saldoMin != null) {
            sql.append(" AND saldo >= ?");
        }
        if (saldoMax != null) {
            sql.append(" AND saldo <= ?");
        }

        try (PreparedStatement stmt = conexao.prepareStatement(sql.toString())) {
            int index = 1;

            if (numero != null && !numero.isEmpty()) {
                stmt.setString(index++, numero);
            }
            if (tipo != null && !tipo.isEmpty()) {
                stmt.setString(index++, tipo);
            }
            if (saldoMin != null) {
                stmt.setDouble(index++, saldoMin);
            }
            if (saldoMax != null) {
                stmt.setDouble(index++, saldoMax);
            }

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Conta conta = new Conta(
                        rs.getInt("id"),
                        rs.getString("numero_conta"),
                        rs.getDouble("saldo"),
                        rs.getString("tipo_conta"),
                        rs.getDate("data_criacao")
                );
                contas.add(conta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contas;
    }
}
