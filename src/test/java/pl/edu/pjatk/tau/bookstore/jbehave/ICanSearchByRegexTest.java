package pl.edu.pjatk.tau.bookstore.jbehave;

import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

public class ICanSearchByRegexTest extends BookstoreStory {

	@Override
	public InjectableStepsFactory stepsFactory() {
		return new InstanceStepsFactory(configuration(), new RegexSearchSteps());
	}
}