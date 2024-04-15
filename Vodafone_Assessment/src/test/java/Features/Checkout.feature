@CompleteCheckout
Feature: Complete checkout with first item
  Scenario Outline:Add Product to Cart
    Given Login with a valid data "<UserName>","<Password>"
    When Click on the first element
    Then Add it to cart
      Examples:
      |UserName | Password|
      |Khaledtv | 123456789|

    Scenario Outline:Place an Order
      Given GO to cart
      When Click on place order
      And Fill the Data "<Name>" , "<Country>" , "<City>" , "<CreditCard>" , "<Month>" , "<Year>"
      Then Click Purchase

       Examples:
       | Name | Country  | City  | CreditCard | Month | Year|
       | Mohamed |  Egypt | Cairo | 0129283736| 4 |2024     |