package com.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AppBd {
    private static final String PASSWORD = "";
    private static final String USERNAME = "gitpod";
    private static final String JDBC_URL = "jdbc:postgresql://localhost/postgres";
    //private Connection conn;

    public static void main(String[] args) {
        new AppBd();
    
    }

    public AppBd(){
        try(var conn = getConnection()){                
            //carregarDriverJDBC();
            listarEstados(conn);
            localizarEstado(conn, "MG");  
            
            
            listarDadosTabela(conn, "produto") ;            // Método genérico de busca

            var marca = new Marca();
            marca.setId(1L);

            var produto = new Produto();
            produto.setMarca(marca);
            produto.setNome("teste");
            produto.setValor(500.7);
            produto.setId(208L);
            
            //inserirProduto(conn, produto);
            alterarProduto(conn, produto);

            excluirProduto(conn, 202L);
            
        } catch (SQLException e) {
                System.err.println("Não foi possível conectar ao banco de dados: " + e.getMessage());

    }

    }


    private void excluirProduto(Connection conn, long id) {
        var sql = "delete from produto where id = ?";
        //var statement;
        try {
            var statement = conn.prepareStatement(sql);
            statement.setLong(1, id);
            if (statement.executeUpdate() ==1)
               System.out.println("prod excluido");
            else 
                System.out.println("prod não excluído");
        ;
        } catch (SQLException e) {
            System.err.println("erro ao excluir: " + e.getMessage());
        }
        





    }

    private void inserirProduto(Connection conn, Produto produto) {
        var sql = "insert into produto (nome,marca_id, valor) values (?, ?, ?)";
        
        try (var statement = conn.prepareStatement(sql)) {
            statement.setString(1, produto.getNome());
            statement.setLong(2, produto.getMarca().getId());
            statement.setDouble(3, produto.getValor());
            statement.executeUpdate();

        } catch (SQLException e) {
            System.err.println("erro: " + e.getMessage() );

        }
        

    
    }


    private void alterarProduto(Connection conn, Produto produto) {
        var sql = "update produto set nome = ?, marca_id = ?, valor = ? where id = ?";
        
        try (var statement = conn.prepareStatement(sql)) {
            statement.setString(1, produto.getNome());
            statement.setLong(2, produto.getMarca().getId());
            statement.setDouble(3, produto.getValor());
            statement.setLong(4, produto.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            System.err.println("erro: " + e.getMessage() );

        }
        

    
    }



    private void listarDadosTabela(Connection conn, String tabela) {
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

    private  void localizarEstado(Connection conn, String uf) {
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

    private  void listarEstados(Connection conn) {    
        //Statement statement = null;

        try{        
            System.out.println("Conexão ok");    
            var statement = conn.createStatement();
            var result = statement.executeQuery("select * from estado;");    

            while(result.next()){
                System.out.printf("Id: %d Nome: %s UF: %s\n", result.getInt("id"), result.getString("nome"), result.getString("uf") );    
            }
        } catch (SQLException e ) {
            System.err.println("erro");
        }
    }

    private  Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }

    private  void carregarDriverJDBC() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {            
            System.err.println("Não foi possível carregar a biblioteca para acesso ao banco de dados: " + e.getMessage());
        }
    }
}
