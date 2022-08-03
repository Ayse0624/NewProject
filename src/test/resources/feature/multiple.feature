Feature: user should be login with multiple account

  @multiple
  Scenario Outline: user login with multiple
    Given user already on the dashboard page
    When enter "<data1>""<data2>"on the filed
    Then login success
    Examples:
    |data1|data2|
    |ayixa062419@gmail.com|Ay12345|
    |ayixa062499@gmail.com|Ay12345|