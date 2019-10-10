package pl.edu.pjatk.tau.bookstore.service;

import pl.edu.pjatk.tau.bookstore.domain.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class BookServiceImpl implements BookService {

	private static Long idCounter = 0L;

	private static List<Book> db = new ArrayList<>();

	public Long add(Book book) {
		if (bookExistsInDb(book)) {
			throw new IllegalArgumentException("Book already exists");
		}
		book.setId(createID());
		db.add(book);
		return book.getId();
	}

	private boolean bookExistsInDb(Book book) {
		return findById(book.getId()).isPresent();
	}

	private Optional<Book> findById(Long id) {
		return db.stream()
				.filter(b -> b.getId().equals(id))
				.findFirst();
	}

	public List<Book> getAll() {

		return db;
	}

	public Book get(Long id) throws NoSuchElementException {

		Optional<Book> book = findById(id);

		if (book.isPresent()) {
			return book.get();
		} else {
			throw new NoSuchElementException();
		}
	}

	public Long update(Book toUpdate) {

		Optional<Book> book = findById(toUpdate.getId());

		if (book.isPresent()) {
			Book updated = book.get();
			updated.setAuthor(toUpdate.getAuthor());
			updated.setTitle(toUpdate.getTitle());
			updated.setISBN(toUpdate.getISBN());
			return updated.getId();
		} else {
			throw new NoSuchElementException();
		}
	}

	public void delete(Long id) {
		Book book = get(id);
		db.remove(book);
	}

	private Long createID() {
		return idCounter++;
	}

	public void removeAll() {
		db = new ArrayList<>();
	}
}
