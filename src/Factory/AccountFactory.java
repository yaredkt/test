package Factory;

import Entity.Account;
import Entity.CheckingAccount;
import Entity.SavingAccount;

public abstract class AccountFactory {
	public static Account createAccount(AccountType accountType) {

		if (accountType == AccountType.CHECKING) {

			return new CheckingAccount();
		} else if (accountType == AccountType.SAVING) {

			return new SavingAccount();
		} else if (accountType == AccountType.CREDIT) {

			return new SavingAccount();
		} else {

			return null;
		}
	}
}
