package Entity;

import java.time.LocalDate;
import java.util.List;
/**
 * @since: oct-8-2017
 * This class implements a customer who uses a bank system
 * @author mulugeta and yaried 
 * @version 1.0
 *
 */


public interface Customer {
	
	
	/**
	 * This returns the current address of the customer
	 * @return this customer's address
	 */

	Address getAddress();
	void setAddress(Address address);
	
	String getName();
	void setName(String name);
	String getEmail();
	void setEmail(String email);
	LocalDate getBirthDate();
	void setBirthDate(LocalDate birthDate);
	String getSsn();
	void setSsn(String ssn);
	
	List<Account> getAccount();
	void setAccount(List<Account> account);
	
	

}
