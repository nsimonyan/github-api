package com.nsimonyan.wf.github.usecase;

import java.util.Map;
import java.util.stream.Collectors;

import com.nsimonyan.wf.github.usecase.interfaces.UsersImpactUseCase;

public class UserImpactUseCaseImpl extends BaseUserListUseCase implements UsersImpactUseCase {


	@Override
	public Map<String, Long> execute(final String repositoryFullName)  {
		return listUsers(repositoryFullName, 1).stream().map(user -> user.getEmail())
				.collect(Collectors.groupingBy(email -> email, Collectors.counting()));
	}

}