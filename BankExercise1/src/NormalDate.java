import java.util.Calendar;
import java.util.Date;


public class NormalDate extends Date {
	public NormalDate(int day, int month, int year){
		super();
		Calendar c = Calendar.getInstance();
		c.set(year, month-1, day);
		Date temp = c.getTime();
		this.setDate(temp.getDate());
	}

	@Override
	@Deprecated
	public int getMonth() {
		// TODO Auto-generated method stub
		return super.getMonth()+1;
	}

	@Override
	@Deprecated
	public int getYear() {
		// TODO Auto-generated method stub
		return super.getYear() + 1900;
	}

	@Override
	@Deprecated
	public void setMonth(int month) {
		// TODO Auto-generated method stub
		super.setMonth(month-1);
	}

	@Override
	@Deprecated
	public void setYear(int year) {
		// TODO Auto-generated method stub
		super.setYear(year-1900);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getDate() + "/" + getMonth() + "/" + getYear();
	}

}
