package pl.edu.pjatk.tau.bookstore;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pl.edu.pjatk.tau.bookstore.domain.Book;
import pl.edu.pjatk.tau.bookstore.service.BookService;
import pl.edu.pjatk.tau.bookstore.service.BookServiceImpl;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class BookServiceTest {

	private BookService service;
	private Book testBook1;
	private Book testBook2;

	@Test
	public void canAddBook() {
		service.add(testBook1);
		assertThat(testBook1.getId()).isNotNull();
	}

	@Test
	public void addBookWithExistingId() {

		service.add(testBook1);
		testBook2.setId(testBook1.getId());

		assertThatExceptionOfType(IllegalArgumentException.class)
				.isThrownBy( () -> service.add(testBook2) );
	}

	@Test
	public void canAddTwoBooks() {
		Long id1 = service.add(testBook1);
		Long id2 = service.add(testBook2);

		assertThat(id1).isNotEqualTo(id2);
	}

	@Test
	public void canGetBookById() {
		Long id1 = service.add(testBook1);

		Book bookFromDb = service.get(id1);

		assertThat(bookFromDb)
				.isNotNull()
				.hasNoNullFieldsOrProperties();
	}

	@Test
	public void getBookByIdAndThrowExceptionIfNotPresent() {
		Long id = 1L;

		assertThatExceptionOfType(NoSuchElementException.class)
				.isThrownBy( () -> service.get(id) );
	}

	@Test
	public void getAll() {
		service.add(testBook1);
		service.add(testBook2);

		assertThat(service.getAll())
				.isNotNull()
				.isNotEmpty()
				.hasSize(2);
	}

	@Test
	public void getAllWhenEmpty() {
		assertThat(service.getAll())
				.isNotNull()
				.isEmpty();
	}

	@Test
	public void updateWhenNotPresent() {
		assertThatExceptionOfType(NoSuchElementException.class)
				.isThrownBy( () -> service.update(testBook1) );
	}

	@Test
	public void update() {
		Long id = service.add(testBook1);
		Book updated = new Book("New Author", testBook1.getTitle(), testBook1.getISBN());
		updated.setId(id);
		service.update(updated);

		assertThat(service.get(id))
				.isNotNull()
				.hasNoNullFieldsOrProperties();

		assertThat(service.get(id).getAuthor()).isEqualTo("New Author");
	}

	@Test
	public void deleteWhenNotPresent() {
		assertThatExceptionOfType(NoSuchElementException.class)
				.isThrownBy( () -> service.delete(1L) );
	}

	@Test
	public void delete() {

		Long id1 = service.add(testBook1);
		Long id2 = service.add(testBook2);

		service.delete(id1);

		assertThatExceptionOfType(NoSuchElementException.class)
				.isThrownBy( () -> service.get(id1) );

		assertThat(service.get(id2)).isNotNull();
		assertThat(service.getAll()).hasSize(1);
	}


	@Before
	public void init() {
		service = new BookServiceImpl();
		testBook1 = new Book("Jan Kowalski", "Book1", "978-1-4028-9462-6");
		testBook2 = new Book("Jan Lisowski", "Book2", "978-1-4028-9462-4");
	}

	@After
	public void cleanup() {
		service.removeAll();
	}

}
