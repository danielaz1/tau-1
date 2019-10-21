package pl.edu.pjatk.tau.bookstore.service;

import pl.edu.pjatk.tau.bookstore.domain.AbstractDAO;
import pl.edu.pjatk.tau.bookstore.domain.BookDAO;
import pl.edu.pjatk.tau.bookstore.repository.InMemoryBookRepository;
import pl.edu.pjatk.tau.bookstore.repository.Repository;

import java.util.List;
import java.util.NoSuchElementException;

public class BookServiceImpl implements BookService {

	private Repository repository = new InMemoryBookRepository();

	public Long add(BookDAO book) {
		book.setCreationTime();
		return repository.add(book);
	}

	public List<BookDAO> getAll() {
		List<BookDAO> books = repository.getAll();
		books.forEach(AbstractDAO::setAccessTime);
		books.forEach(b -> repository.update(b));
		return books;
	}

	public BookDAO get(Long id) throws NoSuchElementException {
		BookDAO book = repository.get(id);
		updateAccessTime(book);
		return book;
	}

	public Long update(BookDAO toUpdate) {
		toUpdate.setModificationTime();
		return repository.update(toUpdate);
	}

	public void delete(Long id) {
		repository.delete(id);
	}

	public void removeAll() {
		repository.removeAll();
	}

	private void updateAccessTime(BookDAO book) {
		book.setAccessTime();
		repository.update(book);
	}
}
