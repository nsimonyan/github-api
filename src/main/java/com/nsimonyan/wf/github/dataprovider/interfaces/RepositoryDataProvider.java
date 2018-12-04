package com.nsimonyan.wf.github.dataprovider.interfaces;

import java.util.List;

import com.nsimonyan.wf.github.model.Repository;

public interface RepositoryDataProvider {
	List<Repository> searchRepository(final String query, final int page) ;
}
