package com.nsimonyan.wf.github.usecase.interfaces;

import java.util.List;

import com.nsimonyan.wf.github.model.Repository;

public interface SearchRepositoriesUseCase {
	List<Repository> execute(final String query, final int page) ;
}
