
package controller;

import dao.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Task;

public class TaskController {
    
        private Connection conexao; //conexao.
	private PreparedStatement preparar; // preparar o SQL.
	private String sql;
	private ResultSet rs;
     
    public TaskController () throws ClassNotFoundException, SQLException {
		conexao = new conexao().getConnection();
    }
        
    public void save(Task task){
        
    }
    
    public void update(Task task){
        
    }
    
    public void removeById(int taskId) throws SQLException{
        sql = "DELETE FROM task where id = ?";
        preparar = conexao.prepareStatement(sql);
        try{
           preparar.setInt(1, taskId);
           preparar.execute();
           preparar.close();
        }catch (SQLException e){
            throw new SQLException("Error ao deletar tarefa");
        }
    }
    
    public List<Task> getAll(int idProject){
        return null;
    }
}
