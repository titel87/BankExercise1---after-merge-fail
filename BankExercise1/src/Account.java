
public class Account {
	final int STUDENT_DISCOUNT = 20;
	final int SOLDIER_DISCOUNT = 15;
	final int BUSSINESS_DISCOUNT = 10;
	
	enum AccountType{Soldier, Student, Bussiness};
	
	private int discount;
	private AccountType aType;
	
	public Account(AccountType aType) {
		super();
		this.aType = aType;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount() {
		if(aType != null){
			if( aType == AccountType.Student)
				this.discount = STUDENT_DISCOUNT;
			else if(aType == AccountType.Soldier)
				this.discount = SOLDIER_DISCOUNT;
			else if(aType == AccountType.Bussiness)
				this.discount = BUSSINESS_DISCOUNT;
			else
				this.discount = 0;
			}		
	}

	public AccountType getaType() {
		return aType;
	}

	public void setaType(AccountType aType) {
		this.aType = aType;
	}
	
	

	
}
