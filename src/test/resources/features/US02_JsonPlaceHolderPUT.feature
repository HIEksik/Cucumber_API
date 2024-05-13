
Feature: US02 JPH PUT REQUEST

@Api
  Scenario: Us02 JsonPlaceHolder PUT Request

    Given kullanici "JsonPlaceUrl" adresine gider
    Then kullanici path parametrleri olarak "posts/70" girer
    Then kullanici post request icin "Ahmet","Merhaba", 10 70 bilgileri ile reqBody olusturur
    Then kullanici post request gonderir ve donen response kaydeder
    And kullanici donen cevabin status degerinin 200 oldugunu kontrol eder
    And kullanici donen cevabin content-type degerinin "application/json; charset=utf-8" oldugunu kontrol eder
    And kullanici donen cevabin "Connection" isimli header degerinin "keep-alive" oldugunu kontrol eder
    And kullanici donen cevabin attribute degerlerinin "Ahmet","Merhaba",10 70 oldugunu kontrol eder