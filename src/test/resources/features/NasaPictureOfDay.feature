Feature: Nasa Fotograf Bulma


  Scenario: Nasa Gunun Fotografi

    Given kullanici resim icin "nasa" adresine gider.
    Then kullanici site path parametresi olarak "planetary/apod" girer.
    Then kullanici query parametrelerini key degeri "apikey" value degeri "Z54FdDPLyRGyu2M0ANTxvFKhIyAcVjk3KAZqUuHo" olarak girer.
    Then kullanici diger query parametrelerini key_2 degeri "start_date" value_2 degerini "2024-04-23" olarak girer.
    Then kullanici diger query parametrelerini key_3 degeri "end_date" value_3 degerini "2024-04-23" olarak girer.
    Then kullanici donen response degerini kaydeder.
    Then kullanici donen response listesini yazdirir.