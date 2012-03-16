
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
public class CustomDate {

    public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, + days); //minus number would decrement the days
        return cal.getTime();
    }

    void returnToMainMenu(Employee employee) {
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

}
