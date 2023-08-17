package com.example;

import java.util.ArrayList;
import java.util.List;

public class AppListas {
    public static void main(String[] args) {
        //Cliente[] vetorClientes = new Cliente[5];
        List<Cliente> listaClientes = new ArrayList<>();


        boolean minhavariavel = true;

        String nome = "Tiago";

        int idade;
        idade =45;

        // cast conversão de tipo

        char sexo = 'M';

        double idade2;
        idade2 = (double)idade;

        

        System.out.println("O nome é " + nome);




        var cliente1 = new Cliente();
        cliente1.setNome("Tiago");

        var cliente2 = new Cliente();
        cliente2.setNome("Mauriza");

        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.remove(0);
        listaClientes.remove(cliente1);
        for (Cliente cliente : listaClientes) {
            System.out.println(cliente);
            
        }

      listaClientes.remove(cliente1);







    }
}
