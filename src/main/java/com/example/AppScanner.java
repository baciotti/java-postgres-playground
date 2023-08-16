package com.example;

import java.util.Scanner;

public class AppScanner {
    public static void main(String[] args) {
        System.out.println("oi");

        Cliente cliente = new Cliente();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome: ");
        cliente.setNome(scanner.nextLine());


        cliente.setAnoNascimento(1978);

        cliente.setRenda(10000);
        cliente.setSexo('M'); 
        //cliente.setNome("Tiago Bacciotti");
        cliente.setCpf("00113051697");

        String[] vetorNome = cliente.getNome().split(" ");

        System.out.println("Renda: " + cliente.getRenda() );
        System.out.println("Sexo: " + cliente.getSexo() );
        System.out.println("Ano: " + cliente.getAnoNascimento() );
        System.out.println("Especial: " + cliente.isEspecial() );
        System.out.println("Nome: " +  vetorNome[1]);
        System.out.println("Cpf: " + cliente.getCpf() );

        String cpf2 = new String("00113051697");

        if( cliente.getCpf().equals(cpf2) ) {
            System.out.println("É o mesmo CPF");
        }







        
    }
    
}


