import java.util.Date;
import java.util.Scanner;


public class GiveAutorization extends CustomerAction {

	private final double COMMISSION = 1.5;
	
	@Override
	protected boolean execute(Account theAccount, boolean isBanker) {
		Scanner theScanner = new Scanner(System.in);
		//saving the action
		this.datePerformed = new Date();
		this.isBanker = isBanker;
		this.commission = COMMISSION;
		theAccount.addToBalance(COMMISSION);
		theAccount.addActionToHistory(this);
				
		//adding authorization
		String newAuth = theScanner.next();
		theAccount.addAuthorized(newAuth);
		theScanner.close();
		return true;
	}

	@Override
	public String toString() {
		String isBankerAction = "ATM";
		if(isBanker)
			isBankerAction = "Banker";
		return "Authorization Action, Performed on " + datePerformed + " by " + isBankerAction + ". " + "Commission: " + commission;
	}



}
