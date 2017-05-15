Feature: Book a hotel room for 2 people
  As I user i should be able to book a room for 2 people for 10 days

  Scenario Outline:Book a hotel
    Given I have MakeMyTrip application
    When I continue without login into the app
    Examples:
      |  |