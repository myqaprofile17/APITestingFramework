package com.apitesting.APITestingFramework.testcases;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.apitesting.APITestingFramework.API.CreateCustomerApi;
import com.apitesting.APITestingFramework.listeners.ExtentListeners;
import com.apitesting.APITestingFramework.setUp.BaseTest;
import com.apitesting.APITestingFramework.utilities.DataUtil;

import io.restassured.response.Response;

public class CreateCustomerTest extends BaseTest {

	@Test(dataProviderClass=DataUtil.class,dataProvider="data")
	public void validateCreateCustomerAPIWithValidSecretKey(Hashtable<String, String> data) {
		Response response = CreateCustomerApi.sendPostRequestToCreateCustomerAPIwithValidAuthKey(data);
		ExtentListeners.testReport.get().info(data.toString());
		response.prettyPrint();
		System.out.println(response.statusCode());
		Assert.assertEquals(response.statusCode(), 200);
	}

	@Test(dataProviderClass=DataUtil.class,dataProvider = "data")
	public void validateCreateCustomerAPIWithInValidSecretKey(Hashtable<String, String> data){
		Response response = CreateCustomerApi.sendPostRequestToCreateCustomerAPIwithInvalidAuthKey(data);
		ExtentListeners.testReport.get().info(data.toString());
		response.prettyPrint();
		System.out.println(response.statusCode());
		Assert.assertEquals(response.statusCode(), 400);
	}


}
