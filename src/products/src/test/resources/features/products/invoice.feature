@now
Feature: Products invoice price  
  Test to list a set of products and view invoice products price  
  I want to list the created products 
  So that I need to call products list facade with no filters and after check products price a 
 
 
  Scenario: List ALL invoice product objects after creation
   	Given existing 2 products in database
  	When run list products, after products creation process
    Then the facade should return "110.00" price 
  