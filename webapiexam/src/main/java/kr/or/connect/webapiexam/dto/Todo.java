package kr.or.connect.webapiexam.dto;

import java.time.LocalDateTime;

public class Todo {
	private String title;
	private LocalDateTime createdAt;
	
	public Todo(String title) {
		this.title = title;
		this.createdAt = LocalDateTime.now();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}	
}
