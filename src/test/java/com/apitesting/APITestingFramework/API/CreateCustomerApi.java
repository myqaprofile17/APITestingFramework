package com.apitesting.APITestingFramework.API;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import io.restassured.response.Response;
/* this is a new commit */
public class CreateCustomerApi {
	public static Response sendPostRequestToCreateCustomerAPIwithInvalidAuthKey(Hashtable<String, String> data) {
		Response response = given().auth().basic("sk_test_lPiNftCegbEnQ76RpMUJcq5p00ByWcJdXt1", "").formParam("name", data.get("name")).formParam("email", data.get("email")).formParam("description", data.get("description")).post("https://api.stripe.com/v1/customers");
		return response;

	}
public static  Response sendPostRequestToCreateCustomerAPIwithValidAuthKey(Hashtable<String, String> data) {
	Response response = given().auth().basic("sk_test_lPiNftCegbEnQ76RpMUJcq5p00ByWcJdXt", "").formParam("name", data.get("name")).formParam("email", data.get("email")).formParam("description", data.get("description")).post("https://api.stripe.com/v1/customers");
	return response;
	}
}
