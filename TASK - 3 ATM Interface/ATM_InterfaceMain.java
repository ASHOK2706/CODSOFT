
import java.util.ArrayList;
import java.util.Scanner;
class UserAccount{
    private int account_nummber;
    private String user_name;
    private double balance;

    public UserAccount(int account_nummber,String user_name,double balance){
        this.account_nummber = account_nummber;
        this.user_name = user_name;
        this.balance = balance;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public int getAccount_nummber() {
        return account_nummber;
    }
}
class ATM_Machine {
    Scanner in = new Scanner(System.in);
    private ArrayList<UserAccount> user_bank_acc = new ArrayList<UserAccount>();
    public ATM_Machine() {
        setUser_bank_acc();
    }
    public void Widthdraw(double entered_amount) {
        System.out.print("Enter Account Number : ");
        int acc_no = in.nextInt();
        UserAccount user_account = getAccount(acc_no);
        if(user_account!=null) {
            if(entered_amount>user_account.getBalance()) {
                System.out.println("Insuffecient Balance !!!");
            }
            else {
                user_account.setBalance(user_account.getBalance()-entered_amount);
                System.out.println("Widthdraw Successfull !!!");
                System.out.println("Remaning Balance : "+user_account.getBalance());
            }
        } 
        else {
            System.out.println("User Account Not Found");
        }
        
    }
    public void Deposite(double entred_amount) {
        System.out.print("Enter Account Number : ");
        int acc_no = in.nextInt();
        UserAccount user_account = getAccount(acc_no);
        if(user_account!=null) {
            user_account.setBalance(user_account.getBalance()+entred_amount);
            System.out.println("Amount Deposited Successfull !!!");
            System.out.println("Remaning Balance : "+user_account.getBalance());
        }
        else {
            System.out.println("User Account Not Found");
        }
    }
    public void CheckBalance() {
        System.out.print("Enter Account Number : ");
        int acc_no = in.nextInt();
        UserAccount user_account = getAccount(acc_no);
        if(user_account!=null) {
            System.out.println("Balance for Account no "+user_account.getAccount_nummber()+"  is :"+user_account.getBalance());
        }
        else {
            System.out.println("User Account Not Found !!!");
        }
    }
    private UserAccount getAccount(int acc_no) {
        for(UserAccount account : user_bank_acc) {
            if(acc_no == account.getAccount_nummber()) {
                return account;
            }
        }
        return null;
    }
    private void setUser_bank_acc() {
        user_bank_acc.add(new UserAccount(1,"name1",1000.0));
        user_bank_acc.add(new UserAccount(2,"name2",1000.0));
        user_bank_acc.add(new UserAccount(3,"name3",1000.0));
        user_bank_acc.add(new UserAccount(4,"name4",1000.0));
        user_bank_acc.add(new UserAccount(5,"name5",1000.0));
    }
}
public class ATM_InterfaceMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ATM_Machine atm_machine = new ATM_Machine();
        while(true) {
            System.out.println();
            System.out.println("1. Withdraw");
            System.out.println("2. Deposite");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.println();
            System.out.print("Enter Your Choice : ");
            int choice = in.nextInt();
            double amount = 0.0;
            switch(choice) {
                case 1:
                    System.out.print("Enter Amount To Widthdraw : ");
                    amount = in.nextDouble();
                    atm_machine.Widthdraw(amount);
                    break;
                case 2:
                    System.out.print("Enter Amount To Deposite : ");
                    amount = in.nextDouble();
                    atm_machine.Deposite(amount);
                    break;
                case 3:
                    atm_machine.CheckBalance();
                    break;
                case 4: 
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
                    break;      
            }
        }
    }
}