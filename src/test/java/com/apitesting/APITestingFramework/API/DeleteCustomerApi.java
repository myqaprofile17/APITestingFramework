package com.apitesting.APITestingFramework.API;

import static io.restassured.RestAssured.given;

import java.util.Hashtable;

import io.restassured.response.Response;

public class DeleteCustomerApi {
	public static Response sendDeleteRequestToDeleteCustomerAPIwithValidAuthID(Hashtable<String, String> data) {
		String deleteURl = "https://api.stripe.com/v1/customers/" + data.get("id");
		Response response = given().auth().basic("sk_test_lPiNftCegbEnQ76RpMUJcq5p00ByWcJdXt", "").delete(deleteURl);
		return response;

}
}
