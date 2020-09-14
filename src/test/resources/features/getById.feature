@getById @api
Feature: get request verification by id

  Scenario Outline: verify get request for "Call current weather data for one location" only by city id
    Given I call current weather data for "<city id>"
    When I get the current information from api
    Then status code should be 200
    And content type of the payload is JSON
    And the id of the city is matching with "<city id>"
    Examples:
      | city id |
      | 2172797 |
      | 2147714 |
      | 2643743 |
      | 3114472 |
