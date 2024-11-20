package models;

import java.util.Date;

public class Conta {
    private int id;
    private String numeroConta;
    private double saldo;
    private String tipoConta;
    private Date dataCriacao;

    // Criando o construtor
    public Conta() {}

    // construtor
    public Conta(int id, String numeroConta, double saldo, String tipoConta, Date dataCriacao) {
        this.id = id;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.tipoConta = tipoConta;
        this.dataCriacao = dataCriacao;
    }

    // metodos get e set
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    //credito
    public void creditar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        }
    }

    //Debito
    public boolean debitar(double valor) {
        if (valor > 0 && valor <= saldo) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }
}
