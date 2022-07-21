package farheen.foundation.bank.entities;

public class FundTransferEntity {

	private int fromAccount;
	private int toAccount;
	private double amount;
	public FundTransferEntity()
	{
		
	}
	
	public FundTransferEntity(int fromAccount, int toAccount, double amount) {
		this.fromAccount=fromAccount;
		this.toAccount=toAccount;
		this.amount=amount;
		
	}

	public int getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(int fromAccount) {
		this.fromAccount = fromAccount;
	}

	public int getToAccount() {
		return toAccount;
	}

	public void setToAccount(int toAccount) {
		this.toAccount = toAccount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "FundTransferEntity [fromAccount=" + fromAccount + ", toAccount=" + toAccount + ", amount=" + amount
				+ "]";
	}
	
	
	
}
