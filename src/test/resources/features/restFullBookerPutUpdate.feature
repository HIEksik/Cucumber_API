Feature: Restful Booker Update
  @Api
  Scenario: Restfull Booker Put Update

    Given kullanici update icin "restful" adresine gider
    Then kullanici update icin path parametresi olarak "booking" girer
    Then kullanici update icin "1296" girer
    Then kullanici update icin bir body olusturur
    Then kullanici bir put request gonderip donen response degerini kaydeder
    Then kullanici donen response degerini yazdirir