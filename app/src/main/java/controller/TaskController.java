
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ConnectionFactory;
import model.Task;

public class TaskController {
    
    public void save(Task task){
        
    }
    
    public void update(Task task){
        
    }
    
    public void removeById(int taskId) throws SQLException{
        String sql = "DELETE FROM task where id = ?";
        Connection conn = null;
        PreparedStatement statement = null;
        try{
           conn = ConnectionFactory.getConnection();
           statement = conn.prepareStatement(sql);
           statement.setInt(1, taskId);
           statement.execute();
        }catch (SQLException e){
            throw new SQLException("Error ao deletar tarefa");
        }
    }
    
    public List<Task> getAll(int idProject){
        return null;
    }
}
