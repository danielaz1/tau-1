package pl.edu.pjatk.tau.bookstore.jbehave;

import org.jbehave.core.model.ExamplesTable;
import pl.edu.pjatk.tau.bookstore.domain.BookDAO;
import pl.edu.pjatk.tau.bookstore.service.BookService;
import pl.edu.pjatk.tau.bookstore.service.BookServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class BookstoreSteps {

	ExamplesTable booksTable;
	BookService service = new BookServiceImpl();
	String result;

	List<BookDAO> addBooks(ExamplesTable table) {
		List<BookDAO> books = examplesToBookList(table);
		books.forEach(b -> service.add(b));
		return books;
	}

	List<BookDAO> examplesToBookList(ExamplesTable table) {
		List<BookDAO> books = new ArrayList<>();
		for (Map<String,String> row : table.getRows()) {
			String author = row.get("author");
			String title = row.get("title");
			String isbn = row.get("ISBN");
			BookDAO book = new BookDAO(author, title, isbn);
			books.add(book);
		}
		return books;
	}

}
