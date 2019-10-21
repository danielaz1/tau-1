package pl.edu.pjatk.tau.bookstore.domain;

import lombok.Getter;

import java.time.Clock;
import java.time.LocalDateTime;

@Getter
public abstract class AbstractDAO {

	private Clock clock = Clock.systemDefaultZone();
	private Long id;

	private LocalDateTime accessTime;
	private LocalDateTime creationTime;
	private LocalDateTime modificationTime;
	private boolean saveCreationTime = true;
	private boolean saveAccessTime = true;
	private boolean saveModificationTime = true;

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getAccessTime() {
		return accessTime;
	}

	public void setAccessTime() {
		if (saveAccessTime) {
			this.accessTime = LocalDateTime.now(clock);
		}
	}

	public void setCreationTime() {
		if (saveCreationTime) {
			this.creationTime = LocalDateTime.now(clock);
		}
	}

	public void setModificationTime() {
		if (saveModificationTime) {
			this.modificationTime = LocalDateTime.now(clock);
		}
	}

	public void saveCreationTime(boolean flag) {
		this.saveCreationTime = flag;
	}

	public void saveAccessTime(boolean flag) {
		this.saveAccessTime = flag;
	}

	public void saveModificationTime(boolean flag) {
		this.saveModificationTime = flag;
	}
}
