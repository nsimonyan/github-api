package com.nsimonyan.wf.github.model;

import java.time.LocalDate;

public class Commit {
	private final String message;
	private final LocalDate date;
	private final User user;

	public Commit(final String message, final LocalDate date, final User user) {
		this.message = message;
		this.date = date;
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public LocalDate getDate() {
		return date;
	}

	public User getUser() {
		return user;
	}

}
