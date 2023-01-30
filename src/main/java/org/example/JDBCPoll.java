package org.example;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
class DataBaseConnection{
    static DataBaseConnection dbc=null;
    static Logger l=Logger.getLogger("com.api.jar");
    private DataBaseConnection(){}
    Connection conn;
    public static DataBaseConnection getDataBaseConnection(){
        if(dbc==null)
            dbc=new DataBaseConnection();
        return dbc;
    }
    protected void newConnection(String url,String user,String pass) throws SQLException{
        this.conn= DriverManager.getConnection(url,user,pass);
        l.info("New Connection Connected Successfully");
    }
    protected void closeConnection() throws SQLException{
        this.conn.close();
        l.info("All Connection Closed Successfully");
    }
}
public class JDBCPoll {
    public static void main(String[] args) {
        Logger l=Logger.getLogger("com.api.jar");
        Scanner sc=new Scanner(System.in);
        try {
            l.info("Welcome to jdbc Connection Pool Demo Program");
            l.info("Enter the url:");
            String url = sc.nextLine();
            l.info("Enter the username:");
            String user = sc.nextLine();
            l.info("Enter the password:");
            String pass = sc.nextLine();
            int n = 0;
            while (n < 4) {
                l.info("Enter your choice:");
                l.info("""
                        1.New connection
                        2.New connection with different url or username
                        3.Close all connection
                        Enter some other numbers to Exit""");
                n = sc.nextInt();
                sc.nextLine();
                switch (n) {
                    case 1 -> {
                        DataBaseConnection d1 = DataBaseConnection.getDataBaseConnection();
                        d1.newConnection(url, user, pass);
                    }
                    case 2 -> {
                        l.info("Enter the url:");
                        String url2 = sc.nextLine();
                        l.info("Enter the username:");
                        String user2 = sc.nextLine();
                        l.info("Enter the password:");
                        String pass2 = sc.nextLine();
                        DataBaseConnection d2 = DataBaseConnection.getDataBaseConnection();
                        d2.newConnection(url2, user2, pass2);
                    }
                    case 3 -> {
                        DataBaseConnection d3 = DataBaseConnection.getDataBaseConnection();
                        d3.closeConnection();
                    }
                    default -> l.info("Thanks for coming");

                }
            }
        }catch (Exception ex){
            l.log(Level.INFO, () -> "Error occur: " + ex);
        }
    }
}
