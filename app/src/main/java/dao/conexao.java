package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexao {
    private Connection conexao;
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/todolist";
    public static final String USER = "root";
    public static final String PASS = "";
    
    public Connection getConnection(){
        try{
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USER, PASS);
            return conexao;
        }catch (Exception ex){
            throw new RuntimeException("Erro na conexao com o banco de dados");
        }
    }
    
    public static void closeConnection(Connection connection){
        try{
            if (connection != null){
                connection.close();
            }
        }catch (Exception ex){
            throw new RuntimeException("Erro ao fechar a conexao");
        }
    }
}
