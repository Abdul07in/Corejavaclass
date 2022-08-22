package atm;

import java.util.Scanner;

public class AtmSimulator {
    Scanner sc = new Scanner(System.in);
    private int pin, bal = 1000, dep, with;

    public static void main(String[] args) {
        AtmSimulator obj = new AtmSimulator();
        obj.welcome();
        int check = obj.pinVerify();
        if (check == 123) {
            obj.verifiedMenu();
        } else {
            System.out.println("ERROR: wrong pin");
        }
    }

    void welcome() {
        System.out.println("-----SQUAD--------------------");
        System.out.println("------------ATM---------------");
        System.out.println("------------------SIMULATOR---");
    }

    int pinVerify() {
        System.out.print("\nEnter Your Pin:");
        pin = sc.nextInt();
        return pin;
    }

    int menu() {
        System.out.println("\n-----WELCOME TO SQUAD ATM-----");
        System.out.println("\n1.Deposit\n2.Withdraw\n3.Check Balance");
        System.out.print("\nEnter your option: ");
        int ch = sc.nextInt();
        return ch;
    }

    void verifiedMenu() {
        int ch = menu();
        for (int i = 3; i >= 1; i--) {
            if (i == 1) {
                System.out.println("You Exceeded No. Attempts");
                System.exit(0);
            } else {
                switch (ch) {
                    case 1:
                        depositingMoney();
                        break;
                    case 2:
                        withdrawMoney();
                        break;
                    case 3:
                        checkBalance();
                        break;
                    default:
                        System.out.println("\nINVALID INPUT [" + (i - 1) + " attempts left]");
                        menu();
                        break;
                }
            }
        }

    }

    void depositingMoney() {
        System.out.print("\nEnter amount to deposit: ");
        dep = sc.nextInt();
        if (dep > 0) {
            bal = bal + dep;
            System.out.println("\nTRANSACTION COMPLETED.");
        } else {
            System.out.println("\nERROR: Negative Amount Entered.");
        }
        continueMenu();
    }

    void withdrawMoney() {
        System.out.print("\nEnter amount to withdraw: ");
        with = sc.nextInt();
        if (with <= bal && with > 0) {
            bal = bal - with;
            System.out.println("\nTRANSACTION COMPLETED.");
        } else {
            System.out.println("\nERROR: Your Withdraw amount is more than your balance");
        }
        continueMenu();
    }

    void checkBalance() {
        System.out.println("\nYour Current Balance is " + bal);
        System.out.println("\nTRANSACTION COMPLETED.");
        continueMenu();
    }

    void continueMenu() {
        System.out.println("\nDo you want to continue ? [1 = yes || 2 = no]");
        int a = sc.nextInt();
        if (a == 1) verifiedMenu();
        else {
            System.out.println("\nThank You");
            System.exit(0);
        }
    }
}
