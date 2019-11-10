package pl.edu.pjatk.tau.bookstore.repository;

import pl.edu.pjatk.tau.bookstore.domain.BookDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.regex.Pattern;

public class InMemoryBookRepository implements Repository {

	private static Long idCounter = 0L;

	private static List<BookDAO> db = new ArrayList<>();

	public Long add(BookDAO book) {
		if (bookExistsInDb(book)) {
			throw new IllegalArgumentException("BookDAO already exists");
		}

		book.setId(createID());
		db.add(book);
		return book.getId();
	}

	private boolean bookExistsInDb(BookDAO book) {
		return findById(book.getId()).isPresent();
	}

	private Optional<BookDAO> findById(Long id) {
		return db.stream()
				.filter(b -> b.getId().equals(id))
				.findFirst();
	}

	public List<BookDAO> getAll() {

		return db;
	}

	public BookDAO get(Long id) throws NoSuchElementException {

		return findById(id).orElseThrow(NoSuchElementException::new);
	}

	public Long update(BookDAO toUpdate) {

		Optional<BookDAO> book = findById(toUpdate.getId());

		if (book.isPresent()) {
			BookDAO updated = book.get();
			updated.setAuthor(toUpdate.getAuthor());
			updated.setTitle(toUpdate.getTitle());
			updated.setISBN(toUpdate.getISBN());
			return updated.getId();
		} else {
			throw new NoSuchElementException();
		}
	}

	public void delete(Long id) {
		BookDAO book = get(id);
		db.remove(book);
	}

	private Long createID() {
		return idCounter++;
	}

	public void removeAll() {
		db = new ArrayList<>();
	}

	public BookDAO findByPattern(String regex) {

		Pattern pattern = Pattern.compile(regex);

		return getAll().stream()
				.filter(b -> pattern.matcher(b.getTitle()).find())
				.findFirst().orElseThrow(NoSuchElementException::new);
	}

	public BookDAO findByISBN(String ISBN) {
		return db.stream()
				.filter(b -> b.getISBN().equals(ISBN))
				.findFirst().orElseThrow(NoSuchElementException::new);
	}
}
