package com.example.bank.kata;


import com.example.bank.kata.service.AccountService;
import com.example.bank.kata.service.AccountServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class AccountServiceTest {

	private AccountService accountService;

	@BeforeEach
	public void setUp() {
		accountService = new AccountServiceImpl();
	}

	@Test
	public void testDeposit() {
		accountService.deposit(1000);
		accountService.deposit(2000);
		accountService.withdraw(500);

		String statement = accountService.printStatement();
		assertTrue(statement.contains("1000"));
		assertTrue(statement.contains("2000"));
		assertTrue(statement.contains("-500"));
	}

	@Test
	public void testWithdrawInsufficientBalance() {
		accountService.deposit(200);
		assertThrows(IllegalArgumentException.class, () -> accountService.withdraw(500));
	}

	@Test
	public void testPrintStatementFormat() {
		accountService.deposit(1000);
		accountService.deposit(2000);
		accountService.withdraw(500);

		String statement = accountService.printStatement();
		String expectedOutput = "Date | Amount | Balance\n" +
				LocalDate.now() + " | 1000 | 1000\n" +
				LocalDate.now() + " | 2000 | 3000\n" +
				LocalDate.now() + " | -500 | 2500\n";
		assertEquals(expectedOutput, statement);
	}
}