package se.yrgo.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BookCatalogTest {

	private BookCatalog bc;
	private Book book1;

	public BookCatalogTest() {
		bc = new BookCatalog();
		Book book1 = new Book(1,"Learning Java","","","",0);
		bc.addBook(book1);
	}

	//G
	@Test
	public void testAddABook() {
		int before = bc.getNumberOfBooks();
		Book book2 = new Book(2, "Learning a lot", "", " ", "", 100);
		bc.addBook(book2);
		int after = bc.getNumberOfBooks();
		assertNotSame(before, after);
		assertTrue(bc.getNumberOfBooks() == 2);
	}

	//G
	@Test
	public void testFindBook() {
		try {
			assertEquals(bc.getBookArray()[0], bc.findBook("Learning Java"));
			assertTrue((bc.getBookArray()[0].getTitle()).equals(bc.findBook(" Learning Java ").getTitle()));
		} catch (BookNotFoundException ex) {
			fail("findBook should not throw exception here.");
		}
	}

	//G
	@Test
	public void testFindBookIgnoringCase() {
		try {
			assertEquals(bc.getBookArray()[0], bc.findBook(" leaRning jaVa "));
		} catch (BookNotFoundException ex) {
			fail("findBook should not throw exception here.");
		}
	}

	//G
	@Test
	public void testFindBookWithExtraSpaces() {
		try {
			assertEquals(bc.getBookArray()[0], bc.findBook(" Learning Java  "));
		} catch (BookNotFoundException ex) {
			fail("findBook should not throw exception here.");
		}
	}

	//VG
	// This test should throw BookNotFoundException in order to pass.
	@Test
	public void testFindBookThatDoesntExist() throws BookNotFoundException {
		assertThrows(BookNotFoundException.class, () -> bc.findBook("Does not exist"));
	}

}
