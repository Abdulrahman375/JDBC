import java.sql.*;
import java.util.*;
public class prepared_statment {
   static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/assgiment";
   static final String USER = "root";
   static final String PASS = "";
   static final String QUERY1 = "select seller_name,email,postal_address	 FROM seller";
   public static void main(String args[]) throws SQLException {
      Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
      String query = "INSERT INTO seller(seller_name,email,postal_address) VALUES (?, ?, ?)";
      PreparedStatement pstmt = con.prepareStatement(query);

      Scanner scanner = new Scanner(System.in);

      System.out.println("Enter seller name ");
      pstmt.setString(1, scanner.nextLine());
      System.out.println("Enter Email ");
      pstmt.setString(2, scanner.nextLine());
      System.out.println("Enter postal address ");
      pstmt.setString(3, scanner.nextLine());

      int num = pstmt.executeUpdate();

      if (num >= 1)
         System.out.println("\n  Rows inserted successfully number of rows affected : " + num);
      try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();) {
         ResultSet rs1 = stmt.executeQuery(QUERY1);
         System.out.println("\nTable After insert :");
         {
            while (rs1.next()) {
               // Retrieve by column name
               System.out.print("seller name :  " + rs1.getString("seller_name") + " \t\t ");
               System.out.print("Email:  " + rs1.getString("email") + "\t\t\t\t");
               System.out.print("Postal address:  " + rs1.getString("postal_address") + "\n\n");
            }

         }
      } catch (SQLException e) {
         e.printStackTrace();
      }

   }
}