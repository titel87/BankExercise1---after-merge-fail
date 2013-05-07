import java.text.SimpleDateFormat;
import java.util.Date;


public abstract class Action {
	protected double amount;
	protected Date datePerformed;
	protected Account theAccount;
	protected abstract boolean execute(Account theAccount);
}
