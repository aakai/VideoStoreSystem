/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anearcan
 */
import java.sql.*;
import javax.sql.*;

public class jdbcdemo{

    public static void main(String args[]){
        String dbtime;
        String dbUrl = "jdbc:mysql://host111.hostmonster.com:3306/sourceit_VideoStore";
        String dbClass = "com.mysql.jdbc.Driver";
        String query = "SELECT * FROM games";

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection (dbUrl, "sourceit_SYSC","sysc4907");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                dbtime = rs.getString(1);
                System.out.println(dbtime);
            } //end while

            con.close();
        } //end try

        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        catch(SQLException e) {
            e.printStackTrace();
        }

    }  //end main

}  //end class
