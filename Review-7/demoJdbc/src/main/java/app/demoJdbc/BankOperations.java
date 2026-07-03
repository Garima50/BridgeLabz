package app.demoJdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import java.sql.ResultSet;

public class BankOperations {

    public static void createAccount(Connection con) {

            Scanner sc = new Scanner(System.in);

            try {

                // Customer Details
                System.out.print("Enter Customer ID: ");
                int customerId = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Customer Name: ");
                String customerName = sc.nextLine();

                System.out.print("Enter Email: ");
                String email = sc.nextLine();

                System.out.print("Enter City: ");
                String city = sc.nextLine();

                System.out.print("Enter Mobile Number: ");
                long mobile = sc.nextLong();

                // SQL query to insert customer details into Customer table
                String customerQuery = "INSERT INTO Customer VALUES(?,?,?,?,?)";

                // PreparedStatement to execute SQL queries with parameters
                PreparedStatement ps1 = con.prepareStatement(customerQuery);

                ps1.setInt(1, customerId);
                ps1.setString(2, customerName);
                ps1.setString(3, email);
                ps1.setString(4, city);
                ps1.setLong(5, mobile);

                ps1.executeUpdate();

                // Account Details
                System.out.print("Enter Account Number: ");
                int accountNo = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter Account Type: ");
                String accountType = sc.nextLine();

                System.out.print("Enter Balance: ");
                double balance = sc.nextDouble();

                sc.nextLine();

                System.out.print("Enter Opening Date (YYYY-MM-DD): ");
                String openingDate = sc.nextLine();

                // SQL query to insert sccount details into account table
                String accountQuery =
                        "INSERT INTO Account VALUES(?,?,?,?,?)";

                PreparedStatement ps2 = con.prepareStatement(accountQuery);

                ps2.setInt(1, accountNo);
                ps2.setInt(2, customerId);
                ps2.setString(3, accountType);
                ps2.setDouble(4, balance);
                ps2.setString(5, openingDate);

                ps2.executeUpdate();

                System.out.println("Account Created Successfully");

            } catch (SQLException e) {

                System.out.println(e);

            }

    }

    // Method to deposit money into an account
    public static void deposit(Connection con) {

        // Scanner object to take input
        Scanner sc = new Scanner(System.in);

        try {

            // Take account number from user
            System.out.print("Enter Account Number: ");
            int accountNo = sc.nextInt();

            // Take deposit amount
            System.out.print("Enter Deposit Amount: ");
            double amount = sc.nextDouble();

            // SQL query to update account balance
            String updateQuery =
                    "UPDATE Account SET Balance = Balance + ? WHERE Account_no = ?";

            // Create PreparedStatement object for sql query parameters
            PreparedStatement ps1 = con.prepareStatement(updateQuery);

            // Set values for placeholders
            ps1.setDouble(1, amount);
            ps1.setInt(2, accountNo);

            // Execute update query which returns no. of rows in the result set
            int rows = ps1.executeUpdate();

            // If account exists
            if (rows > 0) {

                // Take transaction details
                System.out.print("Enter Transaction ID: ");
                int transactionId = sc.nextInt();

                System.out.print("Enter Transaction Date (YYYY-MM-DD): ");
                String transactionDate = sc.next();

                // SQL query to store transaction history
                String insertQuery =
                        "INSERT INTO Transactions VALUES(?,?,?,?,?)";

                PreparedStatement ps2 = con.prepareStatement(insertQuery);

                ps2.setInt(1, transactionId);
                ps2.setInt(2, accountNo);
                ps2.setString(3, "Deposit");
                ps2.setDouble(4, amount);
                ps2.setString(5, transactionDate);

                // Insert transaction
                ps2.executeUpdate();

                System.out.println("Amount Deposited Successfully");
            }
            else {

                System.out.println("Account Not Found");
            }

        }
        catch (SQLException e) {

            System.out.println(e);
        }
    }
    // Method to withdraw money from an account
    public static void withdraw(Connection con) {

        Scanner sc = new Scanner(System.in);

        try {

            // Take account number
            System.out.print("Enter Account Number: ");
            int accountNo = sc.nextInt();

            // Take withdrawal amount
            System.out.print("Enter Withdrawal Amount: ");
            double amount = sc.nextDouble();

            // Update balance after withdrawal
            String updateQuery =
                    "UPDATE Account SET Balance = Balance - ? WHERE Account_no = ?";

            PreparedStatement ps1 = con.prepareStatement(updateQuery);

            ps1.setDouble(1, amount);
            ps1.setInt(2, accountNo);

            int rows = ps1.executeUpdate();

            if (rows > 0) {

                // Store transaction history
                System.out.print("Enter Transaction ID: ");
                int transactionId = sc.nextInt();

                System.out.print("Enter Transaction Date (YYYY-MM-DD): ");
                String transactionDate = sc.next();

                String insertQuery =
                        "INSERT INTO Transactions VALUES(?,?,?,?,?)";

                PreparedStatement ps2 = con.prepareStatement(insertQuery);

                ps2.setInt(1, transactionId);
                ps2.setInt(2, accountNo);
                ps2.setString(3, "Withdraw");
                ps2.setDouble(4, amount);
                ps2.setString(5, transactionDate);

                ps2.executeUpdate();

                System.out.println("Amount Withdrawn Successfully");
            }
            else {

                System.out.println("Account Not Found");
            }

        }
        catch (SQLException e) {

            System.out.println(e);
        }

    }
    // Method to transfer money from one account to another
    public static void transferMoney(Connection con) {

        // Scanner object to take input from the user
        Scanner sc = new Scanner(System.in);

        try {

            // Take sender's account number
            System.out.print("Enter Sender Account Number: ");
            int senderAccount = sc.nextInt();

            // Take receiver's account number
            System.out.print("Enter Receiver Account Number: ");
            int receiverAccount = sc.nextInt();

            // Take transfer amount
            System.out.print("Enter Transfer Amount: ");
            double amount = sc.nextDouble();

            // ================= Deduct money from sender =================

            // SQL query to subtract the transfer amount from sender's balance
            String senderQuery =
                    "UPDATE Account SET Balance = Balance - ? WHERE Account_no = ?";

            // Create PreparedStatement for sender account
            PreparedStatement ps1 = con.prepareStatement(senderQuery);

            ps1.setDouble(1, amount);
            ps1.setInt(2, senderAccount);

            // Execute UPDATE query
            int senderRows = ps1.executeUpdate();

            // ================= Add money to receiver =================

            // SQL query to add the transfer amount to receiver's balance
            String receiverQuery =
                    "UPDATE Account SET Balance = Balance + ? WHERE Account_no = ?";

            // Create PreparedStatement for receiver account
            PreparedStatement ps2 = con.prepareStatement(receiverQuery);

            // Replace first ? with transfer amount
            ps2.setDouble(1, amount);

            // Replace second ? with receiver account number
            ps2.setInt(2, receiverAccount);

            // Execute UPDATE query
            int receiverRows = ps2.executeUpdate();

            // Check whether both accounts were updated successfully
            if (senderRows > 0 && receiverRows > 0) {

                System.out.println("Money Transferred Successfully");

            } else {

                System.out.println("Invalid Account Number");
            }

        } catch (SQLException e) {

            // Display SQL error if query execution fails
            System.out.println(e);
        }
    }

    // Method to display the details of a particular account
    public static void displayAccountDetails(Connection con) {

        // Scanner object to take input from the user
        Scanner sc = new Scanner(System.in);

        try {

            // Ask the user to enter the account number
            System.out.print("Enter Account Number: ");
            int accountNo = sc.nextInt();

            // SQL query to fetch account details of the given account number
            String query = "SELECT * FROM Account WHERE Account_no = ?";

            // Create PreparedStatement object
            PreparedStatement ps = con.prepareStatement(query);

            // Replace ? with the account number entered by the user
            ps.setInt(1, accountNo);

            // Execute SELECT query
            // executeQuery() returns the result in the form of a ResultSet object
            ResultSet rs = ps.executeQuery();

            // Check whether any record is returned
            if (rs.next()) {

                System.out.println("\n===== ACCOUNT DETAILS =====");

                // Fetch and display Account Number
                System.out.println("Account Number : " +
                        rs.getInt("Account_no"));

                // Fetch and display Customer ID
                System.out.println("Customer ID    : " +
                        rs.getInt("Customer_id"));

                // Fetch and display Account Type
                System.out.println("Account Type   : " +
                        rs.getString("Account_type"));

                // Fetch and display Current Balance
                System.out.println("Balance        : " +
                        rs.getDouble("Balance"));

                // Fetch and display Opening Date
                System.out.println("Opening Date   : " +
                        rs.getDate("Opening_date"));

            }
            else {

                // Executes if the account number is not found
                System.out.println("Account Not Found");
            }

        } catch (SQLException e) {

            // Display SQL error if any database operation fails
            System.out.println(e);
        }
    }
    // Method to display all transactions of a particular account
    public static void displayTransactionHistory(Connection con) {

        // Scanner object to take input from the user
        Scanner sc = new Scanner(System.in);

        try {

            // Ask the user to enter the account number
            System.out.print("Enter Account Number: ");
            int accountNo = sc.nextInt();

            // SQL query to fetch all transactions of the given account
            String query = "SELECT * FROM Transactions WHERE Account_no = ?";

            // Create PreparedStatement object
            PreparedStatement ps = con.prepareStatement(query);

            // Replace ? with the account number entered by the user
            ps.setInt(1, accountNo);

            // Execute SELECT query
            // executeQuery() returns the result as a ResultSet
            ResultSet rs = ps.executeQuery();

            // Display heading
            System.out.println("\n===== TRANSACTION HISTORY =====");

            // Traverse all rows returned by the query
            while (rs.next()) {

                // Display one transaction at a time
                System.out.println("----------------------------------");

                // Fetch and display Transaction ID and other data
                System.out.println("Transaction ID   : "
                        + rs.getInt("Transaction_id"));

                System.out.println("Account Number   : "
                        + rs.getInt("Account_no"));

                System.out.println("Transaction Type : "
                        + rs.getString("Transaction_type"));

                System.out.println("Amount           : "
                        + rs.getDouble("Amount"));

                System.out.println("Transaction Date : "
                        + rs.getDate("Transaction_date"));
            }

        } catch (SQLException e) {

            // Display SQL exception if any database error occurs
            System.out.println(e);

        }

    }

}