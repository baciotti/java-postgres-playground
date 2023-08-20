package com.example.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class DAO {
    public Connection conn;
    

    public void listar(String tabela) {
        var sql ="select * from " + tabela;
        //System.out.println(sql);
        try {
            var statement = conn.createStatement();
            var result = statement.executeQuery(sql);
            var metadata = result.getMetaData();
            int cols = metadata.getColumnCount();

            for (int i = 1; i <= cols; i++) {
                System.out.printf("%-25s | ", metadata.getColumnName(i));                    
            }
            System.out.println();

            while(result.next()){
                
                for (int i = 1; i <= cols; i++) {
                    System.out.printf("%-25s | ", result.getString(i));                    
                }

                System.out.println();

            }
        } catch (SQLException e) {            
            System.err.println("erro" );
        }


    }

}
