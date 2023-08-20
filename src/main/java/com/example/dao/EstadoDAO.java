package com.example.dao;

import com.example.model.Estado;    

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class EstadoDAO {
    private Connection conn;

    public EstadoDAO(Connection conn) {
        this.conn = conn;
    }


    public  List<Estado> listar() throws SQLException {            
        var lista = new LinkedList<Estado>();
        var statement = conn.createStatement();
        var result = statement.executeQuery("select * from estado;");    
        while(result.next()){
            var estado = new Estado();
            estado.setId(result.getLong("id"));
            estado.setNome(result.getString("nome"));       
            lista.add(estado);
        }        

            return lista;
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
