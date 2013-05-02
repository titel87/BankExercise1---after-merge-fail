import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class Branch {
	private int Id;
	private Date closingTime;
	private List<Account> accounts;
	
	private void close_system(){
		for(int i=0; i<accounts.size(); i++)
		{
			for(int j=0; j < accounts.get(i).getActionHistory().size(); j++)
			{
				SimpleDateFormat curDate= new SimpleDateFormat();
				curDate= accounts.get(i).getActionHistory().get(j).datePerformed;
				if(curDate.getDay()==new Date().getDay())
				{
					
				}
			}
		}
	}
}
