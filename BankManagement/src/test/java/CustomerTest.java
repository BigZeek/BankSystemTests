import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mycompany.bankmanagement.Customer;
class CustomerTest {

	private Customer testCustomer = new Customer();

	@Test
	void testToString() {
		// Test expects default customer 
		assertEquals("Customer ID: 0 Address: 253 Everywhere Road Phone Number: 867-5309",
					testCustomer.toString(), "String does not match default format.");
	}

}
