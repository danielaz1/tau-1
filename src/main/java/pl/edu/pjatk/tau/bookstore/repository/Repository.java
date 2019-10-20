package pl.edu.pjatk.tau.bookstore.repository;

import pl.edu.pjatk.tau.bookstore.domain.BookDAO;

import java.util.List;

public interface Repository {

	Long add(BookDAO obj);

	List<BookDAO> getAll();

	BookDAO get(Long id);

	Long update(BookDAO obj);

	void delete(Long id);

	void removeAll();
}
