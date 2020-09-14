@ultimate
Feature: As a user I should be able to enter a comment with a correct email from sample page

  Scenario: Verify that user is able to enter a comment only with a correct email

      Given Open home page
      And Navigate to Sample page
      When Enter a comment with a wrong email
      Then Check Error is displayed
      And Navigate to Sample page
      And Enter a comment with a correct email
      And Check Comment is received
