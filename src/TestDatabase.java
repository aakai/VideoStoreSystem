import java.sql.*;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anearcan
 */
public class TestDatabase {
    
    public TestDatabase(){
    
    }
    
    public static void main(String[] args){
        try{
            Class.forName("com.mysql.jdbc.Driver");//load the  MySQL Driver
            String connectionUrl = "jdbc:mysql://host111.hostmonster.com/sourceit_VideoStore";
            Connection con = DriverManager.getConnection(connectionUrl, "sourceit_SYSC","sysc4907");
        } catch(SQLException e){
            System.out.print("SQLException: "+e.toString());
        } catch(ClassNotFoundException cE){
            System.out.print("Class not found exception: " + cE.toString());
        }
    }
}
