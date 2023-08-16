package com.example;

public class Cliente {
    private double renda;    
    private char sexo;
    private int anoNascimento;  
    private boolean especial;
    private String nome;
    private String cpf;
    

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isEspecial() {
        return especial;
    }

   public String getNome() {
    return nome;
}


public void setNome(String nome) {
    this.nome = nome.toUpperCase();
}


 public void setEspecial(boolean especial) {
        this.especial = especial;
    }



    // Construtor não tem tipo
    public Cliente() {
        double aleatorio = Math.random();
        if (aleatorio > 0.5) {
            especial = true;            
        }


    }

        // Construtor não tem tipo
        public Cliente(double renda) {
            this();
            double aleatorio = Math.random();    
        }




    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        if (sexo == 'M' || sexo == 'F') {
            this.sexo = sexo;
            
        } else {
            System.out.println("sexo inválido");
        }

        
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }    

    public double getRenda() {
        return renda;
    }

    public void setRenda(double renda) {
        if (renda >= 0) {
            this.renda = renda;                
        } else {
            System.out.println("deve ser positiva");        
        }
        
    }

}