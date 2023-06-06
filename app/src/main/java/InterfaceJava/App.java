package InterfaceJava;

import controller.TaskController;
import java.sql.SQLException;
import model.Task;

public class App {
   
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Task task = new Task();
        TaskController TaskController = new TaskController(); 
        TaskController.getAll(1);
        //TaskController.removeById(1);
  }
}
     