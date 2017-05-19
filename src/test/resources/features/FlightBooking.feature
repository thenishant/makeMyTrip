Feature: Search for a flight
  As a user I should be able to book a flight from one place to another place.

  @flightBooking @OneWayJourney
  Scenario Outline: search a one way flight flight
    Given I have MakeMyTrip application
    When I continue without login into the app
    And I choose to search a flight
    And I search flight from <source> to <destination> departing on <date> for <noOfPassenger> on <class>
#    And I search flight for <journey>
    And I choose a flight based on price
    And I enter <firstName>, <lastName>,<gender> as traveler details
    And I provide contact <email>, <phoneNumber> as contact details
    And I pay by using a payment mode
    Examples:
      | journey       | source | destination | date        | noOfPassenger | class   | firstName | lastName | gender | email                | phoneNumber |
      | oneWayJourney | Mumbai | New Delhi   | 3 July 2017 | 1            | Economy | Nishant   | Sharma   | Male   | iamnishant@gmail.com | 56565655656 |
#    Then I should be able to see search flight page

  @flightBooking @TwoWayJourney
  Scenario Outline: search a two way flight
    Given I have MakeMyTrip application
    When I continue without login into the app
    And I choose to search a flight
    And I search flight from <source> to <destination> departing <depDate> returning <returnDate> for <noOfPassenger> on <class>
    And I choose a two flight based on price
    And I enter <firstName>, <lastName>,<gender> as traveler details
    And I provide contact <email>, <phoneNumber> as contact details
    And I pay by using a payment mode
    Examples:
      | source | destination | depDate     | returnDate   | noOfPassenger | class   | firstName | lastName | gender | email                | phoneNumber |
      | Mumbai | New Delhi   | 3 July 2017 | 15 july 2017 | 1             | Economy | Nishant   | Sharma   | Male   | iamnishant@gmail.com | 56565655656 |
#    Then I should be able to see search flight page