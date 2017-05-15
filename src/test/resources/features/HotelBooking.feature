Feature: Book a hotel room for 2 people
  As I user i should be able to book a room for 2 people for 10 days

  Scenario Outline:Book a hotel
    Given I have MakeMyTrip application
    When I continue without login into the app
    And I choose to search a hotel
    And I search a Hotel in <city> from <fromDate> to <toDate> taking <room> for <customers>

    Examples:
      | city      | fromDate    | toDate      | room | customers |
      | Amsterdam | 17 May 2016 | 25 May 2016 | 2    | 4         |