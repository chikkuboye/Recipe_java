import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Recipe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        while(true){
            System.out.println("Enter the option below");
            System.out.println("1 :Insert");
            System.out.println("2 :View");
            System.out.println("3 :Search");
            System.out.println("4 :Update");
            System.out.println("5 :Delete");
            System.out.println("6 :Exit");

            choice = sc.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Inserting data");
                    System.out.println("Name of the food");
                    String name = sc.next();
                    System.out.println("Category");
                    String cate = sc.next();
                    System.out.println("Taste");
                    String taste = sc.next();
                    System.out.println("price");
                    int price = sc.nextInt();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/recipe_db", "root", "");
                        String sql = "INSERT INTO `food`(`Name`, `Category`, `Taste`, `Price`) VALUES (?,?,?,?)";
                        PreparedStatement stmt = con.prepareStatement(sql);
                        stmt.setString(1,name);
                        stmt.setString(2,cate);
                        stmt.setString(3,taste);
                        stmt.setInt(4,price);
                        stmt.executeUpdate();


                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 2:
                    System.out.println("View the data");
                    break;
                case 3:
                    System.out.println("Search the data");
                    break;
                case 4:
                    System.out.println("Updayte the data");
                    break;
                case 5:
                    System.out.println("Delete the data");
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
}
