package se.yrgo.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BookTest {

	//G
	@Test
	public void test2EqualBooks() {
		Book book1 = new Book(1, "a", "b", "", "", 100);
		Book book2 = new Book(1, "c", "z", "", "", 100);
		assertTrue(book1.equals(book2)); //only equals on id
	}

	//G
	@Test
	public void test2NonEqualBooks() {
		Book book1 = new Book(1, "a", "b", "", "", 100);
		Book book2 = new Book(2, "a", "b", "", "", 100);
		assertFalse(book1.equals(book2)); //only equals on id
	}

}
