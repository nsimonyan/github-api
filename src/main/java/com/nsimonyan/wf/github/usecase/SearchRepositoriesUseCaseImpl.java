package com.nsimonyan.wf.github.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nsimonyan.wf.github.dataprovider.interfaces.RepositoryDataProvider;
import com.nsimonyan.wf.github.model.Repository;
import com.nsimonyan.wf.github.usecase.interfaces.SearchRepositoriesUseCase;

public class SearchRepositoriesUseCaseImpl implements SearchRepositoriesUseCase {

	@Autowired
	RepositoryDataProvider repositoryDataProvider;

	@Override
	public List<Repository> execute(String query, int page)  {
		return repositoryDataProvider.searchRepository(query, page);
	}

}
