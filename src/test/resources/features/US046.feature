Feature: Support Menüsü Fonksiyonları
Kullanıcı support menüsü üzerinden destek taleplerini yönetebilmeli.

Background:
  Given kullanıcı sayfaya gider
  When üst login butonuna tıklar
  And e mail kutusuna EmailSevval yazar
  And password kutusuna PasswordSevval yazar
  And log in butonuna tıklar
  Then dashboard sayfasına erişir

@TC_001
Scenario: Support menüsündeki linklerin görünürlüğü
When kullanıcı support menüsünü açar
Then "New" linki görünür ve aktif olmalı
And "Courses Support" linki görünür ve aktif olmalı
And "Tickets" linki görünür ve aktif olmalı

  @TC_002
Scenario: New linki ile destek isteği gönderme
When kullanıcı "New" linkine tıklar
And kullanıcı konu ve tip bilgilerini girer
And kullanıcı "Gönder" butonuna tıklar
Then yeni destek isteği başarıyla gönderilmeli

  @TC_003
Scenario: Courses Support linkinde destek özet boardlarını görüntüleme
When kullanıcı "Courses Support" linkine tıklar
Then destek özet boardları başlık, tarih ve durum bilgileriyle görünmeli

  @TC_004
Scenario: Mesaj geçmişi listesinde filtreleme
When kullanıcı mesaj geçmişi listesini açar
And kullanıcı tarih, durum veya konu kriteriyle filtreleme yapar
Then mesaj listesi filtreye uygun olarak güncellenmeli

  @TC_005
Scenario: Mesaj geçmişinde düzenleme
When kullanıcı mesaj geçmişinden bir mesaj seçer
And kullanıcı "Düzenle" butonuna tıklar
And kullanıcı mesajı günceller ve kaydeder
Then mesaj güncellenmeli ve listede yeni hali görünmeli

  @TC_006
Scenario: Açılan ticket üzerinde mesaj gönderme
When kullanıcı ticket listesinden açık bir ticket seçer
And kullanıcı yeni mesaj yazar ve gönderir
Then mesaj ilgili ticket altında görünmeli

  @TC_007
Scenario: Açık ticket’ı kapatma
When kullanıcı açık ticket detaylarını görüntüler
And kullanıcı "Kapat" butonuna tıklar
Then ticket kapanmalı ve durumu "Closed" olarak güncellenmeli

  @TC_008
Scenario: Tickets linkinde açılan ticketların listelenmesi
When kullanıcı "Tickets" linkine tıklar
Then ticket listesi görünmeli ve her ticket için Başlık, Güncellenme Tarihi, Departman ve Durum bilgileri yer almalı