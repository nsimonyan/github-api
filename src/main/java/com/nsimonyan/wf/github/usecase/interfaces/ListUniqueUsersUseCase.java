package com.nsimonyan.wf.github.usecase.interfaces;

import java.util.Set;

import com.nsimonyan.wf.github.model.User;

public interface ListUniqueUsersUseCase {

	Set<User> execute(final String repositoryFullName);
}
