package com.company.aaditya;
import java.util.Scanner;

class Bank{
    private String accntNo;
    private String name;
    private long balance;
    Scanner in = new Scanner(System.in);
     void openAccount(){
        System.out.println("Enter account number : ");
        accntNo = in.next();
         System.out.println("Enter name : ");
         name = in.next();
         System.out.println("Enter Balance:");
         balance = in.nextLong();
    }
    void displayAccount(){
        System.out.println(accntNo+" "+name+" "+balance);
    }
    void deposit(){
        System.out.println("Enter the amount to be deposited : ");
        long amount = in.nextLong();
        balance += amount;
    }
    void withdraw(){
         long amt = in.nextLong();
         if(balance>=amt){
             balance = balance-amt;
         }else{
             System.out.println("Transaction failed");
         }
    }
    boolean searchAccnt(String accnt){
         if(accntNo.equals(accnt)){
             displayAccount();
             return true;
         }
         return false;
    }


}
public class Main {

    public static void main(String[] args) {
	   Scanner in = new Scanner(System.in);
        System.out.println("Input Customer : ");
        int n = in.nextInt();
        Bank[] customer = new Bank[n];
        for(int i = 0;i< customer.length;i++){
            customer[i] = new Bank();
            customer[i].openAccount();
        }
        int k;
        do{
            System.out.println("Main Menu\n1.Display\n2.Search Account\n3.Deposit\n4.Withdraw\n5.Exit");
            System.out.println("Choose a number:");
            k = in.nextInt();
            switch(k){
                case 1:
                    for(int i = 0;i<customer.length;i++){
                        customer[i].displayAccount();
                    }
                    break;
                case 2:
                    System.out.println("Enter Account number:");
                    String accntNo = in.next();
                    boolean found = false;
                    for(int i = 0;i< customer.length;i++){
                        found = customer[i].searchAccnt(accntNo);
                        if(found==true){
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("FAILED!! Account Not found");
                    }
                    break;
                case 3:
                    System.out.println("Enter Account number:");
                    accntNo = in.next();
                    boolean fnd = false;
                    for(int i = 0;i< customer.length;i++){
                        fnd = customer[i].searchAccnt(accntNo);
                        if(fnd==true){
                            customer[i].deposit();
                            break;
                        }
                    }
                    if(!fnd){
                        System.out.println("Error!! Enter valid Account Number");
                    }
                    break;
                case 4:
                    System.out.println("Enter Account no :");
                    String antNo = in.next();
                    fnd = false;
                    for(int i = 0;i< customer.length;i++){
                        fnd = customer[i].searchAccnt(antNo);
                        if(fnd==true){
                            customer[i].withdraw();
                            break;
                        }
                    }
                    if(!fnd){
                        System.out.println("Error!! Enter valid Account Number");
                    }
                    break;
                case 5:
                    System.out.println("EXIT");
                    break;

            }
        }
        while(k!=5);
    }
}
