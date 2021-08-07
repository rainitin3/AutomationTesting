Feature: sighIn amazon Account

  @sighIn
  Scenario: sigh in using correct UserId and Password
    Given user Navigate to Url
    When User Enter UserId "rainitin3@gmail.com"
    Then user should be able to enter password "nitin@123"