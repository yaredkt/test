package Entity;

import java.time.LocalDate;
import java.util.List;

public class CustomerImp implements Customer {
	
	private String name;
	private String email;
	private LocalDate birthDate;
	private String ssn;
	private Address address;
	private List<Account> account;

	@Override
	public Address getAddress() {

		return address;
	}

	@Override
	public void setAddress(Address address) {
		this.address = address;

	}

	@Override
	public String getName() {

		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;

	}

	@Override
	public String getEmail() {

		return email;
	}

	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public LocalDate getBirthDate() {
		return birthDate;
	}

	@Override
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;

	}

	@Override
	public String getSsn() {

		return ssn;
	}

	@Override
	public void setSsn(String ssn) {
		this.ssn = ssn;

	}

	@Override
	public List<Account> getAccount() {
		return account;
	}

	@Override
	public void setAccount(List<Account> account) {
		this.account = account;
	}

}