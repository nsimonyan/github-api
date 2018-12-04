package com.nsimonyan.wf.github.usecase.interfaces;

import java.util.Map;

public interface ProjectionOfCommitsUseCase {
	Map<Object,Long> execute(final String repositoryFullName) ;
}
