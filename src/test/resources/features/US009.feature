

  Feature: US009 Bir kullanici olarak( eğitmen ya da kuruluş olarak)
  sitenin anasayfasında işlemlerimi yönetebilecegim bir bölüm olmasını istiyorum .

  Scenario: TC01 "Become an Instructor" basligi gorunurluk testi

    Given kullanici anasayfaya gider
    And senkronizasyon icin 3 saniye bekler
    Then kullanici anasayfadaki yaziya kadar iner
    And senkronizasyon icin 3 saniye bekler
    When Become an Instructor basliginin gorundugunu test eder


  Scenario: TC02 "Become an Instructor" butonu kullanılabilirlik testi

    Given kullanici anasayfaya gider
    And senkronizasyon icin 3 saniye bekler
    Then kullanici Become An Instructor butonuna kadar iner
    And senkronizasyon icin 3 saniye bekler
    When Become an Instructor butonunun kullanılabilirligini test eder

  Scenario: TC03 Instructor olmak için giriş sayfasına ulaşılabilirlik testi

    Given kullanici anasayfaya gider
    And senkronizasyon icin 3 saniye bekler
    Then kullanici Become An Instructor butonuna kadar iner
    And senkronizasyon icin 3 saniye bekler
    When Become an Instructor butonuna tıklar
    And senkronizasyon icin 2 saniye bekler
    And login sayfasına ulaşabildiğini test eder

