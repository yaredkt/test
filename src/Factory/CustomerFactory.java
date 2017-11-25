package Factory;

import Entity.Business;
import Entity.CustomerImp;
import Entity.Personal;

public class CustomerFactory {
	
	public static CustomerImp createCustomer(CustomerType accountType) {
		if (accountType == CustomerType.BUSINESS) {
			return new Business();
		} else if (accountType == CustomerType.PERSONAL) {
			return new Personal();
		} else {
			return null;
		}
	}

}
