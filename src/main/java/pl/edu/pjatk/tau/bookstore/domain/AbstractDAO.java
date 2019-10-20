package pl.edu.pjatk.tau.bookstore.domain;

import java.time.Clock;
import java.time.LocalDateTime;

public abstract class AbstractDAO {

	private Clock clock = Clock.systemDefaultZone();
	private Long id;

	private LocalDateTime accessTime;
	private LocalDateTime creationTime;
	private LocalDateTime modificationTime;
	private boolean saveCreationTime = true;
	private boolean saveAccessTime = true;
	private boolean saveModificationTime = true;

	public Long getId() {
		return id;
	}

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

	public LocalDateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime() {
		if (saveCreationTime) {
			this.creationTime = LocalDateTime.now(clock);
		}
	}

	public LocalDateTime getModificationTime() {
		return modificationTime;
	}

	public void setModificationTime() {
		if (saveModificationTime) {
			this.modificationTime = LocalDateTime.now(clock);
		}
	}

	public void saveCreationTime(boolean flag) {
		this.saveCreationTime = false;
	}

	public void saveAccessTime(boolean b) {
		this.saveAccessTime = false;
	}

	public void saveModificationTime(boolean b) {
		this.saveModificationTime = false;
	}
}
