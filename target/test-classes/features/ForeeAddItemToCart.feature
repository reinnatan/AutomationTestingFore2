@tag
Feature: Add Item in Foree Coffe Store
    Add Item in Foree Coffe Store

    @tag1
    Scenario: Add Item in Foree Coffe Store
    Given Open Foree apps and enter dashboard
    And Search Manuka Affericano and add to cart
    And Search Coffee and add to cart
    When Buy all the items in cart
    But Input invalid phone number
    Then Showing error message
