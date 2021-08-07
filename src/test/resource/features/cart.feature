Feature: cart scenario
  @e2e
  Scenario: User is able to order single product with single quantity from the app
    Given user search product "Nokia 3.4 Dusk, 4GB RAM, 64GB Storage"
    When user add the product in the cart with quantity 1
    Then Product should be in the Cart






