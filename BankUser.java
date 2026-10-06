package projCode;
import java.util.Scanner;
public class BankUser {
	public static void main(String[] args) {
		boolean check = true;
		while(check) {
			Scanner sc = new Scanner(System.in);
			Bank bank = new Bank();
			System.out.println("1. Register\n2. Login\n3. Exit");
			int ch = sc.nextInt();
			switch(ch) {
			case 1->{
				BankController.doRegister();
			}
			case 2->{
				if(BankController.bank.getUserName()!=null) {
					if(BankController.isLoginSuccess()) {
						System.out.println("Welcome to Bank of Baroda..");
						while(check) {
							System.out.println("1.Open Savings\n2.Passbook\n3.Check Balance\n4.Deposit\n5.Withdraw\n6.Generate Pin\n7.Change Pin \n8.Logout");
							int choice=sc.nextInt();
							switch(choice) {
							case 1->{
								BankController.openSavingsAccount();
							}
							case 2 ->{
								BankController.passbook();
							}
							case 3->{
								BankController.checkBalance();
							}
							case 4 ->{
								BankController.deposit();
							}
							
							case 5 ->{
								BankController.withdraw();
							}
							case 6 ->{
								BankController.generatePin();
							}
							case 7 ->{
								BankController.changepin();
							}
							case 8->{
								BankController.logout();
								check=false;
							}
							}
						}
					}
					else
						System.out.println("Login Failed..");
				}
				else {
					System.out.println("Please do register");
				}
			}
			case 3->{
				System.out.println("Thank You 🙏🙏🙏");
				return;
			}
			}
		}
	}
}




