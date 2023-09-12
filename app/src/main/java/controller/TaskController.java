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
    
     public void updateCheck(Task task) throws SQLException {
        sql = "update task set idProject=?, name=?, description=?, completed=? where id=?";
        preparar = conexao.prepareStatement(sql);
        try {
            preparar.setInt(1, task.getIdProject());
            preparar.setString(2, task.getName());
            preparar.setString(3, task.getDescription());
            //preparar.setDate(4, new java.sql.Date(task.getDeadline().getTime()));
            preparar.setBoolean(4, task.getCompleted());
            preparar.setInt(5, task.getId());
            preparar.execute();
            preparar.close();
        } catch (SQLException e) {
            throw new SQLException("Error ao alterar a tarefa");
        }
    }

    public void update(Task task) throws SQLException {
        sql = "update task set idProject=?, name=?, description=?, completed=?, notes=?, deadline=?, createdAt=?, updatedAt=? where id=?";
        preparar = conexao.prepareStatement(sql);
        try {
            preparar.setInt(1, task.getIdProject());
            preparar.setString(2, task.getName());
            preparar.setString(3, task.getDescription());
            preparar.setBoolean(4, task.getCompleted());
            preparar.setString(5, task.getNotes());
            preparar.setDate(6, new java.sql.Date(task.getDeadline().getTime()));
            preparar.setDate(7, new java.sql.Date(task.getCreatedAt().getTime()));
            preparar.setDate(8, new java.sql.Date(task.getUpdatedAt().getTime()));
            preparar.setInt(9, task.getId());
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
            task.setCompleted(rs.getBoolean("completed"));
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
    
      /*
      public List<Task> getByProjectId(int id) {
        String sql = "SELECT * FROM tasks where idProject = ?";

        List<Task> tasks = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;

        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            rset = stmt.executeQuery();

            //Enquanto existir dados no banco de dados, fa?a
            while (rset.next()) {

                Task task = new Task();

                task.setId(rset.getInt("id"));
                task.setIdProject(rset.getInt("idProject"));
                task.setName(rset.getString("name"));
                task.setDescription(rset.getString("description"));
                //task.setStatus(rset.getByte("status"));
                task.setNotes(rset.getString("notes"));
                task.setDeadline(rset.getDate("deadline"));
                task.setCompleted(rset.getBoolean("completed"));
                task.setCreatedAt(rset.getDate("createdAt"));
                task.setCreatedAt(rset.getDate("updatedAt"));

                //Adiciono o contato recuperado, a lista de contatos
                tasks.add(task);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar as tarefas", ex);
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar a conexão", ex);
            }
        }
        return tasks;
    }
    */
}
