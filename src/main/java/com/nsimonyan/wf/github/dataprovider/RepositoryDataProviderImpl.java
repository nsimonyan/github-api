package com.nsimonyan.wf.github.dataprovider;

import java.util.List;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.nsimonyan.wf.github.commons.json.Json;
import com.nsimonyan.wf.github.dataprovider.interfaces.RepositoryDataProvider;
import com.nsimonyan.wf.github.model.Repository;

public class RepositoryDataProviderImpl implements RepositoryDataProvider {

	@Override
	public List<Repository> searchRepository(final String query, final int page)  {
		JSONObject resultJson = Json.parse(searchRepositoryInApi(query, page));
		return toRepositoryList(Json.getJSONArray(resultJson, "items"));
	}

	private String searchRepositoryInApi(final String query, final int page)  {
		return GitHubRequestSender.send(new StringBuilder("search/repositories?q=").append(query)
				.append("+in:name&per_page=100&page=").append(page == 0 ? "1" : page).toString());
	}
	@SuppressWarnings("unchecked")
	private List<Repository> toRepositoryList(final JSONArray items) {
		return (List<Repository>) items.stream().map(item -> {
			final JSONObject jsonObject = Json.parse(item);
			return new Repository(Json.getInteger(jsonObject, "id"), Json.getString(jsonObject, "full_name"),
					Json.getString(jsonObject, "description"));
		}).collect(Collectors.toList());
	}
}
