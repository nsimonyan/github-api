package com.nsimonyan.wf.github.usecase.interfaces;

import java.util.Map;

public interface UsersImpactUseCase {
	Map<String, Long> execute(final String repositoryFullName) ;
}
