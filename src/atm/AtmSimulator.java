package atm;

import java.text.NumberFormat;
import java.util.Scanner;

public class AtmSimulator {
    Scanner sc = new Scanner(System.in);
    private int bal = 1_000;

    public static void main(String[] args) {
        AtmSimulator obj = new AtmSimulator();
        int check = obj.pinVerify();
        if (check == 123) {
            obj.verifiedMenu();
        } else {
            System.err.println("ERROR: wrong pin");
        }
    }

    static {
        System.out.println("-----SQUAD--------------------");
        System.out.println("------------ATM---------------");
        System.out.println("------------------SIMULATOR---");
    }

    private int pinVerify() {
        System.out.print("\nEnter Your Pin:");
        return sc.nextInt();
    }

    private int menu() {
        System.out.println("\n-----WELCOME TO SQUAD ATM-----");
        System.out.println("\n1.Deposit\t2.Withdraw\n3.Check Balance\t4.Exit");
        System.out.print("\nEnter your option: ");
        return sc.nextInt();
    }

    private void verifiedMenu() {
        int ch = menu();
        for (int i = 3; i >= 1; i--) {
            if (i == 1) {
                System.err.println("You Exceeded No. Attempts");
                System.exit(0);
            } else {
                switch (ch) {
                    case 1 -> depositingMoney();
                    case 2 -> withdrawMoney();
                    case 3 -> checkBalance();
                    case 4 -> System.exit(0);
                    default -> {
                        System.err.println("\nINVALID INPUT [" + (i - 1) + " attempts left]");
                        menu();
                    }
                }
            }
        }

    }

    private void depositingMoney() {
        System.out.print("\nEnter amount to deposit: ");
        int dep = sc.nextInt();
        if (dep > 0) {
            bal = bal + dep;
            System.out.println("\nTRANSACTION COMPLETED.");
        } else {
            System.err.println("\nERROR: Negative Amount Entered.");
        }
        continueMenu();
    }

    private void withdrawMoney() {
        System.out.print("\nEnter amount to withdraw: ");
        int with = sc.nextInt();
        if (with <= bal && with > 0) {
            bal = bal - with;
            System.out.println("\nTRANSACTION COMPLETED.");
        } else {
            System.err.println("\nERROR: Your Withdraw amount is more than your balance");
        }
        continueMenu();
    }

    private void checkBalance() {
        System.out.println("\nYour Current Balance is " + NumberFormat.getCurrencyInstance().format(bal));
        System.out.println("\nTRANSACTION COMPLETED.");
        continueMenu();
    }

     private void continueMenu() {
        System.out.println("\nDo you want to continue ? [1 = yes || 2 = no]");
        int a = sc.nextInt();
        if (a == 1) verifiedMenu();
        else {
            System.out.println("\nThank You");
            System.exit(0);
        }
    }
}
