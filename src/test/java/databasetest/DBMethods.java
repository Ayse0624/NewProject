//package databasetest;
//
//import javax.sql.rowset.CachedRowSet;
//import javax.sql.rowset.RowSetProvider;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class DBMethods {
//    public boolean getProduct(String productName, Connection connection) {
//        boolean isProductExist = false;
//        Statement statement = null;
//        ResultSet resultSet = null;
//        CachedRowSet cachedRowSet = null;
//
//        try {
//            cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            statement = connection.createStatement();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        String script = String.format("select product_id,name,price from cc_CubeCart_inventory where name=%s");
//        try {
//            resultSet = statement.executeQuery(script);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        if (cachedRowSet == null) {
//            System.out.println("No records fun");
//            return isProductExist;
//
//        } else {
//            try {
//                cachedRowSet.populate((resultSet));
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//
//    }
//}
