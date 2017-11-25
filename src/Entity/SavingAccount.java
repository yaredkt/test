package Entity;

public class SavingAccount extends AccountImp {

	@Override
	public void deposit(Double amount) {
		// TODO Auto-generated method stub
		setBalance(getBalance() + amount);

		
		

	}

	@Override
	public void withdraw(Double amount) {
		setBalance(getBalance() - amount);

		AccountEntryImp newAccountEntry = new AccountEntryImp(amount, getAccountNumber(), getCustomer().getName());
		getAccountEntries().add(newAccountEntry);

	}

}
