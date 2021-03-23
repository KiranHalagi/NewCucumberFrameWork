$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/features/Tagging.feature");
formatter.feature({
  "line": 1,
  "name": "Tagging Concept",
  "description": "",
  "id": "tagging-concept",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Login",
  "description": "",
  "id": "tagging-concept;login",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@Smoke"
    },
    {
      "line": 3,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "Login to actitime",
  "keyword": "Given "
});
formatter.match({
  "location": "TaggingDemo.login_to_actitime()"
});
formatter.result({
  "duration": 223766152,
  "status": "passed"
});
});