Feature: Book a hotel room for 2 people
  As I user i should be able to book a room for 2 people for 10 days

  @hotelBooking
  Scenario Outline:Book a hotel
    Given I have MakeMyTrip application
    When I continue without login into the app
    And I choose to search a hotel
    And I search a hotel in <city> from <fromDate> to <toDate> taking <room> for <customers>
    And I choose a hotel from the list of hotels
    And I check the details of that hotel
    And I book a room that hotel
    And I review my booking by providing <firstName>,<lastName>,<email> and <phoneNumber>
    And I pay by using a payment mode


    Examples:
      | city | fromDate    | toDate       | room | customers | firstName | lastName | email         | phoneNumber |
      | Goa  | 6 June 2017 | 7 June 2017 | 1    | 2         | raj       | sharma   | raj@gmail.com | 1231231232  |