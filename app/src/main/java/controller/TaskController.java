package controller;

import dao.conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Task;

public class TaskController {

    private Connection conexao; //conexao.
    private PreparedStatement preparar; // preparar o SQL.
    private String sql;
    private ResultSet rs;

    public TaskController() throws ClassNotFoundException, SQLException {
        conexao = new conexao().getConnection();
    }

    public void save(Task task) throws SQLException {
        sql = "insert into task (idProject,name,description,completed,notes,deadline,createdAt,updatedAt) values(?,?,?,?,?,?,?,?)";
        preparar = conexao.prepareStatement(sql);
        try {
            preparar.setInt(1, task.getIdProject());
            preparar.setString(2, task.getName());
            preparar.setString(3, task.getDescription());
            preparar.setBoolean(4, task.getCompleted());
            preparar.setString(5, task.getNotes());
            preparar.setDate(6, new java.sql.Date (task.getDeadline().getTime()));
            preparar.setDate(7, new java.sql.Date (task.getCreatedAt().getTime()));
            preparar.setDate(8, new java.sql.Date (task.getUpdatedAt().getTime()));
            preparar.execute();
            preparar.close();
        } catch (SQLException e) {
            throw new SQLException("Error ao inserir a tarefa");
        }

    }

    public void update(Task task) throws SQLException {
        sql = "update Task task set name=?, description=?, completed=?, notes=?, deadline=?, createdAt=?, updatedAt=? where id=?";
        preparar = conexao.prepareStatement(sql);
        try {
            preparar.setString(1, task.getName());
            preparar.setString(2, task.getDescription());
            preparar.setBoolean(3, task.getCompleted());
            preparar.setString(4, task.getNotes());
            preparar.setDate(5, (Date) task.getDeadline());
            preparar.setDate(6, (Date) task.getCreatedAt());
            preparar.setDate(7, (Date) task.getUpdatedAt());
            preparar.execute();
            preparar.close();
        } catch (SQLException e) {
            throw new SQLException("Error ao alterar a tarefa");
        }
    }

    public void removeById(int taskId) throws SQLException {
        sql = "DELETE FROM task where id = ?";
        preparar = conexao.prepareStatement(sql);
        try {
            preparar.setInt(1, taskId);
            preparar.execute();
            preparar.close();
        } catch (SQLException e) {
            throw new SQLException("Error ao deletar tarefa");
        }
    }

    public List<Task> getAll(int idProject) throws SQLException {
        List<Task> tasks = new ArrayList<Task>();
        sql = "select * from task order by idProject";
        preparar = conexao.prepareStatement(sql);
        //preparar.setInt(1, idProject);
        rs = preparar.executeQuery();
        try{
            while (rs.next()) {
            Task task = new Task();
            task.setId(rs.getInt("id"));
            task.setIdProject(rs.getInt("idProject"));
            task.setName(rs.getString("name"));
            task.setDescription(rs.getString("description"));
            task.setCompleted(rs.getBoolean("completed"));
            task.setNotes(rs.getString("notes"));
            task.setDeadline(rs.getDate("deadline"));
            task.setCreatedAt(rs.getDate("createdAt"));
            task.setUpdatedAt(rs.getDate("updatedAt"));
            tasks.add(task);
        }} catch (SQLException e) {
            throw new SQLException("Error ao Listar");
        }
        return tasks;
    }
}
