import java.util.Date;


public abstract class Action {
	protected int amount;
	protected Date datePerformed;
	
	protected abstract boolean execute();
}
