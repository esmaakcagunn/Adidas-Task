@getByCity @api
Feature: get request verification by city name

  Scenario: verify get request for "Call current weather data for one location" only by city name
    Given I call current weather data for "London"
    When I get the current information from api
    Then status code should be 200
    And content type of the payload is JSON
    And the name of the city is matching

  Scenario: verify get request for "Call current weather data for one location" by city name and state code
    Given I call current weather data for "Sydney" and "200"
    When I get the current information from api
    Then status code should be 200
    And content type of the payload is JSON
    And the name of the city is matching

  Scenario: verify get request for "Call current weather data for one location" by city name,state code and country code
    Given I call current weather data for "Sydney" "200" and "AU"
    When I get the current information from api
    Then status code should be 200
    And content type of the payload is JSON
    And the name of the city is matching
    And the country code is matching
