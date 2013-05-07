import java.util.Date;
import java.util.Scanner;


public class ChargeOrCreditCustomer extends Action {

	@Override
	protected boolean execute(Account theAccount) {
		Scanner theScanner = new Scanner(System.in);
		amount= theScanner.nextDouble();
		theScanner.close();
		datePerformed = new Date();
		theAccount.addToBalance(amount);
		return false;
	}

}
