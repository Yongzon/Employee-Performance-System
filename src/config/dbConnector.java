package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Chris
 */
public class dbConnector {
    public Connection connect;

       // constructor to connect to our database
        public dbConnector(){
            try{
                connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/epss", "root", "");
            }catch(SQLException ex){
                    System.out.println("Can't connect to database: "+ex.getMessage());
            }
        }
        
        //Function to retrieve data
        public ResultSet getData(String sql) throws SQLException{
            Statement stmt = connect.createStatement();
            ResultSet rst = stmt.executeQuery(sql);
            return rst;
        }
          
        public int InsertData(String sql){
        int result;
        try{
            PreparedStatement pst = connect.prepareStatement(sql);
            pst.executeUpdate();
            System.out.println("Inserted Successfully! ");
            pst.close();
            result = 1;
        }catch(SQLException ex){
            System.out.println("Connection Error: "+ex);
            result = 0;
        }
        return result;
    }
        
         //Function to update data
        public void updateData(String sql){
            try{
                PreparedStatement pst = connect.prepareStatement(sql);
                    int rowsUpdated = pst.executeUpdate();
                        if(rowsUpdated > 0){
                            
                        }else{
                            System.out.println("Data Update Failed!");
                        }
                        pst.close();
            }catch(SQLException ex){
                System.out.println("Connection Error: "+ex);
            }
        
        }
        
                // Function to delete data
        public boolean deleteData(String sql) {
            try {
                PreparedStatement pst = connect.prepareStatement(sql);
                int rowsDeleted = pst.executeUpdate();
                if (rowsDeleted > 0) {
                   
                    return true;
                } else {
                    System.out.println("No records deleted");
                    return false;
                }
            } catch (SQLException ex) {
                System.out.println("Error deleting data: " + ex.getMessage());
                return false;
            }
        }
        
        // Function to log user activity
        public void logActivity(int userId, String action) {
            String query = "INSERT INTO tbl_logs (user_id, log_action) VALUES (?, ?)";
            try (PreparedStatement pstmt = connect.prepareStatement(query)) {
                pstmt.setInt(1, userId);
                pstmt.setString(2, action);
                pstmt.executeUpdate();
                System.out.println("Activity logged: " + action);
            } catch (SQLException e) {
                System.out.println("Error logging activity: " + e.getMessage());
            }
        }
        
        public ResultSet getLogs() throws SQLException {
            String query = "SELECT l.log_id AS 'Log ID', " +
                           "u.u_username AS 'Username', " +
                           "l.log_action AS 'Action', " +
                           "l.log_timestamp AS 'Timestamp' " +
                           "FROM tbl_logs l " +
                           "JOIN tbl_admin u ON l.user_id = u.u_id " +
                           "ORDER BY l.log_timestamp DESC";
            return getData(query);
        }
        
                // Function to log user activity
        public void logActivity2(int userId, String action) {
            String query = "INSERT INTO tbl_logsemployee (log_userid, log_action) VALUES (?, ?)";
            try (PreparedStatement pstmt = connect.prepareStatement(query)) {
                pstmt.setInt(1, userId);
                pstmt.setString(2, action);
                pstmt.executeUpdate();
                System.out.println("Activity logged: " + action);
            } catch (SQLException e) {
                System.out.println("Error logging activity: " + e.getMessage());
            }
        }
        
        public ResultSet getLogs2() throws SQLException {
            String query = "SELECT l.log_id AS 'Log ID', " +
                           "u.u_username AS 'Username', " +
                           "l.log_action AS 'Action', " +
                           "l.log_timestamp AS 'Timestamp' " +
                           "FROM tbl_logsemployee l " +
                           "JOIN tbl_admin u ON l.log_userid = u.u_id " +
                           "ORDER BY l.log_timestamp DESC";
            return getData(query);
        }
        
        public void logActivity3(int userId, String action) {
            String query = "INSERT INTO tbl_logsevaluator (log_userid, log_action) VALUES (?, ?)";
            try (PreparedStatement pstmt = connect.prepareStatement(query)) {
                pstmt.setInt(1, userId);
                pstmt.setString(2, action);
                pstmt.executeUpdate();
                System.out.println("Activity logged: " + action);
            } catch (SQLException e) {
                System.out.println("Error logging activity: " + e.getMessage());
            }
        }
        
        public ResultSet getLogs3() throws SQLException {
            String query = "SELECT l.log_id AS 'Log ID', " +
                           "u.u_username AS 'Username', " +
                           "l.log_action AS 'Action', " +
                           "l.log_timestamp AS 'Timestamp' " +
                           "FROM tbl_logsevaluator l " +
                           "JOIN tbl_admin u ON l.log_userid = u.u_id " +
                           "ORDER BY l.log_timestamp DESC";
            return getData(query);
        }
        
        public int getCount(String tableName) {
            try {
                String sql = "SELECT COUNT(*) FROM " + tableName;
                PreparedStatement pst = connect.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    return rs.getInt(1);
                }
            } catch (SQLException ex) {
                System.out.println("Error getting count: " + ex.getMessage());
            }
            return 0;
        }

        public int getActiveUsersCount() {
            try {
                String sql = "SELECT COUNT(*) FROM tbl_admin WHERE u_status = 'Active'";
                PreparedStatement pst = connect.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    return rs.getInt(1);
                }
            } catch (SQLException ex) {
                System.out.println("Error getting active users count: " + ex.getMessage());
            }
            return 0;
        }
        
        public int getCountWithCondition(String tableName, String condition) {
        int count = 0;
        try {
            String query = "SELECT COUNT(*) FROM " + tableName;
            if (condition != null && !condition.isEmpty()) {
                query += " WHERE " + condition;
            }

            ResultSet rs = getData(query);
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return count;
    }
}
