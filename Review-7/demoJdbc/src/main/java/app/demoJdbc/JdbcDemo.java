package app.demoJdbc;

import java.sql.*;
import java.util.Scanner;

import static java.sql.DriverManager.getConnection;

public class JdbcDemo {

    public static void main(String[] args) {

        Connection con = DBConnection.getConnection();

        if (con != null)
            System.out.println("Database Connected Successfully");
        else
            System.out.println("Connection Failed");

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Amount");
            System.out.println("3. Withdraw Amount");
            System.out.println("4. Transfer Money");
            System.out.println("5. Display Account Details");
            System.out.println("6. Display Transaction History");
            System.out.println("7. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    BankOperations.createAccount(con);
                    break;

                case 2:
                    BankOperations.deposit(con);
                    break;

                case 3:
                    BankOperations.withdraw(con);
                    break;

                case 4:
                    BankOperations.transferMoney(con);
                    break;

                case 5:
                    BankOperations.displayAccountDetails(con);
                    break;

                case 6:
                    BankOperations.displayTransactionHistory(con);
                    break;

                case 7:
                    System.out.println("Thank You");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 7);

        sc.close();
    }

}

//    public static void main(String[] args) throws SQLException {
//
//        // jdbc url to connect with mysql
//        String url = "jdbc:mysql//localhost:3306/jdbc_demo";
//        // username & password
//        final String user = "root";
//        final String pass = "Pari1234**";
//        // sql query string
//        String query = "SELECT * from Customer";
//
//        b
//    }

//        // establish connection with mysql driver
//        Connection connection = DriverManager.getConnection(url, user, pass);
//
//        // create statement object
//        Statement statement = connection.createStatement();
//
//        // execute query to resultSet
//        ResultSet resultSet = statement.executeQuery(query);

        //iterate the resultSet rows
//        while(resultSet.next()) {
//            int id = resultSet.getInt("Customer_id");
//            String name = resultSet.getString("Customer_name");
//            String email = resultSet.getString("Email");
//            String city = resultSet.getString("City");
//            Long mobile = resultSet.getLong("Mobile_number");
//
//        }




