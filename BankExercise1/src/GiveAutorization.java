import java.util.Date;
import java.util.Scanner;


public class GiveAutorization extends CustomerAction {

	private final double COMMISSION = 1.5;
	private String Name;
	
	public GiveAutorization(String name, boolean isBanker){
		this.Name= name;
		this.datePerformed = new Date();
		this.isBanker = isBanker;
		this.commission = COMMISSION;
	}
	
	@Override
	protected boolean execute() {
		//saving the action
		theAccount.addToBalance(COMMISSION);
		theAccount.addActionToHistory(this);
				
		//adding authorization
		theAccount.addAuthorized(Name);
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
