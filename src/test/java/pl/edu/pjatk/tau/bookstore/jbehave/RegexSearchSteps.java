package pl.edu.pjatk.tau.bookstore.jbehave;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RegexSearchSteps extends BookstoreSteps {

	@Given("the books in store: $booksTable")
	public void theBooks(ExamplesTable booksTable) {
		this.booksTable = booksTable;
		addBooks(booksTable);
	}

	@When("I search by pattern <regex>")
	public void thePatternIs(@Named("regex") String regex) {
		result = service.findByPattern(regex).toString();
	}

	@Then("the result is <book>")
	public void theResultIs(@Named("book") String expectedBook) {
		assertThat(result, equalTo(expectedBook));
	}

}
