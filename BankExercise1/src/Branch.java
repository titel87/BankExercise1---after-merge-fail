import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class Branch {
	private int Id;
	private Date closingTime;
	private List<Account> accounts;
	SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	@SuppressWarnings("deprecation")
	private void close_system(){
		for(int i=0; i<accounts.size(); i++)
		{
			Account curAccount = accounts.get(i);
			for(int j=0; j < curAccount.getActionHistory().size(); j++)
			{
				CustomerAction curAction = curAccount.getActionHistory().get(j);
				Date curDate= curAction.datePerformed;
				if(curDate.getDay()==new Date().getDay())
				{
					
				}
			}
		}
	}
}
