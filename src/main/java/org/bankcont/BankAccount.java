package org.bankcont;

import java.util.Scanner;

import static java.lang.System.exit;
import static org.bankcont.Main.mainMenu;

public class BankAccount {

        double balance;
        String name;
        int accountNum = 0;

        public BankAccount(String name,double balance, int accountNum) {
            this.name = name;
            this.balance = balance;
            this.accountNum = accountNum;

        }

        //new constructor
            public BankAccount() {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Are you an existing customer? (-1 to exit)");
            System.out.println("1. Yes");
            System.out.println("2. No");

            String input = scanner.nextLine();

            if (input.equals("1")){
                System.out.println("What is your account number?");
                int accNum = Integer.parseInt(scanner.nextLine());

            } else if (input.equals("2")){

                System.out.println("What is the name for the account?");
                this.name = scanner.nextLine();

                System.out.println("What's the starting balance for the account?");
                this.balance = Double.parseDouble(scanner.nextLine());


            }
            else if (input.equals("-1")){
                System.exit(0);

            }

            }

    //deposit
        public void deposit(double depAmount){
            this.balance += depAmount;

        }

        //withdrawal
        public void withdrawal(double wdrlAmount){
            this.balance -= wdrlAmount;

        }
        //printDetails
        public void printDetails(){
            System.out.println("The account for: "+this.name);
            System.out.println("Has an account balance of: "+this.balance);
        }

        public void transfer(BankAccount transferTo, double trsfrAmt){

            withdrawal(trsfrAmt);
            transferTo.deposit(trsfrAmt);

            printDetails();

            transferTo.printDetails();


        }




}
