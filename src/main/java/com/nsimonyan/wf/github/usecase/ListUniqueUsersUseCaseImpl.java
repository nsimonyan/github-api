package com.nsimonyan.wf.github.usecase;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import com.nsimonyan.wf.github.model.User;
import com.nsimonyan.wf.github.usecase.interfaces.ListUniqueUsersUseCase;

public class ListUniqueUsersUseCaseImpl extends BaseUserListUseCase implements ListUniqueUsersUseCase {
	@Override
	public Set<User> execute(final String repositoryFullName)  {
		return listUsers(repositoryFullName, 0).stream()
				.collect(Collectors.toCollection(() -> new TreeSet<User>(Comparator.comparing(User::getEmail))));
	}
}