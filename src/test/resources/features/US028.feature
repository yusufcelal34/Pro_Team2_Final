
  Feature: US028 Kayıtlı bir kullanıcı olarak sitede teknik destek alabileceğim bir alan olmasını istiyorum

    Scenario: TC01 Kullanıcı dashboard sayfasındaki Support başlığı altında "New"
    linki görünebilirlik testi

      Given kullanici anasayfaya gider
      And login butonuna basar
      And senkronizasyon icin 2 saniye bekler
      Then email kutusuna "rilirip378@protonza.com" yazar
      And password kutusuna "Learn.1406" yazar
      Then login butonuna basarak giris yapar
      When support butonunu gorene kadar asagi iner
      Then support butonuna tiklar
      And senkronizasyon icin 2 saniye bekler
      And New linkinin gorunebildigini test eder

    Scenario: TC02 Kullanıcı dashboard sayfasındaki Support başlığı altında "Courses Support"
    linki görünebilirlik testi

      Given kullanici anasayfaya gider
      And login butonuna basar
      And senkronizasyon icin 2 saniye bekler
      Then email kutusuna "rilirip378@protonza.com" yazar
      And password kutusuna "Learn.1406" yazar
      Then login butonuna basarak giris yapar
      When support butonunu gorene kadar asagi iner
      Then support butonuna tiklar
      And senkronizasyon icin 2 saniye bekler
      And Courses support linkinin gorunebildigini test eder

    Scenario: TC03 Kullanıcı dashboard sayfasındaki Support başlığı altında "Tickets"
    linki görünebilirlik testi

      Given kullanici anasayfaya gider
      And login butonuna basar
      And senkronizasyon icin 2 saniye bekler
      Then email kutusuna "rilirip378@protonza.com" yazar
      And password kutusuna "Learn.1406" yazar
      Then login butonuna basarak giris yapar
      When support butonunu gorene kadar asagi iner
      Then support butonuna tiklar
      And senkronizasyon icin 2 saniye bekler
      And Tickets linkinin gorunebildigini test eder

    Scenario: TC04 New linkine tıkladıktan sonra bilgileri girerek bir destek mesajı gönderilebilmeli

      Given kullanici anasayfaya gider
      And login butonuna basar
      And senkronizasyon icin 2 saniye bekler
      Then email kutusuna "rilirip378@protonza.com" yazar
      And password kutusuna "Learn.1406" yazar
      Then login butonuna basarak giris yapar
      When support butonunu gorene kadar asagi iner
      Then support butonuna tiklar
      And senkronizasyon icin 2 saniye bekler
      And kullanıcı New linkine tıklar
      Then kullanıcı subject kısmına "aaaaa" yazar
      And kullanıcı type dropdown menusune tıklar
      And senkronizasyon icin 2 saniye bekler
      Then kullanıcı platform support a tıklar
      And senkronizasyon icin 3 saniye bekler
      Then kullanıcı department dropdown menusune tıklar
      And senkronizasyon icin 2 saniye bekler
      And kullanıcı content e tıklar
      And senkronizasyon icin 2 saniye bekler
      Then kullanıcı mesaj kısmına "bbbbb" yazar
      And kullanıcı Send Message butonuna tıklar
      Then open conservation 1 olarak güncellenir



    Scenario: TC05 Courses Support linkine basınca destek boardları görüntüleme testi

      Given kullanici anasayfaya gider
      And login butonuna basar
      And senkronizasyon icin 2 saniye bekler
      Then email kutusuna "rilirip378@protonza.com" yazar
      And password kutusuna "Learn.1406" yazar
      Then login butonuna basarak giris yapar
      When support butonunu gorene kadar asagi iner
      Then support butonuna tiklar
      And senkronizasyon icin 2 saniye bekler
      When kullanıcı Courses Support linkine tıklar
      Then Acılan sayfada Support summary göründüğünü test eder

    Scenario: TC06 Mesaj geçmişinde filtrelenen mesajların görünülebilirlik testi

      Given kullanici anasayfaya gider
      And login butonuna basar
      And senkronizasyon icin 2 saniye bekler
      Then email kutusuna "rilirip378@protonza.com" yazar
      And password kutusuna "Learn.1406" yazar
      Then login butonuna basarak giris yapar
      When support butonunu gorene kadar asagi iner
      Then support butonuna tiklar
      And senkronizasyon icin 2 saniye bekler
      When kullanıcı Courses Support linkine tıklar
      And kullanıcı message history altındaki mesajları görebildiğini test eder

      