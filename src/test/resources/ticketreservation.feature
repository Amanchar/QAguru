Feature: Ticket Reservation

  Scenario: Ticket Reservation Testing
    Given departure airport RIX
    And destination airport MEL
    And user data is:
      | name           | John       |
      | surname        | Smith      |
      | discountCode   | abcd       |
      | travellerCount | 3          |
      | childrenCount  | 1          |
      | luggage        | 4          |
      | nextFlight     | 13-05-2018 |
    And seat number is 15
    And we're on a home page

    When we're selecting airports
    And we're pressing GoGoGo button
    Then registration page appears

    When we're filling in registration form
    And we're pressing get price button
    Then our price will be 1000 eur

    When press book button
    Then we are redirected to seat page

    When we are selecting seat number
    And we are clicking Book button
    Then successful registration page appears

    When we're requesting reservation list
    Then we can see our reservation in the list

    When we are deleting our reservation ticket
    And we requesting reservation list again
    Then we can see that our reservation in not in the list