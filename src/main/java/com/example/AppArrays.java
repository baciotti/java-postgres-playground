package com.example;

import java.util.Arrays;

public class AppArrays {
    public static void main(String[] args) {
        int x = 10;
        System.out.println(x);

        int vetorInt[] = {1,2,3};

        double vetor[] = {10, 20, 30};

        //vetor = vetorInt;

        System.out.println(Arrays.toString(vetor));
        
        System.out.println("Valor da posição 0: " + vetor[0]);

        int vetor3[] = new int[4];

        for (int i = 0; i <vetor3.length; i++){

        }
        


        //double matriz[][] = {{10,20,30}, {40,50,60}};

        double matriz[][] = new double[2][3];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = (i * matriz[i].length + j+1) * 10;
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println(matriz[i][j] + " ");
            }
            System.out.println();
        }


        System.out.println(Arrays.toString(matriz[0]));
        System.out.println(Arrays.toString(matriz[1]));

        matriz[0][1] = 888;

        System.out.println(Arrays.toString(matriz[0]));





    }
}
