/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package User;

import Error.ErrorPage;
import Startup.loginform;
import config.Session;
import config.dbConnector;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Chris
 */
public class evaluateTask extends javax.swing.JFrame {

    /** Creates new form employeeDashboard */
    public evaluateTask() {
        initComponents();
        displayTasks();
    }
    
   public void displayTasks() {
    try{
        dbConnector db = new dbConnector();
        String taskQuery = "SELECT t.t_id AS 'Task ID', "
                        + "t.t_name AS 'Task Name', "
                        + "t.t_deadline AS 'Deadline', "
                        + "t.t_status AS 'Task Status', "
                        + "t.t_evalstatus AS 'Request Status', "
                        + "e.evaluation_status AS 'Evaluation Status' "
                        + "FROM tbl_task t "
                        + "INNER JOIN tbl_evaluation e ON t.t_id = e.evaluation_tid " 
                        + "WHERE e.evaluation_status IN ( 'Pending', 'Completed')"; 

        ResultSet rs = db.getData(taskQuery);
        tasktbl.setModel(DbUtils.resultSetToTableModel(rs));
        rs.close();
    } catch (SQLException e) {
        System.err.println("Database Error: " + e.getMessage());
        JOptionPane.showMessageDialog(null, 
            "Error loading tasks: " + e.getMessage(), 
            "Database Error", 
            JOptionPane.ERROR_MESSAGE);
    }
}
    
    public static int getHeightFromWidth(String imagePath, int desiredWidth) {
    try {
        // Read the image file
        File imageFile = new File(imagePath);
        BufferedImage image = ImageIO.read(imageFile);

        // Get the original width and height of the image
        int originalWidth = image.getWidth();
        int originalHeight = image.getHeight();

        // Calculate the new height based on the desired width and the aspect ratio
        int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);

        return newHeight;
    } catch (IOException ex) {
        System.out.println("No image found!");
    }

    return -1;
    }
    
    public  ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
    ImageIcon MyImage = null;
        if(ImagePath !=null){
            MyImage = new ImageIcon(ImagePath);
        }else{
            MyImage = new ImageIcon(pic);
        }
        
    int newHeight = getHeightFromWidth(ImagePath, label.getWidth());

    Image img = MyImage.getImage();
    Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
    return image;
}
    
    Color bodycolor = new Color (255,255,255);
    Color nav = new Color (242,240,240);
    Color bodycolor1 = new Color(241,242,247);
    Color nav1 = new Color (255,255,255);

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        image = new javax.swing.JLabel();
        wc = new javax.swing.JLabel();
        dash = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        task = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        eval = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        userpanel = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        accept = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        view = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        reject = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tasktbl = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Capture-removebg-preview (1).png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, -1));

        image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 100, 80));

        wc.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        wc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(wc, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 180, 40));

        dash.setBackground(new java.awt.Color(255, 255, 255));
        dash.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dashMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dashMouseExited(evt);
            }
        });
        dash.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Dashboard");
        dash.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 80, 20));

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/business-report_18640352.png"))); // NOI18N
        dash.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 40, 40));

        jPanel2.add(dash, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 160, -1));

        task.setBackground(new java.awt.Color(255, 255, 255));
        task.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                taskMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                taskMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                taskMouseExited(evt);
            }
        });
        task.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Tasks");
        task.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 50, 20));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/planning_12755894.png"))); // NOI18N
        task.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 40));

        jPanel2.add(task, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 160, -1));

        eval.setBackground(new java.awt.Color(255, 255, 255));
        eval.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                evalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                evalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                evalMouseExited(evt);
            }
        });
        eval.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Evaluate");
        eval.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 80, 20));

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/toggle_8686243.png"))); // NOI18N
        eval.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 40));

        jPanel2.add(eval, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 160, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 183, 560));

        userpanel.setBackground(new java.awt.Color(241, 242, 247));
        userpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Tasks |");
        userpanel.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 40));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home_6269504.png"))); // NOI18N
        userpanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 40, 40));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("> Home > Dashboard");
        userpanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 170, 40));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("All Employee Accepted Evaluation");
        userpanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 210, 40));

        accept.setBackground(new java.awt.Color(241, 242, 247));
        accept.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                acceptMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                acceptMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                acceptMouseExited(evt);
            }
        });
        accept.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Search:");
        accept.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 190, 70, 30));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Evaluate Task");
        accept.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 120, 20));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/task-assignment_18543665.png"))); // NOI18N
        accept.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 40));

        userpanel.add(accept, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 170, 40));

        view.setBackground(new java.awt.Color(241, 242, 247));
        view.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewMouseExited(evt);
            }
        });
        view.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("View Evaluate");
        view.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 100, 20));

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/audit_10815328 (1).png"))); // NOI18N
        view.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 40));

        userpanel.add(view, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 160, 40));

        reject.setBackground(new java.awt.Color(241, 242, 247));
        reject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rejectMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rejectMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rejectMouseExited(evt);
            }
        });
        reject.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Delete Evaluate");
        reject.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 110, 20));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete_8661494.png"))); // NOI18N
        reject.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 40));

        userpanel.add(reject, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 170, 40));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Search:");
        userpanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 70, 30));
        userpanel.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 220, 30));

        tasktbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tasktbl);

        userpanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 680, 320));

        getContentPane().add(userpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 700, 510));

        jPanel1.setBackground(new java.awt.Color(1, 216, 218));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user_10813400.png"))); // NOI18N
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 50, 50));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Evaluator", "Logout", "Settings" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, 130, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 700, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       Session sess = Session.getInstance();
        if(sess.getUid() == 0){
             ErrorPage ep = new ErrorPage();
             ep.setVisible(true);
             this.dispose();
             System.out.println("");
        }else{
            try {
            dbConnector db = new dbConnector();
            try (ResultSet rs = db.getData("SELECT u_image FROM tbl_admin WHERE u_id = '" + sess.getUid() + "'")) {
                if(rs.next()) {
                    String imagePath = rs.getString("u_image");
                    if(imagePath != null && !imagePath.isEmpty()) {
                        wc.setText(""+sess.getLname());
                        image.setIcon(ResizeImage(imagePath, null, image));
                    }else{
                        image.setText("No image");
                        wc.setText(""+sess.getLname());
                    }
                }
                }
            } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
            }    
        }
    }//GEN-LAST:event_formWindowActivated

    private void acceptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acceptMouseClicked
        int rowIndex = tasktbl.getSelectedRow();

        if(rowIndex < 0) {
            JOptionPane.showMessageDialog(null, "Please Select an Item!");
        } else {
            try {
                dbConnector db = new dbConnector();
                TableModel tbl = tasktbl.getModel();
                String taskId = tbl.getValueAt(rowIndex, 0).toString();
                
                ResultSet checkRs = db.getData("SELECT evaluation_status FROM tbl_evaluation WHERE evaluation_tid = " + taskId);

            if(checkRs.next()) {
                String evalStatus = checkRs.getString("evaluation_status");

                if("Completed".equals(evalStatus)) {
                    JOptionPane.showMessageDialog(null, 
                        "Cannot evaluate again - Evaluation is already completed!", 
                        "Evaluate Error", 
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

                String query = "SELECT " +
                              "CONCAT(u.u_fname, ' ', u.u_lname) AS full_name, " +
                              "d.dep_name, " +
                              "t.t_name, " +
                              "t.t_id, " +
                              "e.emp_position " +
                              "FROM tbl_task t " +
                              "INNER JOIN tbl_employee e ON t.t_empid = e.emp_id " +
                              "INNER JOIN tbl_admin u ON e.emp_userid = u.u_id " +
                              "INNER JOIN tbl_department d ON e.emp_depid = d.dep_id " +
                              "WHERE t.t_id = '" + taskId + "'";

                ResultSet rs = db.getData(query);

                if(rs.next()) {
                    evaluate eva = new evaluate();
                    eva.empname.setText(rs.getString("full_name"));
                    eva.tn.setText(rs.getString("t_name"));
                    eva.tid.setText(rs.getString("t_id"));
                    eva.dep.setText(rs.getString("dep_name"));
                    eva.jt.setText(rs.getString("emp_position"));
                    eva.setVisible(true);
                    this.dispose();
                }
            } catch(SQLException ex) {
                System.out.println("Error: " + ex);
                JOptionPane.showMessageDialog(null, 
                    "Database error: " + ex.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_acceptMouseClicked

    private void acceptMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acceptMouseEntered
        accept.setBackground(nav1);
    }//GEN-LAST:event_acceptMouseEntered

    private void acceptMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acceptMouseExited
        accept.setBackground(bodycolor1);
    }//GEN-LAST:event_acceptMouseExited

    private void viewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewMouseClicked
    int rowIndex = tasktbl.getSelectedRow();

    if(rowIndex < 0) {
        JOptionPane.showMessageDialog(null, "Please Select an Item!");
    } else {
        try {
            dbConnector db = new dbConnector();
            TableModel tbl = tasktbl.getModel();
            String taskid = tbl.getValueAt(rowIndex, 0).toString();

            String query = "SELECT " +
                                "CONCAT(u.u_fname, ' ', u.u_lname) AS full_name, " +
                                "d.dep_name, " +
                                "t.t_name, " +
                                "t.t_id, " +
                                "e.emp_position, " +
                                "ev.evaluation_revper, " +
                                "ev.evaluation_r1, ev.evaluation_r2, ev.evaluation_r3, " +
                                "ev.evaluation_r4, ev.evaluation_r5, ev.evaluation_r6, " +
                                "ev.evaluation_cm1, ev.evaluation_cm2, ev.evaluation_cm3, " +
                                "ev.evaluation_cm4, ev.evaluation_cm5, ev.evaluation_cm6, " +
                                "ev.evaluation_over1, ev.evaluation_over2, ev.evaluation_over3, " +
                                "ev.evaluation_over4, ev.evaluation_over5, " +
                                "ev.evaluation_areaimprov " +
                                "FROM tbl_task t " +
                                "INNER JOIN tbl_employee e ON t.t_empid = e.emp_id " +
                                "INNER JOIN tbl_admin u ON e.emp_userid = u.u_id " +
                                "INNER JOIN tbl_department d ON e.emp_depid = d.dep_id " +
                                "LEFT JOIN tbl_evaluation ev ON t.t_id = ev.evaluation_tid " +
                                "WHERE t.t_id = '"+taskid+"'"; 

            ResultSet rs = db.getData(query);

            if(rs.next()) {
                viewEvaluation ve = new viewEvaluation();

                ve.empname.setText(rs.getString("full_name"));
                ve.dep.setText(rs.getString("dep_name"));
                ve.jt.setText(rs.getString("emp_position"));
                ve.tn.setText(rs.getString("t_name"));
                ve.tid.setText(rs.getString("t_id"));

                ve.rp.setDate(rs.getDate("evaluation_revper"));

                ve.r1.setText(rs.getString("evaluation_r1"));
                ve.r2.setText(rs.getString("evaluation_r2"));
                ve.r3.setText(rs.getString("evaluation_r3"));
                ve.r4.setText(rs.getString("evaluation_r4"));
                ve.r5.setText(rs.getString("evaluation_r5"));
                ve.r6.setText(rs.getString("evaluation_r6"));

                ve.cm1.setText(rs.getString("evaluation_cm1"));
                ve.cm2.setText(rs.getString("evaluation_cm2"));
                ve.cm3.setText(rs.getString("evaluation_cm3"));
                ve.cm4.setText(rs.getString("evaluation_cm4"));
                ve.cm5.setText(rs.getString("evaluation_cm5"));
                ve.cm6.setText(rs.getString("evaluation_cm6"));

                String over1 = rs.getString("evaluation_over1");
                String over2 = rs.getString("evaluation_over2");
                String over3 = rs.getString("evaluation_over3");
                String over4 = rs.getString("evaluation_over4");
                String over5 = rs.getString("evaluation_over5");

                ve.over1.setSelected("1".equals(over1));  
                ve.over2.setSelected("2".equals(over2));  
                ve.over3.setSelected("3".equals(over3));  
                ve.over4.setSelected("4".equals(over4));  
                ve.over5.setSelected("5".equals(over5));

                ve.area.setText(rs.getString("evaluation_areaimprov"));

                ve.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "No evaluation data found for this task");
            }
        } catch(SQLException ex) {
            System.out.println("Error: " + ex);
            JOptionPane.showMessageDialog(null, 
                "Database error: " + ex.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_viewMouseClicked

    private void viewMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewMouseEntered
        view.setBackground(nav1);
    }//GEN-LAST:event_viewMouseEntered

    private void viewMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewMouseExited
        view.setBackground(bodycolor1);
    }//GEN-LAST:event_viewMouseExited

    private void rejectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rejectMouseClicked
    int selectedRow = tasktbl.getSelectedRow();
    
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(null, "Please Select an Item!");
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this Evaluation?", "Confirm Deletion",JOptionPane.YES_NO_OPTION);
    
    if (confirm == JOptionPane.YES_OPTION) {
        int taskId = (int) tasktbl.getValueAt(selectedRow, 0); 
        
        try {
            dbConnector db = new dbConnector();
            String query = "SELECT evaluation_id FROM tbl_evaluation WHERE evaluation_tid = '"+taskId+"'";
            ResultSet rs = db.getData(query);
            if(rs.next()){
                String evaluationId = rs.getString("evaluation_id");
                db.deleteData("DELETE FROM tbl_evaluation WHERE evaluation_id = " + evaluationId);

                Session sess = Session.getInstance();
                db.logActivity3(sess.getUid(), "Deleted Evaluation: " + evaluationId);

                displayTasks();
                JOptionPane.showMessageDialog(this, "User deleted successfully");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error deleting user: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_rejectMouseClicked

    private void rejectMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rejectMouseEntered
        reject.setBackground(nav1);
    }//GEN-LAST:event_rejectMouseEntered

    private void rejectMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rejectMouseExited
        reject.setBackground(bodycolor1);
    }//GEN-LAST:event_rejectMouseExited

    private void dashMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashMouseClicked
        evaluatorDashboard ed = new evaluatorDashboard();
        ed.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_dashMouseClicked

    private void dashMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashMouseEntered
        dash.setBackground(nav);
    }//GEN-LAST:event_dashMouseEntered

    private void dashMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashMouseExited
        dash.setBackground(bodycolor);
    }//GEN-LAST:event_dashMouseExited

    private void taskMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taskMouseClicked
        assignedTask at = new assignedTask();
        at.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_taskMouseClicked

    private void taskMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taskMouseEntered
        task.setBackground(nav);
    }//GEN-LAST:event_taskMouseEntered

    private void taskMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taskMouseExited
        task.setBackground(bodycolor);
    }//GEN-LAST:event_taskMouseExited

    private void evalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_evalMouseClicked
        evaluateTask et = new evaluateTask();
        et.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_evalMouseClicked

    private void evalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_evalMouseEntered
        eval.setBackground(nav);
    }//GEN-LAST:event_evalMouseEntered

    private void evalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_evalMouseExited
        eval.setBackground(bodycolor);
    }//GEN-LAST:event_evalMouseExited

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String selectedValue = jComboBox1.getSelectedItem().toString();
        if (selectedValue.equals("Logout")) {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                loginform lf = new loginform();
                dbConnector db = new dbConnector();
                Session sess = Session.getInstance();
                db.logActivity3(sess.getUid(), "User Logout: " + sess.getLname());
                lf.setVisible(true);
                this.dispose();
            }else {
                jComboBox1.setSelectedIndex(0);
            }
        }else if(selectedValue.equals("Settings")){
            userDetails ud = new userDetails();
            ud.setVisible(true);
            this.dispose();
        }else{
            jComboBox1.setSelectedIndex(0);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(evaluateTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(evaluateTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(evaluateTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(evaluateTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new evaluateTask().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel accept;
    private javax.swing.JPanel dash;
    private javax.swing.JPanel eval;
    public javax.swing.JLabel image;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel reject;
    private javax.swing.JPanel task;
    private javax.swing.JTable tasktbl;
    private javax.swing.JPanel userpanel;
    private javax.swing.JPanel view;
    private javax.swing.JLabel wc;
    // End of variables declaration//GEN-END:variables

}
