package com.nsimonyan.wf.github.controller;

import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nsimonyan.wf.github.commons.encode.EncodeUtils;
import com.nsimonyan.wf.github.controller.interfaces.UserController;
import com.nsimonyan.wf.github.model.User;
import com.nsimonyan.wf.github.usecase.interfaces.ListUniqueUsersUseCase;
import com.nsimonyan.wf.github.usecase.interfaces.UsersImpactUseCase;

@Controller
@RestController
public class UserControllerImpl extends BaseController implements UserController {
	private static final String LIST_USERS = "/listUniqueUsers";
	private static final String USERS_IMPACT = "/usersImpact";
	private static final Logger logger = LoggerFactory.getLogger(UserControllerImpl.class);

	@Autowired
	ListUniqueUsersUseCase listUniqueUsersUseCase;

	@Autowired
	UsersImpactUseCase usersImpactUseCase;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = LIST_USERS, method = RequestMethod.GET)
	public @ResponseBody JSONArray listUsers(@RequestParam(value="repositoryFullName", required=true) final String repositoryFullName) {
			Set<User> users = listUniqueUsersUseCase.execute(EncodeUtils.tryToDecode(repositoryFullName));
			return toJSONArray(users);

	}

	@RequestMapping(value = USERS_IMPACT, method = RequestMethod.GET)
	public @ResponseBody JSONObject usersImpact(@RequestParam(value="repositoryFullName", required=true) final String repositoryFullName) {
			Map<String, Long> usersImpact = usersImpactUseCase.execute(EncodeUtils.tryToDecode(repositoryFullName));
			return new JSONObject(usersImpact);
	}

	private JSONArray toJSONArray(Set<User> users) {
		JSONArray result = new JSONArray();

		JSONObject userJson;
		for (User user : users) {
			userJson = new JSONObject();
			userJson.put("name", user.getName());
			userJson.put("email", user.getEmail());
			userJson.put("date", user.getDate());

			result.add(userJson);
		}

		return result;
	}
}