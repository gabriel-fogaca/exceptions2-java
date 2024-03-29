package application;

import model.entities.Account;
import model.exceptions.DomainException;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("Enter account data");
            System.out.print("Number: ");
            int number = sc.nextInt();
            System.out.print("Holder: ");
            sc.next();
            String holder = sc.nextLine();
            System.out.print("Initial balance: ");
            double balance = sc.nextDouble();
            System.out.print("Withdraw limit: ");
            double withdraw = sc.nextDouble();
            Account acc = new Account(number, holder, balance, withdraw);
            System.out.println("");
            System.out.print("Enter amount for withdraw: ");
            double amount = sc.nextDouble();
            acc.withdraw(amount);
            System.out.printf("New Balance: %.2f%n" + acc.getBalance());
        }
        catch (DomainException e){
            System.out.println("Withdraw error: " + e.getMessage());
        }
        sc.close();
    }
}
