


Feature: ColectApi apiKey kullanımı

  Scenario: Nöbetçi Eczaneler Listesi Çağırma

    Given kullanici "collectApi" test adresine gider
    Then kullanici path parametresi olarak "health/dutyPharmacy" girer
    Then kullanici query parametrelerini key degeri "il" value degeri "Diyarbakır" olarak girer
    Then kullanici diger query parametrelerini key2 degeri "ilce" valeu2 degerini "Kayapınar" olarak girer
    Then kullanici donen response degerini kaydeder
    And kullanici donen response listesini yazdirir


    Scenario: Doviz Bilgileri Yazdırma
      
      Given kullanici "collectApi" test adresine gider
      Then kullanici path parametresi olarak "economy/currencyToAll" girer
      Then kullanici query parametrelerini key degeri "int" value degeri "1" olarak girer
      Then kullanici diger query parametrelerini key2 degeri "base" valeu2 degerini "TRY" olarak girer
      Then kullanici donen response degerini kaydeder
      Then kullanici donen response listesini yazdirir

