@getBySeveralCityIds @api
Feature: get request verification by several city ids

  Scenario Outline: verify get request for "Call current weather data for several cities" by city ids
    Given I call current weather data for several cities with "<city id1>", "<city id2>","<city id3>"
    When I get the current information from api
    Then status code should be 200
    And content type of the payload is JSON
    And Response header contains date
    And the ids of the city is matching with <city id1>, <city id2>, <city id3>
    Examples:
      | city id1 | city id2 | city id3 |
      | 2172797  | 524901   | 2643743  |
      | 2147714  | 703448   | 3114472  |


