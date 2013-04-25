import java.util.Date;


public class GetInfoPage extends CustomerAction {

	private final double COMMISSION = 1.5;
	
	@Override
	protected boolean execute(Account theAccount, boolean isBanker) {
		
		//saving the action
		this.datePerformed = new Date();
		this.isBanker = isBanker;
		this.commission = COMMISSION;
		theAccount.addToBalance(COMMISSION);
		theAccount.addActionToHistory(this);
				
		//printing info page
		System.out.println("Actions performed until " + this.datePerformed.toString() + ":");
		System.out.println("____________________________________________");
		if(theAccount.getActionHistory().size() == 0)
			System.out.println("No Actions In Account!");
		else
		{
			for(int i=0; i<theAccount.getActionHistory().size(); i++)
			{
				System.out.println(i+1 +") " + theAccount.getActionHistory().get(i).toString());
			}
		}
		return true;
	}

	@Override
	public String toString() {
		String isBankerAction = "ATM";
		if(isBanker)
			isBankerAction = "Banker";
		return "Information Page Action, Performed on " + datePerformed + " by " + isBankerAction + ". " + "Commission: " + commission;  
	}



}
