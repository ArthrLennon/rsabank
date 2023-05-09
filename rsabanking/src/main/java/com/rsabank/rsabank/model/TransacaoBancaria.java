package com.rsabank.rsabank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "transacaoBancaria")
public class TransacaoBancaria {

    @Id
    @GeneratedValue
    private Long id;

    private Conta contaCliente;

    private String transacao;

    private Date data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Conta getContaCliente() {
        return contaCliente;
    }

    public void setContaCliente(Conta contaCliente) {
        this.contaCliente = contaCliente;
    }

    public String getTransacao() {
        return transacao;
    }

    public void setTransacao(String transacao) {
        this.transacao = transacao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
