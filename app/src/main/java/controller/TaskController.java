
package controller;

import java.util.List;
import model.Task;

public class TaskController {
    
    public void save(Task task){
        
    }
    
    public void update(Task task){
        
    }
    
    public void removeById(Task task){
        String sql = "DELETE FROM task where id = ?";
    }
    
    public List<Task> getAll(int idProject){
        return null;
    }
}
