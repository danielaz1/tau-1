package pl.edu.pjatk.tau.bookstore.service;

import pl.edu.pjatk.tau.bookstore.domain.Book;

import java.util.List;

public interface BookService {

	Long add(Book book);

	List<Book> getAll();

	Book get(Long id);

	Long update(Book book);

	void delete(Long id);

	void removeAll();
}
