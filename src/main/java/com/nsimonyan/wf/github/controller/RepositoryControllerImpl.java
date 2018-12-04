package com.nsimonyan.wf.github.controller;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nsimonyan.wf.github.commons.encode.EncodeUtils;
import com.nsimonyan.wf.github.controller.interfaces.RepositoryController;
import com.nsimonyan.wf.github.model.Repository;
import com.nsimonyan.wf.github.usecase.interfaces.SearchRepositoriesUseCase;

@RestController
public class RepositoryControllerImpl extends BaseController implements RepositoryController {
	private static final String SEARCH_REPOSITORY = "/searchRepository";
	private static final Logger logger = LoggerFactory.getLogger(RepositoryControllerImpl.class);

	@Autowired
	SearchRepositoriesUseCase searchRepositoriesUseCase;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = SEARCH_REPOSITORY, method = RequestMethod.GET)
	public @ResponseBody JSONArray searchRepository(@RequestParam(value="query", required=true) final String query,
			@RequestParam(value="page", required=true) final int page) {
			List<Repository> repositories = searchRepositoriesUseCase.execute(EncodeUtils.tryToDecode(query), page);
			return toJSONArray(repositories);


	}

	private JSONArray toJSONArray(List<Repository> repos) {
		JSONArray result = new JSONArray();

		JSONObject repositoryJson;
		for (Repository repo : repos) {
			repositoryJson = new JSONObject();
			repositoryJson.put("fullName", repo.getFullName());
			repositoryJson.put("description", repo.getDescription());

			result.add(repositoryJson);
		}

		return result;
	}

}