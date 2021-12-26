
Feature: starbucks Test
  Scenario Outline: starbucks WrongforgotPass Test
    Given popup kapatilir ve signin sayfasina girilir.
    When forgotPassword butonuna tıklanir.
    And "<email>" girilir
    And butona tiklanir
    Then message kontrol edilir.
    Examples:
      |email|
      |abd |

  Scenario Outline: starbucks forgotPass Test
    Given popup kapatilir ve signin sayfasina girilir.
    When forgotPassword butonuna tıklanir.
    And "<email>" girilir
    And butona tiklanir
    Then "<message>" kontrol edilir.
    Examples:
      |email|message|
      |uzundagdeniz@gmail.com |Password reset link has been sent to you.|

  Scenario Outline: starbucks login Test
    Given popup kapatilir ve signin sayfasina girilir.
    When "<email>" ve "<password>" girilir
    And login butona tiklanir
    Examples:
      |email|password|
      |uzundagdeniz@gmail.com |******|

  Scenario Outline: starbucks Wronglogin Test
    Given popup kapatilir ve signin sayfasina girilir.
    When "<email>" girilir "<password>" bos gecilir
    And login butona tiklanir
    Then hata "<message>" kontrol edilir.
    Examples:
      |email|password|message|
      |abcdsd@gmail.com||Please check the e-mail address you entered.|