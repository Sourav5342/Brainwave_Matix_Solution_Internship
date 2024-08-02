import java.util.*;
public class AtmInterface {
	static double balance = 1000.0;	
	//Show deposit amount//	
	public  void checkBalance() {
		System.out.println("Your Balance is           :" +balance);	
}
	//Withdraw//
	public void withdraw(double amount) {
	    if (amount > balance) {
	        System.out.println("Insufficient balance.");
	    } else {
	        balance -= amount;
	        System.out.println("You withdrew amount :" + amount);
	        System.out.println("Your new balance is : " + balance);
	    }
	}
	//Deposit//
	public void deposit(double amount) {
		balance +=amount;
		System.out.println("Your deposit amount :" +amount);
		System.out.println("Your new balance is : " + balance);
	}
	//Invalid Input// 
	public void Invalid() {
	}
	public static void main(String[] args) {
		AtmInterface atm = new AtmInterface();
		Scanner sc=new Scanner(System.in);
		//Show ATM Menu//
		int choice;
		System.out.println("ATM Menu");
		while (true) {
			System.out.println("1.Check Balance    ");
			System.out.println("2.Withdrawal Money ");
			System.out.println("3.Deposit Money    ");
			System.out.println("4.Exit             ");
			System.out.println("Enter Your Choice :");
			choice=sc.nextInt();			
			switch(choice) {
			case 1:
				atm.checkBalance();
				break;
			case 2:
				System.out.println("Your Withdrawal Money is  :");
				double withdrawAmount = sc.nextDouble();
                atm.withdraw(withdrawAmount);
				break;
			case 3:
				System.out.println("Enter Your Deposit Amount :");
				double depositAmount=sc.nextDouble();
				atm.deposit(depositAmount);
				break;
			case 4:
				System.out.println("Exit                      :");
				break;
			default:
				System.out.println("Sorry invalid input please enter valid input");
				atm.Invalid();
				break;
			
			}
		}
	}
}
