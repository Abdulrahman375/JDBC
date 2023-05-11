import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class update {
   static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/assgiment";
   static final String USER = "root";
   static final String PASS = "";
   static final String sql = "update product set price = price - (price * 0.15) where category_id = 05 ";
   static final String QUERY1 = "select prod_name,category_id ,price FROM product where category_id =05";

   public static void main(String[] args){

    try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
    Statement stmt = conn.createStatement();
    ){

      stmt.executeUpdate(sql);
    ResultSet rs1 = stmt.executeQuery(QUERY1); 
    {

    while ( rs1.next()) {
       // Retrieve by column name
       System.out.print("prod_name :  " + rs1.getString("prod_name")+ " \t\t ");
       System.out.print("catagory_id:  " + rs1.getInt("category_id")+"\t\t\t\t");
       System.out.print("Price:  " + rs1.getFloat("price")+"\n\n");

    }

    }
 } catch (SQLException e) {
    e.printStackTrace();
 } 
   }
}