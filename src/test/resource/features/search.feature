@search
Feature: search feature

  Background: Given User navigated to the Home Application URL

  Scenario: user is able to open the browser, Navigate to the URL and search for product
    Given User navigated to the Home Application URL
    When  User Search For Product "Laptop"
    Then search Result Page Dispalyed

  @search2
  Scenario: User is able to filter the search based on price
    Given User navigated to the Home Application URL
    When User search for a Product as "Laptop"
    When User enters minimum as "20000" and maximum as "50000" in the filter criteria
    Then User is able to see results with price between "20000" and "50000"

