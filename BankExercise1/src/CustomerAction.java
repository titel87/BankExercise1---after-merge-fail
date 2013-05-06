
public abstract class CustomerAction extends Action {
	
	protected double commission;
	protected boolean isBanker;
	protected Customer theCustomer;
	protected abstract boolean execute();
	@Override
	public abstract String toString();
	
}
