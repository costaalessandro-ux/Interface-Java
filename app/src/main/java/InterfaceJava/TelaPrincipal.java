package InterfaceJava;

import controller.ProjectController;
import controller.TaskController;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import model.Project;
import model.Task;
import util.TaskTableModel;

public class TelaPrincipal extends javax.swing.JFrame {

    ProjectController projectController;
    TaskController taskController;
    DefaultListModel projectModel;
    TaskTableModel taskModel;

    public TelaPrincipal() throws ClassNotFoundException, SQLException {
        initComponents();
        decorateTableTasks();
        initDataController();
        initComponetsModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanelToolBar = new javax.swing.JPanel();
        jLabelToolBarTitle = new javax.swing.JLabel();
        jLabelToolBarSubTitle = new javax.swing.JLabel();
        jPanelProjects = new javax.swing.JPanel();
        jLabelProjectsTitle = new javax.swing.JLabel();
        jLabelProjectsSubTitle = new javax.swing.JLabel();
        jPanelTasks = new javax.swing.JPanel();
        jLabelTasksTitle = new javax.swing.JLabel();
        jLabelTasksSubTitle = new javax.swing.JLabel();
        jPanelProjectList = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListProjects = new javax.swing.JList<>();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableTasks = new javax.swing.JTable();

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lists.png"))); // NOI18N
        jLabel8.setToolTipText("");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel9.setBackground(new java.awt.Color(0, 152, 102));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 152, 102));
        jLabel9.setText("Nenhuma tarefa por aqui.");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 152, 102));
        jLabel10.setText("Clique no Botão \" + \" para adicionar uma nova tarefa");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lists.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 102));
        jLabel2.setText("Nenhuma Tarefa por aqui!");

        jLabel3.setText("Clique no botão \"+\" para adicionar uma nova tarefa");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(116, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(181, 181, 181))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(112, 112, 112))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 500));

        jPanelToolBar.setBackground(new java.awt.Color(0, 152, 102));

        jLabelToolBarTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelToolBarTitle.setForeground(new java.awt.Color(0, 0, 0));
        jLabelToolBarTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/check.png"))); // NOI18N
        jLabelToolBarTitle.setText("  ToDo APP");

        jLabelToolBarSubTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelToolBarSubTitle.setForeground(new java.awt.Color(0, 0, 0));
        jLabelToolBarSubTitle.setText("Anote tudo e não esqueça de nada");

        javax.swing.GroupLayout jPanelToolBarLayout = new javax.swing.GroupLayout(jPanelToolBar);
        jPanelToolBar.setLayout(jPanelToolBarLayout);
        jPanelToolBarLayout.setHorizontalGroup(
            jPanelToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelToolBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelToolBarTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelToolBarSubTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelToolBarLayout.setVerticalGroup(
            jPanelToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelToolBarLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabelToolBarTitle)
                .addGap(18, 18, 18)
                .addComponent(jLabelToolBarSubTitle)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanelProjects.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProjects.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelProjectsTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelProjectsTitle.setForeground(new java.awt.Color(0, 152, 102));
        jLabelProjectsTitle.setText("Projetos");

        jLabelProjectsSubTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        jLabelProjectsSubTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProjectsSubTitleMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelProjectsLayout = new javax.swing.GroupLayout(jPanelProjects);
        jPanelProjects.setLayout(jPanelProjectsLayout);
        jPanelProjectsLayout.setHorizontalGroup(
            jPanelProjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProjectsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelProjectsTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelProjectsSubTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelProjectsLayout.setVerticalGroup(
            jPanelProjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProjectsLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanelProjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelProjectsSubTitle)
                    .addComponent(jLabelProjectsTitle))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanelTasks.setBackground(new java.awt.Color(255, 255, 255));
        jPanelTasks.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelTasksTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTasksTitle.setForeground(new java.awt.Color(0, 152, 102));
        jLabelTasksTitle.setText("Tarefas");

        jLabelTasksSubTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        jLabelTasksSubTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelTasksSubTitleMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelTasksLayout = new javax.swing.GroupLayout(jPanelTasks);
        jPanelTasks.setLayout(jPanelTasksLayout);
        jPanelTasksLayout.setHorizontalGroup(
            jPanelTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTasksLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabelTasksTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTasksSubTitle)
                .addGap(61, 61, 61))
        );
        jPanelTasksLayout.setVerticalGroup(
            jPanelTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTasksLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanelTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelTasksSubTitle)
                    .addComponent(jLabelTasksTitle))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelProjectList.setBackground(new java.awt.Color(255, 255, 255));
        jPanelProjectList.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelProjectList.setForeground(new java.awt.Color(255, 255, 255));

        jListProjects.setBackground(new java.awt.Color(255, 255, 255));
        jListProjects.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jListProjects.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jListProjects.setForeground(new java.awt.Color(0, 0, 0));
        jListProjects.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListProjects.setSelectionBackground(new java.awt.Color(0, 152, 102));
        jListProjects.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListProjectsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListProjects);

        javax.swing.GroupLayout jPanelProjectListLayout = new javax.swing.GroupLayout(jPanelProjectList);
        jPanelProjectList.setLayout(jPanelProjectListLayout);
        jPanelProjectListLayout.setHorizontalGroup(
            jPanelProjectListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanelProjectListLayout.setVerticalGroup(
            jPanelProjectListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTableTasks.setBackground(new java.awt.Color(255, 255, 255));
        jTableTasks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Descrição", "Prazo", "Tarefa Concluida"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTasks.setSelectionBackground(new java.awt.Color(0, 152, 102));
        jTableTasks.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableTasks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTasksMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableTasks);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelProjects, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelProjectList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTasks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jPanelToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelTasks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelProjects, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelProjectList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelProjectsSubTitleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProjectsSubTitleMouseClicked
        ProjectDialog projectDialog = new ProjectDialog(this, rootPaneCheckingEnabled);
        projectDialog.setVisible(true);
        projectDialog.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                try {
                    loadProjects();
                } catch (SQLException ex) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }//GEN-LAST:event_jLabelProjectsSubTitleMouseClicked

    private void jLabelTasksSubTitleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelTasksSubTitleMouseClicked
        try {
            TaskDialog taskDialog = new TaskDialog(this, rootPaneCheckingEnabled);
            taskDialog.setProject(null);
            taskDialog.setVisible(true);
            taskDialog.addWindowListener(new WindowAdapter() {
                public void windowClosed(WindowEvent e) {
                    try {
                        loadProjects();
                    } catch (SQLException ex) {
                        Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabelTasksSubTitleMouseClicked

    private void jListProjectsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListProjectsMouseClicked
        try {
            int projectIndex = jListProjects.getSelectedIndex();
            Project project = (Project) projectModel.get(projectIndex);
            loadTasks(project.getId());
        } catch (SQLException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jListProjectsMouseClicked

    private void jTableTasksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTasksMouseClicked
        try {
            int rowIndex = jTableTasks.rowAtPoint(evt.getPoint());
            int columnIndex = jTableTasks.columnAtPoint(evt.getPoint());
            switch (columnIndex) {
                case 3:
                Task task = taskModel.getTasks().get(rowIndex);
                taskController.update(task);
                break;
                case 4:
                break;
                case 5:
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTableTasksMouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Java swing".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaPrincipal().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelProjectsSubTitle;
    private javax.swing.JLabel jLabelProjectsTitle;
    private javax.swing.JLabel jLabelTasksSubTitle;
    private javax.swing.JLabel jLabelTasksTitle;
    private javax.swing.JLabel jLabelToolBarSubTitle;
    private javax.swing.JLabel jLabelToolBarTitle;
    private javax.swing.JList<String> jListProjects;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelProjectList;
    private javax.swing.JPanel jPanelProjects;
    private javax.swing.JPanel jPanelTasks;
    private javax.swing.JPanel jPanelToolBar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableTasks;
    // End of variables declaration//GEN-END:variables

    public void decorateTableTasks() {
        // metodo para customizar a header da table
        jTableTasks.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        jTableTasks.getTableHeader().setBackground(new Color(0, 153, 102));
        jTableTasks.getTableHeader().setForeground(new Color(255, 255, 255));
        jTableTasks.setAutoCreateRowSorter(true);
    }

    public void initDataController() throws ClassNotFoundException, SQLException {
        projectController = new ProjectController();
        taskController = new TaskController();
    }

    public void initComponetsModel() throws ClassNotFoundException, SQLException {
        projectModel = new DefaultListModel();
        loadProjects();
        taskModel = new TaskTableModel();
        jTableTasks.setModel(taskModel);
        loadTasks(0);
    }

    public void loadTasks(int id) throws SQLException {
        List<Task> tasks = taskController.getAll(5);
        taskModel.setTasks(tasks);
        
        //showJTableTasks(!tasks.isEmpty());
    }
    
    // METODO CRIADO COM BUG
     private void showJTableTasks(boolean hasTastks) {
        if (hasTastks) {
            if (jPanelProjectList.isVisible()) {
                jPanelProjectList.setVisible(false);
                jPanel5.remove(jPanelProjectList);
            }
            jPanel5.add(jScrollPane2);
            jScrollPane1.setVisible(true);
            jScrollPane1.setSize(jPanel5.getWidth(), jPanel5.getHeight());
        } else {
            if (jScrollPane1.isVisible()) {
                jScrollPane1.setVisible(false);
                jPanel5.remove(jScrollPane2);
            }
            jPanel5.add(jTableTasks);
            jPanelProjectList.setVisible(true);
            jPanelProjectList.setSize(jTableTasks.getWidth(), jTableTasks.getHeight());
        }
    }
    
    public void loadProjects() throws SQLException {
        List<Project> projects = projectController.getAll();
        projectModel.clear();
        for (int i = 0; i < projects.size(); i++) {
            Project project = projects.get(i);
            projectModel.addElement(project);
        }
        jListProjects.setModel(projectModel);
    }

}
