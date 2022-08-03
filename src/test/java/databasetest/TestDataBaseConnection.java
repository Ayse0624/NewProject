package databasetest;

import org.testng.annotations.Test;

import java.sql.Connection;

public class TestDataBaseConnection {
    String dbUrl="148.72.106.125";
    String port="3306";
    String userName="testautomation";
    String password="automation123!";
    String defaultShema="i4296639_cc2";

    @Test
    public void testConnection(){
        Connection connection=DBConnection.connectToDataBaseServer(dbUrl,port,userName,password,
                defaultShema,ConnectionType.MYSQLSERVER);
    }

}
