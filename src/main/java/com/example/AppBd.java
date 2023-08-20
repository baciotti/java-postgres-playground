package com.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.dao.ConnectionManager;
import com.example.dao.EstadoDAO;
import com.example.dao.ProdutoDAO;
import com.example.model.Marca;
import com.example.model.Produto;

public class AppBd {
    public static void main(String[] args) {
        new AppBd();
    
    }

    public AppBd(){
        try(var conn = ConnectionManager.getConnection()){  
            var estadoDAO = new EstadoDAO(conn);                          
            estadoDAO.listar();
            estadoDAO.localizar("MG");  
            
            
            var dao = new DAO(conn);
            dao.listar("produto") ;            // Método genérico de busca

            var marca = new Marca();
            marca.setId(1L);

            var produto = new Produto();
            produto.setMarca(marca);
            produto.setNome("teste");
            produto.setValor(500.7);
            produto.setId(208L);
            
            var produtoDAO = new ProdutoDAO(conn);
            //produtoDAO.inserir(produto);
           produtoDAO.alterar(produto);
           produtoDAO.excluir(202L);
            
        } catch (SQLException e) {
                System.err.println("Não foi possível conectar ao banco de dados: " + e.getMessage());

    }

    }



   
   



    private  void carregarDriverJDBC() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {            
            System.err.println("Não foi possível carregar a biblioteca para acesso ao banco de dados: " + e.getMessage());
        }
    }
}
