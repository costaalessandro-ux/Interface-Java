package controller;

import dao.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import model.Project;

public class ProjectController {

    private Connection conexao; //conexao.
    private PreparedStatement preparar; // preparar o SQL.
    private String sql;
    private ResultSet rs;

    public ProjectController() throws ClassNotFoundException, SQLException {
        conexao = new conexao().getConnection();
    }

    public void save(Project project) throws SQLException {
        sql = "insert into project (id, name, description, createdAt, updatedAt) values (?,?,?,?,?)";
        preparar = conexao.prepareStatement(sql);
        try {
            preparar.setInt(1, project.getId());
            preparar.setString(2, project.getName());
            preparar.setString(3, project.getDescription());
            preparar.setDate(4, (Date) project.getCreatedAt());
            preparar.setDate(5, (Date) project.getUpdatedAt());
            preparar.execute();
            preparar.close();
        } catch (SQLException e) {
            throw new SQLException("Error ao inserir um Projeto");
        }

    }

    public void update(Project project) throws SQLException {
        sql = "update Project project set name=?, description=?, notes=?, deadline=?, createdAt=?, updatedAt=? where id=?";
        preparar = conexao.prepareStatement(sql);
        try {
            preparar.setString(1, project.getName());
            preparar.setString(2, project.getDescription());
            preparar.setDate(3, (Date) project.getCreatedAt());
            preparar.setDate(4, (Date) project.getUpdatedAt());
            preparar.execute();
            preparar.close();
        } catch (SQLException e) {
            throw new SQLException("Error ao alterar Projeto");
        }

    }

    public void removeById(int idProject) throws SQLException {
        sql = "DELETE FROM project where id = ?";
        preparar = conexao.prepareStatement(sql);
        try {
            preparar.setInt(1, idProject);
            preparar.execute();
            preparar.close();
        } catch (SQLException e) {
            throw new SQLException("Error ao deletar o projeto");
        }
    }

    public List<Project> getAll(int id) throws SQLException {
        List<Project> projects = new ArrayList<Project>();
        sql = "select * from project order by id";
        preparar = conexao.prepareStatement(sql);
        rs = preparar.executeQuery();
        while (rs.next()) {
            Project project = new Project();
            project.setId(rs.getInt("id"));
            project.setName(rs.getString("name"));
            project.setDescription(rs.getString("description"));
            project.setCreatedAt(rs.getDate("createdAt"));
            project.setUpdatedAt(rs.getDate("updatedAt"));
        }
        return null;
    }
}
