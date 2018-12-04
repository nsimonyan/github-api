package com.nsimonyan.wf.github.controller;

import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.RestClientException;

public class BaseController {
	@ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Throwable.class)
	public JSONObject baseExceptionHandling(Throwable t){
		JSONObject response = new JSONObject();
		response.put("error", "Sorry something went wrong. Please check your params.");
		return response;
	}

	@ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(RestClientException.class)
	public JSONObject restClientExceptionHandling(RestClientException t){
		JSONObject response = new JSONObject();
		response.put("error", t.getMessage());
		return response;
	}
}
