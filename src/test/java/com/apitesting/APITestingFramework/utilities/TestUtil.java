package com.apitesting.APITestingFramework.utilities;

import org.json.JSONObject;

import com.apitesting.APITestingFramework.listeners.ExtentListeners;

public class TestUtil {
	
	public static boolean jsonHasKey(String Json,String key) {
		JSONObject jsonObject = new JSONObject(Json);
		ExtentListeners.testReport.get().info("validating presence of Key " + key);
		return  jsonObject.has(key);	
		
	}
	public static String jsonHasString(String Json, String key) {
		JSONObject jsonObject = new JSONObject(Json);
		ExtentListeners.testReport.get().info("validating value of Key " + key);
		return  jsonObject.get(key).toString();	
		
	}

}
