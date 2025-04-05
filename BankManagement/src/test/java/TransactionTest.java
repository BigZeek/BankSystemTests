import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mycompany.bankmanagement.Transaction;

class TransactionTest {
	
	private Transaction testTransaction = new Transaction(1000);


	@Test
	void testGetOverrawLimit() {
		assertEquals(-1000.00, testTransaction.getOverdrawLimit(), "Incorrect overdraw.");
	}

	@Test
	void testSetOverdrawLimit() {
		// Set new overdraw limit.
		testTransaction.setOverdrawLimit(-200.00);
		assertEquals(-200.00, testTransaction.getOverdrawLimit(), "Unexpected overdraw limit.");		
	}
	
	@Test
	// Test sets a new transaction ID, then tests get function.
	void testGetSetTransactionID() {
		testTransaction.setTransactionID(44);
		assertEquals(44, testTransaction.getTransactionID(), "Unexpected Transaction ID found.");
	}
	

}
