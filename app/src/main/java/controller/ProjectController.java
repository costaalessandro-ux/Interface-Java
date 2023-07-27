package controller;

import dao.conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            preparar.setDate(4, new java.sql.Date (project.getCreatedAt().getTime()));
            preparar.setDate(5, new java.sql.Date (project.getUpdatedAt().getTime()));
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
            preparar.setDate(3, new Date  (project.getCreatedAt().getTime()));
            preparar.setDate(4, new Date (project.getUpdatedAt().getTime()));
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

    public List<Project> getAll() throws SQLException {
        sql = "SELECT * FROM project";
        List<Project> projects = new ArrayList<>();
        preparar = conexao.prepareStatement(sql);
        try {
             rs = preparar.executeQuery();
        while (rs.next()) {
            Project project = new Project();
            project.setId(rs.getInt("id"));
            project.setName(rs.getString("name"));
            project.setDescription(rs.getString("description"));
            project.setCreatedAt(rs.getDate("createdAt"));
            project.setUpdatedAt(rs.getDate("updatedAt"));
            projects.add(project);
        }
        } catch (SQLException e) {
            throw new SQLException("Error ao Listar");
        }
        return projects;
    }
}
