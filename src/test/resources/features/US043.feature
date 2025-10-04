@Sevval2
Feature: Kayıtlı kullanıcı olarak quiz geçmişimi ve katılmadığım quizleri görüntüleyebilmek istiyorum

  Background:
    Given kullanıcı sayfaya gider
    When üst login butonuna tıklar
    And e mail kutusuna EmailSevval yazar
    And password kutusuna PasswordSevval yazar
    And log in butonuna tıklar
    Then dashboard sayfasına erişir

  @TC_001
  Scenario: Quizzes menüsü altında linklerin görünürlüğü
    When kullanıcı dashboard sidebar menüsünü açar
    Then Quizzes başlığı altında "My Results" ve "Not Participated" linkleri görünür ve tıklanabilir olmalı

  @TC_002
  Scenario: My Results sayfasına erişim ve istatistiklerin görüntülenmesi
    Given kullanıcının daha önce katıldığı en az 1 quiz vardır
    When kullanıcı "My Results" linkine tıklar
    Then kullanıcının quiz istatistikleri görüntülenir
    And sayfa hatasız açılır

  @TC_003
  Scenario: My Results sayfasında filtreleme yapılabilmesi
    Given kullanıcının birden fazla quiz sonucu vardır
    When kullanıcı "My Results" sayfasını açar
    And filtre menüsünden tarih / skor aralığı / quiz adı seçer
    Then liste seçilen filtreye göre güncellenir
    And sadece uygun sonuçlar görüntülenir

  @TC_004
  Scenario: My Results içerisinde kullanıcıya ait işlemler
    Given kullanıcının quiz sonuçları mevcuttur
    When kullanıcı "My Results" sayfasında bir sonucu seçer
    And işlem butonuna (indir, detay, paylaş) tıklar
    Then ilgili işlem başarıyla gerçekleşir

  @TC_005
  Scenario: Not Participated sayfasına erişim
    Given kullanıcının hiç katılmadığı en az 1 quiz vardır
    When kullanıcı dashboard sidebar’dan "Not Participated" linkine tıklar
    Then kullanıcıya girmediği sınavların listesi açılır

  @TC_006
  Scenario: Not Participated sayfasında filtreleme yapılabilmesi
    Given kullanıcının birden fazla katılmadığı quiz vardır
    When kullanıcı "Not Participated" sayfasını açar
    And filtrelerden kategori / tarih / quiz tipi seçer
    Then liste seçilen kriterlere göre filtrelenir
    And sadece ilgili sınavlar görüntülenir

  @TC_007
  Scenario: Not Participated listesindeki işlemler
    Given kullanıcının en az 1 katılmadığı quiz vardır
    When kullanıcı "Not Participated" sayfasını açar
    And listeden bir quiz seçer
    And işlem butonuna (sınava katıl, detayları gör) tıklar
    Then kullanıcı ilgili işlemi gerçekleştirebilir