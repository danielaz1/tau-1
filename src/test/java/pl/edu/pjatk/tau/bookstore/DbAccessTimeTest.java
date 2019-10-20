package pl.edu.pjatk.tau.bookstore;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import pl.edu.pjatk.tau.bookstore.domain.BookDAO;
import pl.edu.pjatk.tau.bookstore.service.BookService;
import pl.edu.pjatk.tau.bookstore.service.BookServiceImpl;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class DbAccessTimeTest {

	private static final LocalDateTime FIXED_TIME = LocalDateTime.of(2019,9,26, 23, 0, 0, 0);
	private static final LocalDateTime FIXED_MODIFICATION_TIME = LocalDateTime.of(2019,9,26, 17, 0, 0, 0);
	private static final LocalDateTime FIXED_ACCESS_TIME = LocalDateTime.of(2019,9,26, 15, 0, 0, 0);

	@InjectMocks
	private BookDAO testBook;

	@Mock
	private Clock clock;

	private BookService service = new BookServiceImpl();

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Before
	public void init() {
		testBook = new BookDAO("Jan Kowalski", "Book1", "978-1-4028-9462-6");
	}

	@After
	public void cleanup() {
		service.removeAll();
	}

	@Test
	public void setCreationTime() {
		//Given
		mockTime(FIXED_TIME);

		//When
		Long id = service.add(testBook);

		//Then
		BookDAO bookFromDb = service.get(id);
		Assertions.assertThat(bookFromDb.getCreationTime()).isEqualTo(FIXED_TIME);
	}

	@Test
	public void doNotSetCreationTimeWhenFlagIsOff() {
		//Given
		mockTime(FIXED_TIME);
		testBook.saveCreationTime(false);

		//When
		Long id = service.add(testBook);

		//Then
		BookDAO bookFromDb = service.get(id);
		Assertions.assertThat(bookFromDb.getCreationTime()).isNull();
	}

	@Test
	public void setAccessTime() {
		//Given
		mockTime(FIXED_ACCESS_TIME);
		Long id = service.add(testBook);

		//When
		BookDAO bookFromDb = service.get(id);

		//Then
		Assertions.assertThat(bookFromDb.getAccessTime()).isEqualTo(FIXED_ACCESS_TIME);
	}

	@Test
	public void setAccessTimeWhenFlagIsOff() {
		//Given
		mockTime(FIXED_ACCESS_TIME);
		testBook.saveAccessTime(false);
		Long id = service.add(testBook);

		//When
		BookDAO bookFromDb = service.get(id);

		//Then
		Assertions.assertThat(bookFromDb.getAccessTime()).isNull();
	}

	@Test
	public void setModificationTime() {
		//Given
		mockTime(FIXED_MODIFICATION_TIME);
		Long id = service.add(testBook);

		//When
		BookDAO bookFromDb = service.get(id);
		bookFromDb.setAuthor("New author");
		service.update(bookFromDb);

		//Then
		Assertions.assertThat(service.get(id).getModificationTime()).isEqualTo(FIXED_MODIFICATION_TIME);
	}

	@Test
	public void setModificationTimeWhenFlagIsOff() {
		//Given
		mockTime(FIXED_MODIFICATION_TIME);
		testBook.saveModificationTime(false);
		Long id = service.add(testBook);

		//When
		BookDAO bookFromDb = service.get(id);
		bookFromDb.setAuthor("New author");
		service.update(bookFromDb);

		//Then
		Assertions.assertThat(service.get(id).getModificationTime()).isNull();
	}

	private void mockTime(LocalDateTime fixedTime) {
		Clock fixedClock = Clock.fixed(fixedTime.atZone(ZoneId.systemDefault()).toInstant(), ZoneId.systemDefault());
		doReturn(fixedClock.instant()).when(clock).instant();
		doReturn(fixedClock.getZone()).when(clock).getZone();
	}
}
