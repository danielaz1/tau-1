package pl.edu.pjatk.tau.bookstore.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Book {

	@Id
	@Column(name="bookId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Setter
	private Long id;

	@Setter private String author;
	@Setter private String title;
	@Setter private String ISBN;

}
