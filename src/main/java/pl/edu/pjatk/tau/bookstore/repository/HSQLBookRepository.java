package pl.edu.pjatk.tau.bookstore.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.edu.pjatk.tau.bookstore.domain.Book;

@RepositoryRestResource(collectionResourceRel = "books", path = "books")
public interface HSQLBookRepository  extends PagingAndSortingRepository<Book, Long> {

}
