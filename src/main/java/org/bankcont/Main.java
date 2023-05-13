package org.bankcont;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<BankAccount> bankAccounts = new ArrayList<>();

        bankAccounts.add((new BankAccount("CTAC", 5000, 1))); //mock account to have at least one account in the array
        BankAccount newAccount = new BankAccount(); // constructor with no arguments
        newAccount.accountNum = 2;
        bankAccounts.add(newAccount);
        mainMenu(bankAccounts.get(1),bankAccounts); // testing main menu using an assumed index of 1 after the above methods are run


        }

        public static void mainMenu(BankAccount bankAccount, ArrayList<BankAccount> bankAccounts ){
            Scanner scanner = new Scanner(System.in);

            System.out.println("Hello " + bankAccount.name + "!");
            System.out.println("Welcome to the Main Menu, what would you like to do today?");
            System.out.println("1. To check account balance");
            System.out.println("2. To make a withdrawal");
            System.out.println("3. To make a deposit");
            System.out.println("4. To make a transfer to another account");
            System.out.println("0. To exit.");

            String input = scanner.nextLine();

            if(input.equals("1")){
                bankAccount.printDetails();

            }else if (input.equals("2")){
                System.out.println("How much would you like to withdraw?");
                double wthdrwAmt = Double.parseDouble(scanner.nextLine());
                bankAccount.withdrawal(wthdrwAmt);
                System.out.println("Your new balance is: "+bankAccount.balance);
                System.out.println("");
                mainMenu(bankAccounts.get(1),bankAccounts);
            }
            else if (input.equals("3")){
                System.out.println("How much would you like to deposit?");
                double deposAmt = Double.parseDouble(scanner.nextLine());
                bankAccount.deposit(deposAmt);
                System.out.println("Your new balance is: "+bankAccount.balance);
                System.out.println("");
                mainMenu(bankAccounts.get(1),bankAccounts);
            }
            else if (input.equals("4")){

                System.out.println("Please enter the account number to transfer to");
                int accNum = Integer.parseInt(scanner.nextLine());

                if(bankAccounts.contains(bankAccounts.get(accNum))){
                    System.out.println("Please enter the amount you want transferred.");
                    double amount = scanner.nextDouble();
                    bankAccount.transfer(bankAccounts.get(accNum),amount);
                    System.out.println("");
                    mainMenu(bankAccounts.get(1),bankAccounts);
                }
                else {
                    System.out.println("No account found");
                    System.out.println("");
                    mainMenu(bankAccounts.get(1),bankAccounts);
                }


            }
            else if (input.equals("0")){
                System.exit(0);
            }




        }
    }
