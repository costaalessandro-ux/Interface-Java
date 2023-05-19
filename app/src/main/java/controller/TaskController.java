
package controller;

import dao.conexao;
import java.sql.Connection;
import java.sql.Date;
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
        
    public void save(Task task) throws SQLException{
        sql = "insert into task (idProject,name,description,completed,notes,deadline,createdAt,updatedAt) values(?,?,?,?)";
        preparar = conexao.prepareStatement(sql);
        preparar.setInt(1,task.getIdProject());
        preparar.setString(2,task.getName());
        preparar.setString(3,task.getDescription());
        preparar.setBoolean(4,task.getCompleted());
        preparar.setString(5,task.getNotes());
        preparar.setString(6,task.getDeadline());
        preparar.setDate(7, (Date) task.getCreatedAt());
        preparar.setDate(8, (Date) task.getUpdatedAt());
        preparar.execute();
        preparar.close();
        // pendente
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
