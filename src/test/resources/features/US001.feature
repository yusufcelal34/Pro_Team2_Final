Feature: US001 Kullanici ansayfaya erişebilmeli

  Scenario:Kullanici ilgili url i yazdığında anasayfaya erişebilmeli
    Given Kullanici "url" anasayfaya gider
    And Kullanici senkronizasyon için 5 saniye bekler
    Then Kullanici title in "Home | InstuLearn" oldugunu test eder


