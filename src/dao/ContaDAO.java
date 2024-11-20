package dao;

import database.DatabaseConnection;
import models.Conta;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContaDAO {

    // inserir uma nova conta
    public boolean inserir(Conta conta) {
        String sql = "INSERT INTO contas (numero_conta, saldo, tipo_conta, data_criacao) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, conta.getNumeroConta());
            stmt.setDouble(2, conta.getSaldo());
            stmt.setString(3, conta.getTipoConta());
            stmt.setDate(4, new java.sql.Date(conta.getDataCriacao().getTime()));

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // busca geral
    public List<Conta> buscarTodas() {
        List<Conta> contas = new ArrayList<>();
        String sql = "SELECT * FROM contas";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Conta conta = new Conta();
                conta.setId(rs.getInt("id"));
                conta.setNumeroConta(rs.getString("numero_conta"));
                conta.setSaldo(rs.getDouble("saldo"));
                conta.setTipoConta(rs.getString("tipo_conta"));
                conta.setDataCriacao(rs.getDate("data_criacao"));
                contas.add(conta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contas;
    }

    // Busca conta pelo id
    public Conta buscarPorId(int id) {
        String sql = "SELECT * FROM contas WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Conta(
                            rs.getInt("id"),
                            rs.getString("numero_conta"),
                            rs.getDouble("saldo"),
                            rs.getString("tipo_conta"),
                            rs.getDate("data_criacao")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // atualizar uma conta
    public boolean atualizar(Conta conta) {
        String sql = "UPDATE contas SET numero_conta = ?, saldo = ?, tipo_conta = ?, data_criacao = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, conta.getNumeroConta());
            stmt.setDouble(2, conta.getSaldo());
            stmt.setString(3, conta.getTipoConta());
            stmt.setDate(4, new java.sql.Date(conta.getDataCriacao().getTime()));
            stmt.setInt(5, conta.getId());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // remove a conta
    public boolean remover(int id) {
        String sql = "DELETE FROM contas WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
