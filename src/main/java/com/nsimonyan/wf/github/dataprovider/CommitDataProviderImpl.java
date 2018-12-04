package com.nsimonyan.wf.github.dataprovider;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.nsimonyan.wf.github.commons.date.DateUtility;
import com.nsimonyan.wf.github.commons.json.Json;
import com.nsimonyan.wf.github.dataprovider.interfaces.CommitDataProvider;
import com.nsimonyan.wf.github.model.Commit;
import com.nsimonyan.wf.github.model.User;

public class CommitDataProviderImpl implements CommitDataProvider {

	@Override
	public List<Commit> listCommits(final String repositoryFullName, final int page) {
		return toCommitsList(Json.parseArray(listCommitsfromApi(repositoryFullName, page)));
	}

	private String listCommitsfromApi(final String repoFullName, final int page) {
		return GitHubRequestSender.send(new StringBuilder("repos/").append(repoFullName)
				.append("/commits" + (page == 0 ? "" : "?per_page=100&page=" + page)).toString());

	}

	@SuppressWarnings("unchecked")
	/**
	 * parsing json array to list of Commit objects
	 * 
	 * @param items
	 * @return
	 */
	private List<Commit> toCommitsList(final JSONArray items) {
		return (List<Commit>) items.stream().map(item -> {
			final JSONObject committer = Json.parse(Json.parse(Json.parse(item).get("commit")).get("committer"));
			final LocalDate date = DateUtility.toDate(Json.getString(committer, "date"));
			return new Commit(Json.getString(committer, "message"), date,
					new User(Json.getString(committer, "name"), Json.getString(committer, "email"), date));
		}).collect(Collectors.toList());
	}

}
