import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mycompany.bankmanagement.Account;

class AccountTest {

	private Account testAccount = new Account(1000, "5051");


	@Test
	void testGetBalance() {
		assertEquals(1000, testAccount.getBalance(), "Unexpected balance found.");
	}

	@Test
	void testSetBalance() {
		testAccount.setBalance(999.99); // Set new balance as type double.
		
		assertEquals(999.99, testAccount.getBalance(), "Set amount incorrect.");
	}
	
	@Test
	void testGetAccountNumber() {
		assertEquals("5051", testAccount.getAccountNumber(), "Unexpected account number.");
	}
	
	@Test
	void testSetAccountNumber() {
		testAccount.setAccountNumber("369A"); // Set new account number.
		
		assertEquals("369A", testAccount.getAccountNumber(), "Unexpected account number found.");
	}
}

