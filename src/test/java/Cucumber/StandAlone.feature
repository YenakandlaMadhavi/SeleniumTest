
@tag
Feature: Order the items in Ecommerce appication
  I want to use this template for my feature file

 Background:
 Given I Land on Ecommerce Page 
 


  @tag2
  Scenario Outline: positive test scenario for order an item
    Given login with username <userName> and password <Password>
    When add the product <Product> to cart
    And checkout <Product> submit the order
    Then "Thankyou for the order." message is displayed on confirmation page

    Examples: 
      | userName     	  | Password 	| Product					|
      |anuAB@gmail.com	|Madhu@17  	|adidas original	|
      |anshika@gmail.com|Iamking@000|zara coat 3			|
