package com.rsabank.rsabank.Impl;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSAImpl {

    PublicKey chavePublica;
    PrivateKey chavePrivada;

    public RSAImpl() {
        try {
            gerarChaves();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    private void gerarChaves() throws NoSuchAlgorithmException {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        SecureRandom sr = new SecureRandom();
        kpg.initialize(2048, sr);
        KeyPair kp = kpg.generateKeyPair();
        chavePublica = kp.getPublic();
        String strChavePublica =
                Base64
                        .getEncoder()
                        .encodeToString(chavePublica.getEncoded());
        System.out.println("Chave pública: " + strChavePublica);
        chavePrivada = kp.getPrivate();
        String strChavePrivada =
                Base64
                        .getEncoder()
                        .encodeToString(chavePrivada.getEncoded());
        System.out.println("Chave privada: " + strChavePrivada);
    }
    public byte[] cifrar(String msg) throws NoSuchAlgorithmException
            , NoSuchPaddingException
            , InvalidKeyException
            , IllegalBlockSizeException
            , BadPaddingException
    {

        Cipher cifrador = Cipher.getInstance("RSA");
        cifrador.init(Cipher.ENCRYPT_MODE, chavePrivada);
        byte[] bytesMsgCifrada =
                cifrador
                        .doFinal(msg.getBytes());


        System.out.println("Mensagem cifrada = " + Arrays.toString(bytesMsgCifrada));
        return bytesMsgCifrada;
    }
    public String decifrar(byte[] bytesMsgCifrada) throws NoSuchAlgorithmException
            , NoSuchPaddingException
            , InvalidKeyException
            , IllegalBlockSizeException
            , BadPaddingException
    {
        Cipher decifrador = Cipher.getInstance("RSA");
        decifrador.init(Cipher.DECRYPT_MODE, chavePublica);


        byte[] bytesMsgDecifrada =
                decifrador
                        .doFinal(bytesMsgCifrada);

        String msgDecifrada = new String(bytesMsgDecifrada);
        System.out.println("Mensagem decifrada = "+msgDecifrada);
        return msgDecifrada;
    }
}

