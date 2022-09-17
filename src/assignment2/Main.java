package assignment2;

import java.util.Scanner;

class UserAccount {
    private int userId, balance;
    private String userName;

    public UserAccount(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserId = " + userId + " UserName = " + userName + " Balance = " + balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = this.balance + balance;
    }
}

public class Main {
    static Scanner sc = new Scanner(System.in);

    static {
        System.out.println("--------------------------------------");
        System.out.println("--------USER ACCOUNT PROGRAM----------");
        System.out.println("--------------------------------------");
    }

    int count = 0, id;
    String name;
    UserAccount[] users = new UserAccount[10];

    public static void main(String[] args) {
        Main obj = new Main();
        obj.startProgram();
    }

    private void addAccount() {
        System.out.println("\n-----------ADD ACCOUNT----------------\n");
        System.out.println("Enter number of account to add : ");
        int accounts = sc.nextInt();
        for (int i = 0; i < accounts; i++) {
            System.out.print("Enter User Id: ");
            id = sc.nextInt();
            System.out.print("Enter User Name: ");
            name = sc.next();
            users[i] = new UserAccount(id, name);
            count++;
        }
        continueMenu();
    }

    private void updateAccount() {
        System.out.println("\n-----------UPDATE ACCOUNT-------------\n");
        System.out.print("Enter User Id: ");
        int id = sc.nextInt();
        for (int i = 0; i < count; i++) {
            if (users[i] != null && users[i].getUserId() == id) {
                System.out.print("Enter User Id: ");
                id = sc.nextInt();
                users[i].setUserId(id);
                System.out.print("Enter User Name: ");
                name = sc.next();
                users[i].setUserName(name);
            }
        }
        continueMenu();
    }

    private void deleteAccount() {
        System.out.println("\n-----------DELETE ACCOUNT-------------\n");
        System.out.print("Enter User Id: ");
        int id = sc.nextInt();
        for (int i = 0; i < count; i++) {
            if (users[i] != null && users[i].getUserId() == id) {
                users[i] = null;
            }
        }
        System.out.println("ACCOUNT DELETED SUCCESSFULLY");
        continueMenu();
    }

    private void searchAccount() {
        System.out.println("\n-----------SEARCH ACCOUNT-------------\n");
        System.out.print("Enter User Id: ");
        int id = sc.nextInt();
        for (int i = 0; i < count; i++) {
            if (users[i] != null && users[i].getUserId() == id) {
                System.out.println(users[i]);
            }
        }
        continueMenu();
    }

    private void displayAccount() {
        System.out.println("\n-----------ALL ACCOUNT INFO-----------\n");
        for (int i = 0; i < count; i++) {
            if (users[i] != null) {
                System.out.println(users[i]);
            }
        }
        continueMenu();
    }

    private void depositMoney() {
        System.out.println("\n-------------DEPOSIT MONEY------------\n");
        System.out.print("Enter User Id: ");
        int id = sc.nextInt();
        for (int i = 0; i < count; i++) {
            if (users[i] != null && users[i].getUserId() == id) {
                System.out.println("Welcome " + users[i].getUserName() + ".");
                System.out.print("Enter amount to deposit: ");
                int amt = sc.nextInt();
                users[i].setBalance(amt);
            }
        }
        continueMenu();
    }

    private void withdrawMoney() {
        System.out.println("\n-------------WITHDRAW MONEY------------\n");
        System.out.print("Enter User Id: ");
        int id = sc.nextInt();
        for (int i = 0; i < count; i++) {
            if (users[i] != null && users[i].getUserId() == id) {
                System.out.println("Welcome " + users[i].getUserName() + ".");
                System.out.print("Enter amount to withdraw: ");
                int amt = sc.nextInt();
                if (amt > 0 && amt < users[i].getBalance()) {
                    users[i].setBalance(-amt);
                } else System.out.println("Error: not enough balance.");
            }
        }
        continueMenu();

    }


    private void startProgram() {
        int ch = menu();
        for (int i = 3; i >= 1; i--) {
            if (i == 1) {
                System.err.println("You Exceeded No. Attempts");
                System.exit(0);
            } else {
                switch (ch) {
                    case 1 -> addAccount();
                    case 2 -> updateAccount();
                    case 3 -> deleteAccount();
                    case 4 -> searchAccount();
                    case 5 -> displayAccount();
                    case 6 -> depositMoney();
                    case 7 -> withdrawMoney();
                    case 8 -> System.exit(0);
                    default -> {
                        System.out.println("\nINVALID INPUT [" + (i - 1) + " attempts left]");
                        startProgram();
                    }
                }
            }
        }
    }


    public int menu() {
        System.out.println("\n1.Add New Account");
        System.out.println("2.Update Existing Account");
        System.out.println("3.Delete Existing Account");
        System.out.println("4.Search Account");
        System.out.println("5.Display All Account");
        System.out.println("6.Deposit Money");
        System.out.println("7.Withdraw Money");
        System.out.println("8.Exit");
        System.out.print("\nEnter your Choice: ");
        return sc.nextInt();
    }

    private void continueMenu() {
        System.out.print("\nDo you want to continue ? [1 = yes || 2 = no]\n=>\t");
        int a = sc.nextInt();
        if (a == 1) startProgram();
        else {
            System.out.println("\nThank You");
            System.exit(0);
        }
    }
}
