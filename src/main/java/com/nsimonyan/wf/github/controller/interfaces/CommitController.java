package com.nsimonyan.wf.github.controller.interfaces;

import org.json.simple.JSONObject;

public interface CommitController{
	public JSONObject commitsTimeline(final String repositoryFullName);


}
