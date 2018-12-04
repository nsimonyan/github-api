package com.nsimonyan.wf.github.controller.interfaces;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public interface UserController {
	
	public JSONArray listUsers(final String repositoryFullName);
	public JSONObject usersImpact(final String repositoryFullName);


}
