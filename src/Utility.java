
import java.util.Calendar;
import java.util.Date;
import java.util.logging.*;
import javax.swing.*;
import java.sql.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anearcan
 */
public class Utility {
    static Connection con ;
    static String  dbUrl = "jdbc:mysql://localhost:3306/sourceit_vss";
    static Statement stmt;
    static PreparedStatement pStmt;
    
    
    public Utility() throws SQLException{
           con = DriverManager.getConnection (dbUrl, "root","");

    }
    
    
    public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, + days); //minus number would decrement the days
        return cal.getTime();
    }


    public static void returnToMainMenu(Employee employee) throws ClassNotFoundException, SQLException {
            if(employee.IsAdmin() == true){
            try {
                new AdminLoginSuccess(employee).setVisible(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GameInfo.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(GameInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
               
            }else {
                new LoginSuccessful(employee).setVisible(true);
     
            }
    }
    
    public static void connect() throws ClassNotFoundException, SQLException{
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection (dbUrl, "root","");
                //stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        }

}
