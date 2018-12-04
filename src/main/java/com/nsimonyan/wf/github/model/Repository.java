package com.nsimonyan.wf.github.model;

public class Repository {
	private final Integer id;
	private final String fullName;
	private final String description;

	public Repository(final Integer id, final String fullName, final String description) {
		this.id = id;
		this.fullName = fullName;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public String getFullName() {
		return fullName;
	}

	public String getDescription() {
		return description;
	}
}
