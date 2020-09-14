@getByGeographicCoordinates @api
Feature: get request verification by geographic coordinates

  @only
  Scenario: verify get request for "Call current weather data for one location" by geographic coordinates
    Given I call current weather data by following geographic coordinates
      | lat | 35  |
      | lon | 139 |
    When I get the current information from api
    Then status code should be 200
    And content type of the payload is JSON
    And the coordinates are matching with following ones
      | lat | 35  |
      | lon | 139 |