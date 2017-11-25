package Entity;

import java.time.LocalDate;

public class AccountEntryImp implements AccountEntry {
	
	private LocalDate date;
	private Double amount;
	private String fromAccountNumber;
	private String fromPersonName;

	public AccountEntryImp(Double amount, String fromAccountNumber, String fromPersonName) {
		this.date = LocalDate.now();
		this.amount = amount;
		this.fromAccountNumber = fromAccountNumber;
		this.fromPersonName = fromPersonName;
	}

	@Override
	public LocalDate getDate() {
		return date;
	}

	@Override
	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public Double getAmount() {
		return amount;
	}

	@Override
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	

	@Override
	public String getFromAccountNumber() {
		return fromAccountNumber;
	}

	@Override
	public void setFromAccountNumber(String fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}

	@Override
	public String getFromPersonName() {
		return fromPersonName;
	}

	@Override
	public void setFromPersonName(String fromPersonName) {
		this.fromPersonName = fromPersonName;
	}
}
