package pl.edu.pjatk.tau.bookstore.service;

import pl.edu.pjatk.tau.bookstore.domain.BookDAO;

import java.util.List;

public interface BookService {

	Long add(BookDAO book);

	List<BookDAO> getAll();

	BookDAO get(Long id);

	Long update(BookDAO book);

	void delete(Long id);

	void removeAll();

	BookDAO findByPattern(String regex);

	void removeByISBNs(List<String> ISBNs);
}
