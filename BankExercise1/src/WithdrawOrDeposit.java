import java.util.Date;
import java.util.Scanner;


public class WithdrawOrDeposit extends CustomerAction {
	
	private final double COMMISSION = 2;
		//===========CONSTRUCTOR??==========================
	
	public WithdrawOrDeposit(double amount, boolean isBanker){
		this.amount= amount;
		this.isBanker = isBanker;
		this.datePerformed = new Date();
		this.commission = COMMISSION;		
	}
	
	@Override
	public String toString() {
		String isBankerAction = "ATM";
		String isDepositString = "Deposit";
		double amountOfAction = amount;
		if(amount < 0)
		{
			amountOfAction*= -1;
			isDepositString = "Withdraw";
		}
		if(isBanker)
			isBankerAction = "Banker";
		return isDepositString + " Action, Performed on " + datePerformed + " by " + isBankerAction + ". " + "Amount: " + amountOfAction + ", Commission: " + commission;  
	}

	@Override
	protected boolean execute(Account theAccount) {
		double balance = theAccount.getBalance() + amount;
		if(balance < 0){
			//write to LOG
			System.out.println("Not enough money!");
			return false;
		}
		else
		{
			System.out.println("Old Balance: " + theAccount.getBalance());
			theAccount.addToBalance(amount-COMMISSION);
			theAccount.addActionToHistory(this);
			//write to log
			System.out.println("New Balance: " + theAccount.getBalance());
			return true;
		}
	}



}
