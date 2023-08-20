package com.example;

import com.example.model.Cliente;

public class AppOperadoresRelacionais {
    public static void main(String[] args) {
        var cliente1 = new Cliente();
        var cliente2 = new Cliente();

        cliente1.setAnoNascimento(1980);
        cliente2.setAnoNascimento(2001);

        if (cliente1.getAnoNascimento() == cliente2.getAnoNascimento() ) {
            System.out.println("é o mesmo ano");            
        } else {
            System.out.println("não é o mesmo ano");            
        }



        
    }
}
