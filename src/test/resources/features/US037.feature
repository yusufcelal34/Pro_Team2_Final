@sevval
Feature: Kayıtlı bir kullanıcı olarak tüm bildirimleri görebileceğim bir sayfa olmasını istiyorum

Scenario:
    Given kullanıcı sayfaya gider
    When üst login butonuna tıklar
    And e mail kutusuna EmailSevval yazar
    And password kutusuna PasswordSevval yazar
    And log in butonuna tıklar
  Then dashboard sayfasına erişir

  @Sevval01
  Scenario:[TC-001] kullanıcı dashboard sayfasında "Notifications" linki görünür ve aktif olmalı
    Then dashboard sayfasında "Notifications" bölümü gözükür
    And siteyi kapatır

  @Sevval02
  Scenario: [TC-002] Kullanıcı "Notifications" bölümüne basar ve sayfayı açar
    When dashboard sayfasında "Notifications" bölümüne basar
    Then sayfaya erişim sağlanır
    And siteyi kapatır

  @Sevval03
  Scenario: [TC-003] "Notifications" View iconu çalıştırma
    When dashboard sayfasında "Notifications" bölümüne basar
    And View iconuna tıklar
    Then Onay butonu gelir ve onaylar
    And siteyi kapatır

  @Sevval04
  Scenario: [TC-004] Daha fazla bildirim görmek için diğer sayfaların çalışır olması
    When kullanıcı dashboard sayfasında courses butonuna tıklar ve geri dashboard’a döner
    And kullanıcı dashboard sayfasında support butonuna tıklar ve geri dashboard’a döner
    And kullanıcı dashboard sayfasında meetings butonuna tıklar ve geri dashboard’a döner
    And kullanıcı dashboard sayfasında comments butonuna tıklar ve geri dashboard’a döner
    And siteyi kapatır

  @Sevval05
  Scenario: [TC-005] Mark all iconunu çalıştırma
    When dashboard sayfasında "Notifications" bölümüne basar
    And Mark all notifications iconuna tıklar
    Then Okundu bildirimini alır
    And siteyi kapatır
