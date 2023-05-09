package com.rsabank.rsabank.controller;

import com.rsabank.rsabank.model.Conta;
import com.rsabank.rsabank.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContaController {

    @Autowired
    private ContaService contaService;

    @PostMapping("conta/criarConta")
    void criarConta(Conta conta){
        contaService.saveConta(conta);
    }

    @PostMapping("conta/transferir")
    void transferir(double valor, Long contaTransfereId, Long contaRecebeId ){
        contaService.transferir(valor, contaTransfereId, contaRecebeId);
    }

    @PostMapping("conta/sacar")
    void sacar(Double valor, Long contaId){
        contaService.sacar(valor, contaId);
    }

    @GetMapping("conta/consultaSaldoPoupanca")
    Double consultaSaldoPoupanca(Long contaId){
        return contaService.consultaSaldoPoupanca(contaId);
    }
}
