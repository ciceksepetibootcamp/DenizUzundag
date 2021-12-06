Feature: Tipster Test
  Scenario Outline: Tipster Login Test
    Given Kullanici anasayfayi ziyaret eder
    When email kutusuna "<email>" bilgisini  Password kutusuna "<password>" bilgisini girer
    And login butona tıklar
    Then kullanıcı login olur ve "<username>" görür
    Examples:
      |email                 | password   |      username|
      |netcoredev1@gmail.com | Password12*|      netcoredev|

  Scenario Outline: Tipster ForgotPassword Test
    Given Kullanici anasayfayi ziyaret eder
    When forgotPassword butonuna tiklar
    And acilanan popupa "<email>" adresini girer
    Then send butonuna tiklar
    Examples:
      |email|
      |netcoredev1@gmail.com|

  Scenario Outline: Tipster SuperLig Test
    Given Kullanici anasayfayi ziyaret eder
    When Sportwetten kategorisini secer
    Then "<list>" listesini gorur
    Examples:
    |list|
    |TOP-SPIELE|



