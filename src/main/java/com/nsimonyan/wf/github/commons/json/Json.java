package com.nsimonyan.wf.github.commons.json;

import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 * using this utility class to avoid some inconvenience of json.simple
 * 
 * @author naira.simonyan
 *
 */
public class Json {

	private Json() {
	}

	@SuppressWarnings("unchecked")
	public static <T> T get(JSONObject o, Object key, T defaultValue, Class<T> clazz) {
		try {
			return clazz.cast(o.getOrDefault(key, defaultValue));
		} catch (ClassCastException e) {
			return defaultValue;
		}
	}

	public static JSONObject parse(Object js) {
		return (JSONObject) JSONValue.parse(js.toString());
	}

	public static JSONObject parse(String js) {
		return (JSONObject) JSONValue.parse(js);
	}

	public static JSONArray parseArray(Object object) {
		return (JSONArray)JSONValue.parse(object.toString());
	}

	public static String getString(JSONObject o, Object key) {
		return Json.getString(o, key, null);
	}

	public static String getString(JSONObject o, Object key, String defaultValue) {
		return Json.get(o, key, defaultValue, String.class);
	}

	public static Integer getInteger(JSONObject o, Object key) {
		return Json.getInteger(o, key, null);
	}

	public static Integer getInteger(JSONObject o, Object key, Integer defaultValue) {
		return Json.get(o, key, defaultValue, Integer.class);
	}

	public static JSONArray getJSONArray(JSONObject o, Object key) {
		return Json.getJSONArray(o, key, null);
	}

	public static JSONArray getJSONArray(JSONObject o, Object key, JSONArray defaultValue) {
		return Json.get(o, key, defaultValue, JSONArray.class);
	}

	@SuppressWarnings("unchecked")
	public static JSONObject createFromMap(Map map) {
		JSONObject result = new JSONObject();
		result.putAll(map);
		return result;
	}
}
