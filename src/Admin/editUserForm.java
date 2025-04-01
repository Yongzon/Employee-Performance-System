/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import Error.ErrorPage;
import config.Session;
import config.dbConnector;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Chris
 */
public class editUserForm extends javax.swing.JFrame {

    /**
     * Creates new form edit
     */
    public editUserForm() {
        initComponents();
    }

    public String destination = "";
    File selectedFile;
    public String oldpath;
    public String path;

    public int FileExistenceChecker(String path){
        File file = new File(path);
        String fileName = file.getName();

        Path filePath = Paths.get("src/userImages", fileName);
        boolean fileExists = Files.exists(filePath);

        if (fileExists) {
            return 1;
        } else {
            return 0;
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
    
    public void imageUpdater(String existingFilePath, String newFilePath){
    File existingFile = new File(existingFilePath);
    if (existingFile.exists()) {
        String parentDirectory = existingFile.getParent();
        File newFile = new File(newFilePath);
        String newFileName = newFile.getName();
        File updatedFile = new File(parentDirectory, newFileName);
        existingFile.delete();
        try {
            Files.copy(newFile.toPath(), updatedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Image updated successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred while updating the image: "+e);
        }
    } else {
        try{
            Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
        }catch(IOException e){
            System.out.println("Error on update!");
        }
    }
   }

    
    public static String email, usern;
    public boolean duplicateCheck(){
        dbConnector db = new dbConnector();
        
        try{
            String query = "SELECT * FROM tbl_admin WHERE u_username = '" + un.getText() + "' OR u_email = '" + em.getText() + "'";
            ResultSet resultSet = db.getData(query);
            if(resultSet.next()){
                email = resultSet.getString("u_email");
                if(email.equals(em.getText())){
                    JOptionPane.showMessageDialog(null, "Email is Already used");
                    em.setText("");
                }
                usern = resultSet.getString("u_username");
                if(usern.equals(un.getText())){
                    JOptionPane.showMessageDialog(null, "Username is Already in used");
                    un.setText("");
                }
                return true;
            }else{
                return false;
            }
        }catch(SQLException ex){
            System.out.println(""+ex);
            return false;
        }
    }
    
    public boolean updateCheck(){
        dbConnector db = new dbConnector();
        
        try{
            String query = "SELECT * FROM tbl_admin WHERE (u_username = '"+un.getText()+"' OR u_email = '"+em.getText()+"') AND u_id != '"+uid.getText()+"'";
            ResultSet resultSet = db.getData(query);
            if(resultSet.next()){
                email = resultSet.getString("u_email");
                if(email.equals(em.getText())){
                    JOptionPane.showMessageDialog(null, "Email is Already used");
                    em.setText("");
                }
                usern = resultSet.getString("u_username");
                if(usern.equals(un.getText())){
                    JOptionPane.showMessageDialog(null, "Username is Already in used");
                    un.setText("");
                }
                return true;
            }else{
                return false;
            }
        }catch(SQLException ex){
            System.out.println(""+ex);
            return false;
        }
    }
    
    Color bodycolor = new Color(0,204,204);
    Color nav = new  Color(0,153,204);
    Color bodycolor1 = new Color(255,51,51);
    Color nav1 = new  Color(255,102,102);
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        up = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        rm = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        rm1 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        uid = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        fn = new javax.swing.JTextField();
        ln = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        role = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        acc_status = new javax.swing.JComboBox<>();
        ps = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        cp = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        un = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        em = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cnl = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        select = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(241, 242, 247));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        up.setBackground(new java.awt.Color(0, 204, 204));
        up.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        up.setEnabled(false);
        up.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                upMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                upMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                upMouseExited(evt);
            }
        });
        up.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Update");
        up.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 100, 20));

        jPanel3.add(up, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 530, 180, 40));

        rm.setBackground(new java.awt.Color(255, 51, 51));
        rm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rmMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rmMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rmMouseExited(evt);
            }
        });
        rm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Remove");
        rm.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, 20));

        jPanel3.add(rm, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 480, 150, 40));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 310, 310));

        rm1.setBackground(new java.awt.Color(255, 51, 51));
        rm1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rm1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rm1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rm1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rm1MouseExited(evt);
            }
        });
        rm1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Remove");
        rm1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 160, 20));

        jPanel1.add(rm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 490, 250, 40));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 330, 330));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pen.png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Edit User ");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 200, 40));

        uid.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        uid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        uid.setBorder(null);
        uid.setEnabled(false);
        uid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uidActionPerformed(evt);
            }
        });
        jPanel3.add(uid, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 410, 44));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("User ID:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 50, 30));

        jLabel18.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel18.setText("Fist Name");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 100, 30));

        fn.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        fn.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fn.setBorder(null);
        fn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnActionPerformed(evt);
            }
        });
        jPanel3.add(fn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 220, 44));

        ln.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ln.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ln.setBorder(null);
        ln.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnActionPerformed(evt);
            }
        });
        jPanel3.add(ln, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 220, 44));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel14.setText("Last Name");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 100, 30));

        role.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Employee" }));
        role.setBorder(null);
        role.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        role.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleActionPerformed(evt);
            }
        });
        jPanel3.add(role, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 220, 44));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel13.setText("Account Type");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 80, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Account Status");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, 90, 30));

        acc_status.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        acc_status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Pending" }));
        acc_status.setBorder(null);
        acc_status.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        acc_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acc_statusActionPerformed(evt);
            }
        });
        jPanel3.add(acc_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, 220, 44));

        ps.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ps.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ps.setBorder(null);
        ps.setEnabled(false);
        ps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                psActionPerformed(evt);
            }
        });
        jPanel3.add(ps, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 220, 44));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Password");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 100, 30));

        cp.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cp.setBorder(null);
        cp.setEnabled(false);
        cp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpActionPerformed(evt);
            }
        });
        jPanel3.add(cp, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 470, 220, 44));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Confirm Password");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 440, 120, 30));

        un.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        un.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        un.setBorder(null);
        un.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unActionPerformed(evt);
            }
        });
        jPanel3.add(un, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 220, 44));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Username");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 100, 30));

        em.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        em.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        em.setBorder(null);
        em.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emActionPerformed(evt);
            }
        });
        jPanel3.add(em, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 220, 44));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setText("Email");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 100, 30));

        cnl.setBackground(new java.awt.Color(255, 51, 51));
        cnl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cnl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cnlMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cnlMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cnlMouseExited(evt);
            }
        });
        cnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Cancel");
        cnl.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 100, 20));

        jPanel3.add(cnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 530, 180, 40));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Upload Your Profile Photo");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, 310, 30));

        select.setBackground(new java.awt.Color(0, 204, 204));
        select.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        select.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                selectMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                selectMouseExited(evt);
            }
        });
        select.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Select");
        select.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 110, 20));

        jPanel3.add(select, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 480, 150, 40));

        jPanel2.setBackground(new java.awt.Color(1, 216, 218));
        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Session sess = Session.getInstance();
        if(sess.getUid() == 0){
            ErrorPage ep = new ErrorPage();
            ep.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_formWindowActivated

    private void selectMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_selectMouseExited

    private void selectMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_selectMouseEntered

    private void selectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectMouseClicked
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                selectedFile = fileChooser.getSelectedFile();
                destination = "src/userImages/" + selectedFile.getName();
                path  = selectedFile.getAbsolutePath();

                if(FileExistenceChecker(path) == 1){
                    JOptionPane.showMessageDialog(null, "File Already Exist, Rename or Choose another!");
                    destination = "";
                    path="";
                }else{
                    image.setIcon(ResizeImage(path, null, image));
//                    select.setVisible(true);
//                    rm.setVisible(false);
                }
            } catch (Exception ex) {
                System.out.println("File Error!");
            }
        }
    }//GEN-LAST:event_selectMouseClicked

    private void rmMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rmMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_rmMouseExited

    private void rmMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rmMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_rmMouseEntered

    private void rmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rmMouseClicked
        image.setIcon(null);
        destination = "";
        path = "";
    }//GEN-LAST:event_rmMouseClicked

    private void upMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_upMouseExited
        up.setBackground(bodycolor);
    }//GEN-LAST:event_upMouseExited

    private void upMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_upMouseEntered
        up.setBackground(nav);
    }//GEN-LAST:event_upMouseEntered

    private void upMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_upMouseClicked
        String firstname = fn.getText();
        String lastname = ln.getText();
        String email1 = em.getText();
        String username1 = un.getText();
        String password1 = new String(ps.getPassword());
        String cpassword = new String(cp.getPassword());

        if (firstname.isEmpty() && lastname.isEmpty() && email1.isEmpty() && username1.isEmpty() && password1.isEmpty() && cpassword.isEmpty()){
            JOptionPane.showMessageDialog(this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
        }else if(password1.length() < 8){
            JOptionPane.showMessageDialog(this, "Password must be atleast 8 characters!", "Error", JOptionPane.ERROR_MESSAGE);
        }else if(ps.getText().length() < 8){
            JOptionPane.showMessageDialog(null, "Password must be atleast 8 characters long");
            ps.setText("");
        }else if(updateCheck()){
            System.out.println("Duplicate Exist");
        }else{
            dbConnector dbc = new dbConnector();
            dbc.updateData("UPDATE tbl_admin SET u_fname = '"+fn.getText()+"', u_lname = '"+ln.getText()+"', "
                + "u_email = '"+em.getText()+"', u_username = '"+un.getText()+"', "
                + "u_password = '"+ps.getText()+"', u_cpassword = '"+cp.getText()+"', u_type='"+role.getSelectedItem()+"', "
                + "u_status = '"+acc_status.getSelectedItem()+"', u_image = '"+destination+"' WHERE u_id = '"+uid.getText()+"'");
            Session sess = Session.getInstance();
            dbc.logActivity(sess.getUid(), "Updated a user: " + un.getText());
            JOptionPane.showMessageDialog(null, "Account Updated Successfully!");            
            if(destination.isEmpty()){
                File existingFile = new File(oldpath);
                if(existingFile.exists()){
                    existingFile.delete();
                }
            }else{
                if(!(oldpath.equals(path))){    
                    imageUpdater(oldpath, path);
                }
            }
            userTable ut = new userTable();
            ut.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_upMouseClicked

    private void uidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uidActionPerformed

    private void fnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnActionPerformed

    private void lnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnActionPerformed

    private void roleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roleActionPerformed

    private void acc_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acc_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_acc_statusActionPerformed

    private void psActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_psActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_psActionPerformed

    private void cpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpActionPerformed

    private void unActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unActionPerformed

    private void emActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emActionPerformed

    private void cnlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cnlMouseClicked
        userTable ut = new userTable();
        ut.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cnlMouseClicked

    private void cnlMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cnlMouseEntered
        cnl.setBackground(nav1);
    }//GEN-LAST:event_cnlMouseEntered

    private void cnlMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cnlMouseExited
        cnl.setBackground(bodycolor1);
    }//GEN-LAST:event_cnlMouseExited

    private void rm1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rm1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_rm1MouseExited

    private void rm1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rm1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_rm1MouseEntered

    private void rm1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rm1MouseClicked
        image.setIcon(null);
        destination = "";
        path = "";
    }//GEN-LAST:event_rm1MouseClicked

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
            java.util.logging.Logger.getLogger(editUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editUserForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> acc_status;
    private javax.swing.JPanel cnl;
    public javax.swing.JPasswordField cp;
    public javax.swing.JTextField em;
    public javax.swing.JTextField fn;
    public javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JTextField ln;
    public javax.swing.JPasswordField ps;
    public javax.swing.JPanel rm;
    private javax.swing.JPanel rm1;
    public javax.swing.JComboBox<String> role;
    public javax.swing.JPanel select;
    public javax.swing.JTextField uid;
    public javax.swing.JTextField un;
    public javax.swing.JPanel up;
    // End of variables declaration//GEN-END:variables
}
