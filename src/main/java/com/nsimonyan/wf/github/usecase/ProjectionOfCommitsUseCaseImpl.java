package com.nsimonyan.wf.github.usecase;

import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.nsimonyan.wf.github.dataprovider.interfaces.CommitDataProvider;
import com.nsimonyan.wf.github.usecase.interfaces.ProjectionOfCommitsUseCase;

/**
 * 
 * @author naira.simonyan
 *
 */
public class ProjectionOfCommitsUseCaseImpl implements ProjectionOfCommitsUseCase {

	@Autowired
	CommitDataProvider commitDataProvider;

	@Override
	public Map<Object, Long> execute(final String repositoryFullName)  {
		return commitDataProvider.listCommits(repositoryFullName, 1).stream().map(commit -> commit.getDate())
				.collect(Collectors.groupingBy(date -> date, Collectors.counting()));
	}
}
