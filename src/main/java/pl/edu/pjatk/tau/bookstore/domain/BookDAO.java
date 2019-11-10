package pl.edu.pjatk.tau.bookstore.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode(callSuper = false)
@ToString
@Getter
public class BookDAO extends AbstractDAO {

	@Setter private String author;
	@Setter private String title;
	@Setter private String ISBN;

	public BookDAO(String author, String title, String ISBN) {
		this.author = author;
		this.title = title;
		this.ISBN = ISBN;
	}
}
