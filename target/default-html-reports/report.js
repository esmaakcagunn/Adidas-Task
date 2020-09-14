$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/ultimateQA.feature");
formatter.feature({
  "name": "As a user I should be able to enter a comment with a correct email from sample page",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@ultimate"
    }
  ]
});
formatter.scenario({
  "name": "Verify that user is able to enter a comment only with a correct email",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@ultimate"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Open home page",
  "keyword": "Given "
});
formatter.match({
  "location": "UltimateComment.open_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Navigate to Sample page",
  "keyword": "And "
});
formatter.match({
  "location": "UltimateComment.navigate_to_Sample_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter a comment with a wrong email",
  "keyword": "When "
});
formatter.match({
  "location": "UltimateComment.enter_a_comment_with_a_wrong_email()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Check Error is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "UltimateComment.check_Error_is_displayed()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Navigate to Sample page",
  "keyword": "And "
});
formatter.match({
  "location": "UltimateComment.navigate_to_Sample_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter a comment with a correct email",
  "keyword": "And "
});
formatter.match({
  "location": "UltimateComment.enter_a_comment_with_a_correct_email()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Check Comment is received",
  "keyword": "And "
});
formatter.match({
  "location": "UltimateComment.check_Comment_is_received()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});