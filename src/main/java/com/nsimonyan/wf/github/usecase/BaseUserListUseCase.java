package com.nsimonyan.wf.github.usecase;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.nsimonyan.wf.github.dataprovider.interfaces.CommitDataProvider;
import com.nsimonyan.wf.github.model.User;

class BaseUserListUseCase {

	@Autowired
	CommitDataProvider commitDataProvider;

	 protected List<User> listUsers(final String repositoryFullName, final int page)  {
		return commitDataProvider.listCommits(repositoryFullName, page).stream()
				.map(commit -> commit.getUser())
				.collect(Collectors.toList());
	}

}