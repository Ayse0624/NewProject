package databasetest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection connectToDataBaseServer(String dbUrl,String dbPort,String dbUserName, String dbPassword,
                                                     String defaultDatabase,ConnectionType connectionType)

    {
        Connection connection=null;
        String JTDS_drivers="net.sourceforge.jdbc.Driver";
        String MYSQL_drivers="com.mysql.cj.jdbc.Driver";
        switch (connectionType){
            case MSSQLSERVER:
                try {
                    Class.forName(JTDS_drivers);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                String connectURL="jdbc:jtds:sqlserver://"+dbUrl+":"+";databaseNames="+defaultDatabase;
                try {
                    connection= DriverManager.getConnection(connectURL,dbUserName,dbPassword);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case MYSQLSERVER:
                try {
                    Class.forName(MYSQL_drivers).newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                String mySqlConnection="jdbc:mysql://"+dbUrl+":"+dbPort+"/"+defaultDatabase;
                try {
                    connection=DriverManager.getConnection(mySqlConnection,dbUserName,dbPassword);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("please specify the Connection type(Mssql or mysql");
        }
        try {
            if (!connection.isClosed()){
                System.out.println(" database connection is established");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;

    }
    public static void closeDatabaseConnection(Connection connection){
        try {
            if (connection.isClosed() ){
                System.out.println("Database has been closed");
            }
            else
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("database connection closed");
        }

    }


