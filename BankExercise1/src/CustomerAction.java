
public abstract class CustomerAction extends Action {
	
	protected double commission;
	protected boolean isBanker;
	protected Customer theCustomer;
	protected abstract boolean execute(Account theAccount);
	@Override
	public abstract String toString();
	
}
