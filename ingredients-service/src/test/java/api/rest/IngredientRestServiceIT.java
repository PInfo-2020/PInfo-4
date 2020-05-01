package api.rest;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.containsString;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import domain.model.Ingredient;
import io.restassured.RestAssured;

public class IngredientRestServiceIT {

	@BeforeAll
	public static void setup() {
		RestAssured.baseURI = "http://localhost:28080/ingredient";
		RestAssured.port = 8080;
	}
	
	@Test
	public void testGetAll() {
		when().get("/").then().body(containsString("chocolat"));
	}
	
	@Test
	public void testGet() {
		when().get("/2").then().body(containsString("amande"));
	}

	@Test
	public void testComputeCalories() {
		when().get("/computeCalories?id=1&id=2&id=4").then().body(containsString("9"));
	}
	
	
	@Test
	public void testGetPossibleIngredients() {
		when().get("/possibleIngredients?ing=choco").then().body(containsString("chocolat"));
	}
	
	
	@Test
	public void testCount() {
		when().get("/count").then().body(containsString("13"));
	}
	

}