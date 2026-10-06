package projCode;
import java.util.Scanner;
import java.util.jar.Attributes.Name;
public class BankController {
	public static Scanner sc = new Scanner(System.in);
	public static Bank bank = new Bank();
	private static int count;
	
	public static void doRegister() {
		System.out.print("Enter Username : ");
		bank.setUserName(sc.next());
		System.out.print("Enter Password : ");
		bank.setPwd(sc.next());
		System.out.println("Registration Successful...!");
	}
	public static boolean isLoginSuccess() {
		System.out.print("Enter Username : ");
		String userName = sc.next();
		System.out.print("Enter Password : ");
		String pwd = sc.next();
		return userName.equals(bank.getUserName())&& pwd.equals(bank.getPwd());
	}
	public static void openSavingsAccount() {
		System.out.print("Enter Username : ");
		bank.setName(sc.next());
		System.out.print("Enter Phone Number : ");
		bank.setPh(sc.nextLong());
		System.out.print("Enter Email : ");
		bank.setEmail(sc.next());
		System.out.print("Enter Aadhar : ");
		bank.setAadhar(sc.next());
		bank.setAccno(generateAccountNumber());
		bank.setBalance(10000);
		bank.setIfsc("BOB000264");
		System.out.println("Account Opened Successfully...😊");
	}
	public static String generateAccountNumber() {
		String accNo = "1234";
		long no = 6584787l;
		no = no*++count;
		String accNoString2 = no+"";
		for(int i =0;i<=6;i++) {
			accNo += accNo.charAt(i);
		}
		return accNo;
	}
	public static void passbook() {
		System.out.println("**********************Passbook************************");
		System.out.println("Account Holder : " + bank.getUserName());
		System.out.println("Account Number : " + bank.getAccno());
		System.out.println("IFSC Code : " + bank.getIfsc());
		System.out.println("=========================================================");
	}
	public static void checkBalance() {
		if(bank.getPin()!=0) {
			System.out.println("Enter Pin : ");
			int pin=sc.nextInt();
			if (pin==bank.getPin()) {
				System.out.println("Balance is : " + bank.getBalance());
			}
			else {
				System.out.println("Entered Pin is wrong...");
			}
		}
		else {
			System.out.println("Pin not generated");
		}
		
	}
	public static void withdraw() {
		System.out.println("Enter amount : ");
		double amt = sc.nextDouble();
		System.out.println("Enter pin : ");
		int pin = sc.nextInt();
		if(pin == bank.getPin()) {
			if(bank.getBalance()<=0) {
				System.out.println("Insufficient Balance...");
			}
			if(amt<=bank.getBalance()) {
				bank.setBalance(bank.getBalance()-amt);
				System.out.println("Transaction Successful");
			} else {
				System.out.println("Insufficient balance");
			}
		}
		else {
			System.out.println("Entered pin is wrong");
		}
	}
	public static void generatePin() {
		System.out.print("Enter account number : ");
		String acno = sc.next();
		System.out.print("Enter phone number : ");
		long phn = sc.nextLong();
		if(acno.equals(bank.getAccno()) && phn==bank.getPh()) {
			System.out.print("Enter Pin : ");
			int pin = sc.nextInt();
			System.out.print("Confirm Pin : ");
			int cpin = sc.nextInt();
			if(pin == cpin) {
				bank.setPin(cpin);
				System.out.println("Pin generated successfully...");
			}
			else {
				System.out.println("Pins doesn't match");
			}
		}
		else {
			System.out.println("Invalid Credentials...");
		}
	}
	public static void changepin() {
		System.out.println("Enter old pin : ");
		int opin=sc.nextInt();
		if(opin==bank.getPin()) {
			System.out.println("Enter new pin : ");
			int npin = sc.nextInt();
			System.out.println("Confirm pin : ");
			int onpin = sc.nextInt();
			if(npin==onpin) {
				bank.setPin(onpin);
				System.out.println("Pin changed successfully...");
			}
			else {
				System.out.println("Pins doesn't match");
			}
		}
		else {
			System.out.println("Enter correct pin...");
		}
	}
	public static void deposit() {
		System.out.println("Enter amount to deposit : ");
		double damt = sc.nextDouble();
		System.out.println("Enter pin : ");
		int pin = sc.nextInt();
		if(pin == bank.getPin()) {
			if(damt<=0) {
				System.out.println("Invaid amount");
			}
			else {
				bank.setBalance(bank.getBalance()+damt);
				System.out.println("Transaction Successful");
			}
		}
		else {
			System.out.println("Entered Pin is wrong...");
		}
	}
	public static void logout() {
		System.out.println("Logout Successful..");
	}
}
