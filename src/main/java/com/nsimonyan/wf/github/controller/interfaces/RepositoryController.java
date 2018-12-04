package com.nsimonyan.wf.github.controller.interfaces;

import org.json.simple.JSONArray;

public interface RepositoryController {
	public JSONArray searchRepository(final String query, final int page);

}
