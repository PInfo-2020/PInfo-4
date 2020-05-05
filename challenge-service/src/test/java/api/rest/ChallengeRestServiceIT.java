package api.rest;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.containsString;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ChallengeRestServiceIT {

	@BeforeAll
	public static void setup() {
		System.out.println("-----------------DEBUT SETUP SERVEUR-----------------");
		RestAssured.baseURI = "http://localhost:28080/challenge";
		RestAssured.port = 8080;
		System.out.println("-----------------FIN SETUP SERVEUR-----------------");
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void testGetAll() {
		System.out.println("-----------------DEBUT TEST GETAllREST-----------------");
		when().get("/").then().body(containsString("CREPESAMERE"));
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/");
		ResponseBody body = response.getBody();
		System.out.println(body.asString());
		
		
		System.out.println("-----------------FIN TEST GETAllREST-----------------");

	}

	@Test
	public void testCreate() {
		System.out.println("-----------------DEBUT TEST CreateREST-----------------");
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/create");

//		System.out.println(body.asString());
		
		
		System.out.println("-----------------FIN TEST CreateREST-----------------");

	}
	@Test
	public void testGet() {
		System.out.println("-----------------DEBUT TEST GETREST-----------------");
		when().get("/1").then().body(containsString("CREPESAMERE"));
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/1");
		ResponseBody body = response.getBody();
		System.out.println(body.asString());
		System.out.println("-----------------FIN TEST GETREST-----------------");
	}
	
	@Test
	public void testGetSetIngredient() {
		System.out.println("-----------------DEBUT TEST GETREST Ingredient-----------------");
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/ingredients/1");
		ResponseBody body = response.getBody();
		System.out.println(body.asString());
		System.out.println("-----------------FIN TEST GETREST Ingredient-----------------");
	}
	
	@Test
	public void testCount() {
		System.out.println("-----------------DEBUT TEST COUNTREST-----------------");
		when().get("/count").then().body(containsString("2"));
		System.out.println("-----------------FIN TEST COUNTREST-----------------");
	}

}