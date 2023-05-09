package com.rsabank.rsabank.service;

import com.rsabank.rsabank.model.Conta;
import com.rsabank.rsabank.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public void saveConta(Conta conta){
        contaRepository.save(conta);
    }

    public void transferir(Double valor, Long contaTransfereId, Long contaRecebeId){

        Conta pagador = contaRepository.findContaById(contaTransfereId);
        Conta recebedor = contaRepository.findContaById(contaRecebeId);

        if(valor < pagador.getValorPoupanca() && valor > 0){
            recebedor.setValorPoupanca(recebedor.getValorPoupanca() + valor);
            pagador.setValorPoupanca(pagador.getValorPoupanca() - valor);
        }

    }

    public void sacar(Double valor, Long contaId){
       Conta conta = contaRepository.findContaById(contaId);

       if(conta.getValorPoupanca() > valor)
           conta.setValorPoupanca(conta.getValorPoupanca() - valor);
    }


    public void depositar(Double valor, Long contaId){
        Conta conta = contaRepository.findContaById(contaId);

        if(conta.getValorPoupanca() > valor && valor > 0)
            conta.setValorPoupanca(conta.getValorPoupanca() + valor);
    }

    public double consultaSaldoPoupanca(Long contaId){
        Conta conta = contaRepository.findContaById(contaId);
        Double saldo = conta.getValorPoupanca();

        return saldo;
    }

    public double consultaSaldoRendaFixa(Long contaId){
        Conta conta = contaRepository.findContaById(contaId);
        Double saldo = conta.getValorRendaFixa();

        return saldo;
    }


}
