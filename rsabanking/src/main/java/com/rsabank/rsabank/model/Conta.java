package com.rsabank.rsabank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "conta")
public class Conta {

    @Id
    @GeneratedValue
    private long id;

    private long conta;

    private String password;

    private String nomeProprietario;

    private String cpfProprietario;

    private String telefoneProprietario;

    private Date nascimentoProprietario;

    private Double valorPoupanca;

    private Double valorRendaFixa;

    public String getTelefoneProprietario() {
        return telefoneProprietario;
    }

    public void setTelefoneProprietario(String telefoneProprietario) {
        this.telefoneProprietario = telefoneProprietario;
    }

    public Double getValorPoupanca() {
        return valorPoupanca;
    }

    public void setValorPoupanca(Double valorPoupanca) {
        this.valorPoupanca = valorPoupanca;
    }

    public Double getValorRendaFixa() {
        return valorRendaFixa;
    }

    public void setValorRendaFixa(Double valorRendaFixa) {
        this.valorRendaFixa = valorRendaFixa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getConta() {
        return conta;
    }

    public void setConta(long conta) {
        this.conta = conta;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNomeProprietario() {
        return nomeProprietario;
    }

    public void setNomeProprietario(String nomeProprietario) {
        this.nomeProprietario = nomeProprietario;
    }

    public String getCpfProprietario() {
        return cpfProprietario;
    }

    public void setCpfProprietario(String cpfProprietario) {
        this.cpfProprietario = cpfProprietario;
    }

    public Date getNascimentoProprietario() {
        return nascimentoProprietario;
    }

    public void setNascimentoProprietario(Date nascimentoProprietario) {
        this.nascimentoProprietario = nascimentoProprietario;
    }
}
