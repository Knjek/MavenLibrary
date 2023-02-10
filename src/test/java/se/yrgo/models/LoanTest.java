package se.yrgo.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import utilities.GenderType;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

public class LoanTest {

	Loan loan;
	public LoanTest() {
		Customer c = new Customer("", "a", "b", "", "", "@",
				1, GenderType.MALE);
		Book book = new Book(1, "abc", "", "", "", 10);
		loan = new Loan(1, c, book);
	}
	//VG
	@Test
	public void testDueDate() {
		assertTrue(LocalDate.class.equals(loan.getDueDate().getClass()));
		assertFalse(LocalDate.now().equals(loan.getDueDate()));
		LocalDate date = LocalDate.now().plusDays(14);
		assertTrue(date.equals(loan.getDueDate()));
   }
}