package com.adidasAutomation.stepDefinitions;

import com.adidasAutomation.POJOS.CityCallByCoord;
import com.adidasAutomation.POJOS.Coord;
import com.adidasAutomation.utilities.ConfigurationReader;
import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.*;

import static io.restassured.RestAssured.given;

public class GetRequest {

    Map<String,String> queryMap = new HashMap<>();
    Response response;

    public GetRequest(){
        queryMap.put("appid", ConfigurationReader.getProperty("apiKey"));
    }


    @Given("I call current weather data for {string}")
    public void i_call_current_weather_data_for_with(String cityInfo) {

        String numbers="(.*[0-9].*)";

        if(cityInfo.matches(numbers))
            queryMap.put("id", cityInfo);
        else
            queryMap.put("q",cityInfo);



    }

    @Given("I call current weather data for {string} and {string}")
    public void i_call_current_weather_data_for_and_with(String cityInfo, String stateCode) {
        queryMap = new HashMap<>();
        queryMap.put("q",cityInfo+","+stateCode);

}

    @Given("I call current weather data for {string} {string} and {string}")
    public void i_call_current_weather_data_for_and_with(String cityInfo, String stateCode, String countryCode) {

        queryMap = new HashMap<>();
        queryMap.put("q",cityInfo+","+stateCode+","+countryCode);

    }

    @Given("I call current weather data for several cities with {string}, {string},{string}")
    public void i_call_current_weather_data_for_several_cities_with(String cityId1, String cityId2, String cityId3) {
        queryMap.put("id",cityId1+","+cityId2+","+cityId3);
        queryMap.put("units","metric");
    }



    @When("I get the current information from api")
    public void i_get_the_current_information_from_api() {

        String endpoint = "weather";

        if(queryMap.containsKey("id") )
           if(queryMap.get("id").contains(","))
            endpoint = "group";

        response = given().accept(ContentType.JSON)
                .queryParams(queryMap)
                .when().get("/data/2.5/"+endpoint);

    }

    @Then("status code should be {int}")
    public void status_code_should_be(int statusCode) {
        assertEquals(statusCode,response.statusCode());

    }

    @Then("content type of the payload is JSON")
    public void content_type_of_the_payload_is_JSON() {
        assertEquals("application/json; charset=utf-8",response.contentType());

    }

    @Then("the name of the city is matching")
    public void the_name_of_the_city_is_matching() {
        response.then().assertThat().body("name", equalTo(queryMap.get("q").split(",")[0]));
    }

    @Then("the country code is matching")
    public void the_country_code_is_matching() {

        Map<String,Object> weatherMap = response.body().as(Map.class);

        Map<String,Object> sysMap = (Map<String, Object>) weatherMap.get("sys");

        String actualCountryCode = (String) sysMap.get("country");

        String expectedCountryCode = queryMap.get("q").split(",")[2];

        assertEquals(expectedCountryCode,actualCountryCode);

    }

    @Then("the id of the city is matching with {string}")
    public void the_id_of_the_city_is_matching_with(String cityId) {
        response.then().assertThat().body("id", equalTo(Integer.valueOf(cityId)) );
    }

    @Then("Response header contains date")
    public void response_header_contains_date() {
        assertTrue(response.headers().hasHeaderWithName("Date"));
    }


    @Then("the ids of the city is matching with {int}, {int}, {int}")
    public void the_ids_of_the_city_is_matching_with(Integer cityId1, Integer cityId2, Integer cityId3) {
        JsonPath json = response.jsonPath();

        List<Integer> actualCityIds = json.getList("list.id");

        List<Integer> expectedCityIds = Arrays.asList(cityId1,cityId2,cityId3);

        assertEquals(expectedCityIds,actualCityIds);

    }

    @Given("I call current weather data by following geographic coordinates")
    public void i_call_current_weather_data_by_following_geographic_coordinates(Map<String,String> coordinates) {
        queryMap.put("lat",coordinates.get("lat"));
        queryMap.put("lon",coordinates.get("lon"));

    }

    @Then("the coordinates are matching with following ones")
    public void the_coordinates_are_matching_with_following_ones(Map<String,String> coordinates) {

        CityCallByCoord cityCallByCoord = response.body().as(CityCallByCoord.class);

        Integer expectedLat = Integer.parseInt(coordinates.get("lat"));
        Integer actualLat = cityCallByCoord.getCoord().getLat() ;
        assertEquals(expectedLat,actualLat);

        Integer expectedLon = Integer.parseInt(coordinates.get("lon"));
        Integer actualLon = cityCallByCoord.getCoord().getLon() ;
        assertEquals(expectedLon,actualLon);


    }


}
