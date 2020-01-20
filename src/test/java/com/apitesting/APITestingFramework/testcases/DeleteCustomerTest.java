package com.apitesting.APITestingFramework.testcases;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.Hashtable;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.apitesting.APITestingFramework.API.DeleteCustomerApi;
import com.apitesting.APITestingFramework.listeners.ExtentListeners;
import com.apitesting.APITestingFramework.setUp.BaseTest;
import com.apitesting.APITestingFramework.utilities.DataUtil;
import com.apitesting.APITestingFramework.utilities.TestUtil;

import io.restassured.response.Response;

public class DeleteCustomerTest extends BaseTest {

	@Test(dataProviderClass=DataUtil.class,dataProvider="data")
	public void deleteCustomerwithDeleteCuctomereAPIwithValidID(Hashtable<String, String> data) {
		Response response = DeleteCustomerApi.sendDeleteRequestToDeleteCustomerAPIwithValidAuthID(data);
		ExtentListeners.testReport.get().info(data.toString());
		response.prettyPrint();
		System.out.println(response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
//		String actualId = response.jsonPath().get("id").toString();
//		System.out.println(actualId);
//		String expectedId = data.get("id");
//		System.out.println(expectedId);
//		assertEquals(actualId, expectedId,"ID do not match");
		System.out.println("Presence of Object : " + TestUtil.jsonHasKey(response.asString(), "object"));
		System.out.println("Presence of deleted : " + TestUtil.jsonHasKey(response.asString(), "deleted"));
		Assert.assertTrue(TestUtil.jsonHasKey(response.asString(), "id"),"id is not present");
//		System.out.println(jsonObject.has("id"));
//		Assert.assertTrue(jsonObject.has("id"),"Id is not present");
//		String actualId = jsonObject.get("id").toString();
//	
		String actualId = TestUtil.jsonHasString(response.asString(), "id");
		String expectedId = data.get("id");
		System.out.println("Value of object" + TestUtil.jsonHasString(response.asString(), "object"));
		System.out.println("Value of object" + TestUtil.jsonHasString(response.asString(), "deleted"));
		Assert.assertEquals(actualId, expectedId,"ID do not match");
		
	}	
	}



