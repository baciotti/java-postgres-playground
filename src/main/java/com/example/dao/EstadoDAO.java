package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class EstadoDAO {
    private Connection conn;

    public EstadoDAO(Connection conn) {
        this.conn = conn;
    }


    public  void listar() {    
        //Statement statement = null;

        try{        
            var statement = conn.createStatement();
            var result = statement.executeQuery("select * from estado;");    

            while(result.next()){
                System.out.printf("Id: %d Nome: %s UF: %s\n", result.getInt("id"), result.getString("nome"), result.getString("uf") );    
            }
        } catch (SQLException e ) {
            System.err.println("erro");
        }
    }

    public  void localizar(String uf) {
        try {
            //var statement = conn.createStatement();
            // var sql = "select * from estado where uf = '" + uf + "'";

            var sql = "select * from estado where uf = ?";
            var statement = conn.prepareStatement(sql);
            statement.setString(1, uf);

            //System.out.println(sql);
            var result = statement.executeQuery();
            if(result.next()){
                System.out.printf("Nome: %s\n", result.getString("nome"));
            }

        } catch (SQLException e) {
            
            System.err.println("erro ao executar a consulta sql ");
        }


    }

}