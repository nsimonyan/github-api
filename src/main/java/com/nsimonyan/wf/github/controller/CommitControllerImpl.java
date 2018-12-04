package com.nsimonyan.wf.github.controller;

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
import com.nsimonyan.wf.github.commons.json.Json;
import com.nsimonyan.wf.github.controller.interfaces.CommitController;
import com.nsimonyan.wf.github.usecase.interfaces.ProjectionOfCommitsUseCase;

@RestController
public class CommitControllerImpl extends BaseController implements CommitController {
	private static final String COMMITS_PROJECTION = "/projectionOfCommits";
	private static final Logger logger = LoggerFactory.getLogger(CommitControllerImpl.class);	

	@Autowired
	ProjectionOfCommitsUseCase projectionOfCommitsUseCase;

	@RequestMapping(value = COMMITS_PROJECTION, method = RequestMethod.GET)
	public @ResponseBody JSONObject commitsTimeline(@RequestParam(value="repositoryFullName", required=true) final String repositoryFullName) {
		return Json.createFromMap(projectionOfCommitsUseCase.execute(EncodeUtils.tryToDecode(repositoryFullName)));
	}

}