package com.example;

public class AppClasses {
    public static void main(String[] args) {
        System.out.println("oi");

        Cliente cliente = new Cliente();
        cliente.setAnoNascimento(1978);

        cliente.setRenda(10000);
        cliente.setSexo('M'); 

        System.out.println("Renda: " + cliente.getRenda() );
        System.out.println("Sexo: " + cliente.getSexo() );
        System.out.println("Ano: " + cliente.getAnoNascimento() );




        
    }
    
}


