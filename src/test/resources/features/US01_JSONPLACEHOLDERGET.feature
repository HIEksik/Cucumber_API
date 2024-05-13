Feature: US 01 JsonPlaceHolder Get request


  Scenario:  TC01 JsonPlaceHolder Get request

    Given kullanici "JsonPlaceUrl" adresine gider
    Then kullanici path parametrleri olarak "posts/90" girer
    Then kullanici bir GET request gonderir ve donen response degerini kaydeder
    And kullanici donen cevabin status degerinin 200 oldugunu kontrol eder
    And kullanici donen cevabin content-type degerinin "application/json; charset=utf-8" oldugunu kontrol eder
    And kullanici donen cevaptaki userid degerinin 9 oldugunu kontrol eder
    And kullanici donen cevaptaki title degerinin "ad iusto omnis odit dolor voluptatibus" oldugunu kontrol eder