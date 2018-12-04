package com.nsimonyan.wf.github.usecase;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.nsimonyan.wf.github.dataprovider.interfaces.CommitDataProvider;
import com.nsimonyan.wf.github.model.Commit;
import com.nsimonyan.wf.github.model.User;
import com.nsimonyan.wf.github.usecase.interfaces.ProjectionOfCommitsUseCase;

/**
 * 
 * @author naira.simonyan
 *
 */
public class ProjectionOfCommitsUseCaseImplTest {

	@InjectMocks
	ProjectionOfCommitsUseCase projectionOfCommitsUseCase = new ProjectionOfCommitsUseCaseImpl();

	@Mock
	CommitDataProvider commitDataProvider;

	private List<Commit> commits;

	private Map<Object, Long> result;

	LocalDate today = LocalDate.now();
	LocalDate yesterday = today.minusDays(1);
	LocalDate fiveDaysBefore = today.minusDays(5);

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Before
	public void initListOfCommits() {
		commits = new ArrayList<>();
		Commit commit1 = new Commit("Hello this is test commit 1", today, new User("test1", "test1_github.com", today));
		Commit commit2 = new Commit("Hello this is test commit 2", yesterday,
				new User("test2", "test2_github.com", yesterday));
		Commit commit3 = new Commit("Hello this is test commit 3", yesterday,
				new User("test3", "test3_github.com", yesterday));
		Commit commit4 = new Commit("Hello this is test commit 4", fiveDaysBefore,
				new User("test4", "test4_github.com", fiveDaysBefore));
		Commit commit5 = new Commit("Hello this is test commit 5", fiveDaysBefore,
				new User("test5", "test5_github.com", fiveDaysBefore));
		Commit commit6 = new Commit("Hello this is test commit 6", fiveDaysBefore,
				new User("test6", "test6_github.com", fiveDaysBefore));
		Commit commit7 = new Commit("Hello this is test commit 7", fiveDaysBefore,
				new User("test7", "test7_github.com", fiveDaysBefore));
		commits.add(commit1);
		commits.add(commit2);
		commits.add(commit3);
		commits.add(commit4);
		commits.add(commit5);
		commits.add(commit6);
		commits.add(commit7);
	}

	@Before
	public void initResult() {
		result = new HashMap<>();

		result.put(today, 1L);
		result.put(yesterday, 2L);
		result.put(fiveDaysBefore, 4L);
	}

	@Test
	public void testProjectionOfCommits_There_Is_Result() {
		givenThereIsResult();
		assertThat(projectionOfCommitsUseCase.execute("TEST"), is(result));
	}

	private void givenThereIsResult() {
		when(commitDataProvider.listCommits("TEST", 1)).thenReturn(commits);
	}
}
