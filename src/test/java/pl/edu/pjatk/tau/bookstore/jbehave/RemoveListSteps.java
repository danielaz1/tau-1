package pl.edu.pjatk.tau.bookstore.jbehave;

import org.assertj.core.api.Assertions;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import pl.edu.pjatk.tau.bookstore.domain.BookDAO;

import java.util.List;

public class RemoveListSteps extends BookstoreSteps {

	@Given("the books in store $booksTable")
	public void theBooks(ExamplesTable booksTable) {
		addBooks(booksTable);
	}

	@When("I remove a list of $ISBNs")
	public void theListIs(List<String> ISBNs) {
		service.removeByISBNs(ISBNs);
	}

	@Then("the books in store are $booksTable")
	public void theResultIs(ExamplesTable booksTable) {
		List<BookDAO> expected = examplesToBookList(booksTable);

		Assertions.assertThat(service.getAll())
				.hasSize(expected.size())
				.containsExactlyInAnyOrderElementsOf(expected);

	}
}
