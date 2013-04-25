import java.util.Date;
import java.util.Scanner;


public class WithdrawOrDeposit extends CustomerAction {
	
	private final double COMMISSION = 2;
	
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
	protected boolean execute(Account theAccount, boolean isBanker) {
		Scanner theScanner = new Scanner(System.in);
		double amount = theScanner.nextDouble();
		theScanner.close();
		double balance = theAccount.getBalance() + amount;
		if(balance < 0)
			return false;
		else
		{
			this.datePerformed = new Date();
			this.amount = amount;
			this.isBanker = isBanker;
			this.commission = COMMISSION;
			theAccount.addToBalance(amount-COMMISSION);
			theAccount.addActionToHistory(this);
			return true;
		}
	}



}
