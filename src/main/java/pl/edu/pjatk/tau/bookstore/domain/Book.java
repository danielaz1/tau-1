package pl.edu.pjatk.tau.bookstore.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Book {

	@Setter private Long id = null;
	@Setter private String author;
	@Setter private String title;
	@Setter private String ISBN;

	public Book(String author, String title, String ISBN) {
		this.author = author;
		this.title = title;
		this.ISBN = ISBN;
	}
}
