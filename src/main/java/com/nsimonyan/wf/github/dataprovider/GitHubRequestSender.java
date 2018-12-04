package com.nsimonyan.wf.github.dataprovider;

import org.springframework.web.client.RestTemplate;

class GitHubRequestSender {
	private static final String GIT_API = "https://api.github.com/";

	static String send(final String requestPath) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(GIT_API + requestPath, String.class);
	}
}
