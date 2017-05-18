Feature: Book a hotel room for 2 people
  As I user i should be able to book a room for 2 people for 10 days

  Scenario Outline:Book a hotel
    Given I have MakeMyTrip application
    When I continue without login into the app
    And I choose to search a hotel
    And I search a hotel in <city> from <fromDate> to <toDate> taking <room> for <customers>
    And I choose a hotel from the list of hotels
    And I find out the details of that hotel
    And I book a room that hotel
    And I review my booking
    And I pay by using a payment mode
    Then I should see a payment success method

    Examples:
      | city      | fromDate    | toDate      | room | customers |
      | Amsterdam | 17 May 2016 | 25 May 2016 | 2    | 4         |