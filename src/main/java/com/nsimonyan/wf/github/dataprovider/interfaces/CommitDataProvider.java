package com.nsimonyan.wf.github.dataprovider.interfaces;

import java.util.List;

import com.nsimonyan.wf.github.model.Commit;

public interface CommitDataProvider {
	public List<Commit> listCommits(final String repositoryFullName, final int page) ;
}