Feature:  US031 Kayıtlı  bir kullanici olarak deshboard sayfamda profil bilgilerimi görüp yönetebileceğim bir alan olmasini istiyorum

  Scenario: Kullanici doğru instructor bilgileri ile login ulup deshboard sayfasını görüntüleyebilmeli TC001
    Given Kullanici "url" anasayfaya gider
    And Kullanici senkronizasyon için 5 saniye bekler
    When  ana sayfa barinda login linkine tiklar
    And Kullanici senkronizasyon için 5 saniye bekler
    Then  email alanina "insGecerliEmail" girer
    And password alanina "insGecerliPassword" girer
    When Login butonuna tiklar
    Then deshboard sayfasına ulasir



  Scenario: Kullanici deshboard sidebar da settings linkinin görünür ve aktif olduğunu test eder   //TC002
    Given Kullanici "url" anasayfaya gider
    And Kullanici senkronizasyon için 5 saniye bekler
    When  ana sayfa barinda login linkine tiklar
    And Kullanici senkronizasyon için 5 saniye bekler
    Then   email alanina "insGecerliEmail" girer
    And   password alanina "insGecerliPassword" girer
    When Login butonuna tiklar
    Then deshboard sayfasına ulasir
    And deshboard sidebar da Settings linkine tiklar
    Then basic information sayfasina ulaşir


  Scenario: Kullanici  basic information  basligi altindaki formu dogru bilgilerle doldurup diger sayfaya gecebilmeli  //TC003
    Given Kullanici "url" anasayfaya gider
    And Kullanici senkronizasyon için 5 saniye bekler
    When  ana sayfa barinda login linkine tiklar
    And Kullanici senkronizasyon için 5 saniye bekler
    Then  email alanina "insGecerliEmail" girer
    And password alanina "insGecerliPassword" girer
    When Login butonuna tiklar
    Then deshboard sayfasına ulasir
    And deshboard sidebar da Settings linkine tiklar
    Then basic information sayfasina ulaşir
    Then  basic information email alanina "insGecerliEmail" girer
    Then  basic information name alanina "insName" girer
    Then  basic information password alanina "insGecerliPassword" girer
    Then basic information retypepassword alanina "insRetypePassword" girer
    Then  basic information phone alanina "phone" girer
    Then language menuden english secenegini tiklar
    Then  basic information time zone menuden America/New_york secenegini tiklar
    Then next butonuna tiklar
    When images sayfasina ulasir


  Scenario:Kullanici basic information  basligi altindaki forma  gecersiz  email yazdiginda uyari mesaji almali  // TC004
    Given Kullanici "url" anasayfaya gider
    And Kullanici senkronizasyon için 5 saniye bekler
    When  ana sayfa barinda login linkine tiklar
    And Kullanici senkronizasyon için 5 saniye bekler
    Then  email alanina "insGecerliEmail" girer
    And password alanina "insGecerliPassword" girer
    When Login butonuna tiklar
    Then deshboard sayfasına ulasir
    And deshboard sidebar da Settings linkine tiklar
    Then basic information sayfasina ulaşir
    Then  basic information email olarak  "gecersizEmail" girer
    Then  basic information name alanina "insName" girer
    Then  basic information password alanina "insGecerliPassword" girer
    Then  basic information retypepassword alanina "insRetypePassword" girer
    Then  basic information phone alanina "phone" girer
    Then language menuden english secenegini tiklar
    Then  basic information time zone menuden America/New_york secenegini tiklar
    Then next butonuna tiklar
    When The email must be a valid email address  uyari mesajini alir


  Scenario:Kullanici basic information  basligi altindaki forma  gecersiz  password yazdiginda uyari mesaji almali   // TC005
    Given Kullanici "url" anasayfaya gider
    And Kullanici senkronizasyon için 5 saniye bekler
    When  ana sayfa barinda login linkine tiklar
    And Kullanici senkronizasyon için 5 saniye bekler
    Then  email alanina "insGecerliEmail" girer
    And password alanina "insGecerliPassword" girer
    When Login butonuna tiklar
    Then deshboard sayfasına ulasir
    And deshboard sidebar da Settings linkine tiklar
    Then basic information sayfasina ulaşir
    Then  basic information email alanina "insGecerliEmail" girer
    Then  basic information name alanina "insName" girer
    Then  basic information password olarak "gecersizPassword" girer
    Then  basic information retypepassword alanina "insRetypePassword" girer
    Then  basic information phone alanina "phone" girer
    Then language menuden english secenegini tiklar
    Then basic information  time zone menuden America/New_york secenegini tiklar
    Then next butonuna tiklar
    When The password confirmation does not match  uyari mesajini alir

  Scenario:Kullanici basic information  basligi altindaki formda email alanini bos bırakinca uyari mesaji almali  //TC006
    Given Kullanici "url" anasayfaya gider
    And Kullanici senkronizasyon için 5 saniye bekler
    When  ana sayfa barinda login linkine tiklar
    And Kullanici senkronizasyon için 5 saniye bekler
    Then email alanina "insGecerliEmail" girer
    And password alanina "insGecerliPassword" girer
    When Login butonuna tiklar
    Then deshboard sayfasına ulasir
    And deshboard sidebar da Settings linkine tiklar
    Then basic information sayfasina ulaşir
    And email alanini bos birakir
    Then  basic information name alanina "insName" girer
    Then  basic information password alanina "insGecerliPassword" girer
    Then basic information  retypepassword alanina "insRetypePassword" girer
    Then  basic information phone alanina "phone" girer
    Then language menuden english secenegini tiklar
    Then basic information  time zone menuden America/New_york secenegini tiklar
    Then next butonuna tiklar
    When The email field is required  uyari mesajini alir


  Scenario::Kullanici basic information  basligi altindaki formda name  alanini bos bırakinca uyari mesaji almali  //TC007
    Given Kullanici "url" anasayfaya gider
    And Kullanici senkronizasyon için 5 saniye bekler
    When  ana sayfa barinda login linkine tiklar
    And Kullanici senkronizasyon için 5 saniye bekler
    Then  email alanina "insGecerliEmail" girer
    And password alanina "insGecerliPassword" girer
    When Login butonuna tiklar
    Then deshboard sayfasına ulasir
    And deshboard sidebar da Settings linkine tiklar
    Then basic information sayfasina ulaşir
    Then  basic information email alanina "insGecerliEmail" girer
    And name alanini bos birakir
    Then  basic information password alanina "insGecerliPassword" girer
    Then  basic information retypepassword alanina "insRetypePassword" girer
    Then  basic information phone alanina "phone" girer
    Then language menuden english secenegini tiklar
    Then  basic information  time zone menuden America/New_york secenegini tiklar
    Then next butonuna tiklar
    When The full name field is required  uyari mesajini alir


  Scenario::Kullanici basic information  basligi altindaki formda password alanini bos bırakinca uyari mesaji almali   // TC008
    Given Kullanici "url" anasayfaya gider
    And Kullanici senkronizasyon için 5 saniye bekler
    When  ana sayfa barinda login linkine tiklar
    And Kullanici senkronizasyon için 5 saniye bekler
    Then  email alanina "insGecerliEmail" girer
    And password alanina "insGecerliPassword" girer
    When Login butonuna tiklar
    Then deshboard sayfasına ulasir
    And deshboard sidebar da Settings linkine tiklar
    Then basic information sayfasina ulaşir
    Then  basic information email alanina "insGecerliEmail" girer
    Then password alanini bos birakir
    Then  basic information retypepassword alanina "insRetypePassword" girer
    Then  basic information phone alanina "phone" girer
    Then language menuden english secenegini tiklar
    Then  basic information time zone menuden America/New_york secenegini tiklar
    Then next butonuna tiklar
    When The password field is required uyari mesajini alir


  Scenario::Kullanici basic information  basligi altindaki formda retype password alanini bos bırakinca uyari mesaji almali  //TC009
    Given Kullanici "url" anasayfaya gider
    And Kullanici senkronizasyon için 5 saniye bekler
    When  ana sayfa barinda login linkine tiklar
    And Kullanici senkronizasyon için 5 saniye bekler
    Then  email alanina "insGecerliEmail" girer
    And password alanina "insGecerliPassword" girer
    When Login butonuna tiklar
    Then deshboard sayfasına ulasir
    And deshboard sidebar da Settings linkine tiklar
    Then basic information sayfasina ulaşir
    Then  basic information email alanina "insGecerliEmail" girer
    Then  basic information name alanina "insName" girer
    Then  basic information password alanina "insGecerliPassword" girer
    And retypePassword alanini bos birakir
    Then  basic information phone alanina "phone" girer
    Then language menuden english secenegini tiklar
    Then  basic information time zone menuden America/New_york secenegini tiklar
    Then next butonuna tiklar
    When The password confirmation does not match uyari mesajini alir


  Scenario: Kullanici images basligi altındaki bilgileri doldurup diğer sayfaya geçebilmeli // TC010
    Given Kullanici "url" anasayfaya gider
    And Kullanici senkronizasyon için 5 saniye bekler
    When  ana sayfa barinda login linkine tiklar
    And Kullanici senkronizasyon için 5 saniye bekler
    Then  email alanina "insGecerliEmail" girer
    And password alanina "insGecerliPassword" girer
    When Login butonuna tiklar
    Then deshboard sayfasına ulasir
    And deshboard sidebar da Settings linkine tiklar
    Then basic information sayfasina ulaşir
    Then  basic information email alanina "insGecerliEmail" girer
    Then  basic information name alanina "insName" girer
    Then  basic information password alanina "insGecerliPassword" girer
    Then basic information retypepassword alanina "insRetypePassword" girer
    Then  basic information phone alanina "phone" girer
    Then language menuden english secenegini tiklar
    Then  basic information time zone menuden America/New_york secenegini tiklar
    Then next butonuna tiklar
    When images sayfasina ulasir
    Then profile cover linki altındaki yukarı ok ikonuna tiklar ve resim ekler
    And  image save butonuna basıp kaydeder
    Then next butonuna tiklar
    And about sayfasina ulasir


  Scenario: Kullanici about  basligi altındaki bilgileri doldurup diğer sayfaya geçebilmeli  //11
    Given Kullanici "url" anasayfaya gider
    And Kullanici senkronizasyon için 5 saniye bekler
    When  ana sayfa barinda login linkine tiklar
    And Kullanici senkronizasyon için 5 saniye bekler
    Then  email alanina "insGecerliEmail" girer
    And password alanina "insGecerliPassword" girer
    When Login butonuna tiklar
    Then deshboard sayfasına ulasir
    And deshboard sidebar da Settings linkine tiklar
    Then basic information sayfasina ulaşir
    Then  basic information email alanina "insGecerliEmail" girer
    Then  basic information name alanina "insName" girer
    Then  basic information password alanina "insGecerliPassword" girer
    Then basic information retypepassword alanina "insRetypePassword" girer
    Then  basic information phone alanina "phone" girer
    Then language menuden english secenegini tiklar
    Then  basic information time zone menuden America/New_york secenegini tiklar
    Then next butonuna tiklar
    When images sayfasina ulasir
    Then profile cover linki altındaki yukarı ok ikonuna tiklar ve resim ekler
    Then next butonuna tiklar
    And about sayfasina ulasir
    Then biography alanına "biography" yazar
    Then jobTitle  alanına "jobTitle" yazar
    Then next butonuna tiklar
    When education sayfasina ulasir


  Scenario: Kullanici education  basligi altında add education butonunu görür ve ekleme yapabilir //12
    Given Kullanici "url" anasayfaya gider
    And Kullanici senkronizasyon için 5 saniye bekler
    When  ana sayfa barinda login linkine tiklar
    And Kullanici senkronizasyon için 5 saniye bekler
    Then  email alanina "insGecerliEmail" girer
    And password alanina "insGecerliPassword" girer
    When Login butonuna tiklar
    Then deshboard sayfasına ulasir
    And deshboard sidebar da Settings linkine tiklar
    Then basic information sayfasina ulaşir
    Then  basic information email alanina "insGecerliEmail" girer
    Then  basic information name alanina "insName" girer
    Then  basic information password alanina "insGecerliPassword" girer
    Then basic information retypepassword alanina "insRetypePassword" girer
    Then  basic information phone alanina "phone" girer
    Then language menuden english secenegini tiklar
    Then  basic information time zone menuden America/New_york secenegini tiklar
    Then next butonuna tiklar
    When images sayfasina ulasir
    Then profile cover linki altındaki yukarı ok ikonuna tiklar ve resim ekler
    Then next butonuna tiklar
    And about sayfasina ulasir
    Then biography alanına "biography" yazar
    Then jobTitle  alanına "jobTitle" yazar
    Then next butonuna tiklar
    When education sayfasina ulasir
    And Add Education butonuna tiklar eğitim bilgisini girer
    Then education next butonuna tiklar




  Scenario: Kullanici education  basligi altında add education  texbox ını bos bıraktığında uyari mesaji almali  //13
    Given Kullanici "url" anasayfaya gider
    And Kullanici senkronizasyon için 5 saniye bekler
    When  ana sayfa barinda login linkine tiklar
    And Kullanici senkronizasyon için 5 saniye bekler
    Then  email alanina "insGecerliEmail" girer
    And password alanina "insGecerliPassword" girer
    When Login butonuna tiklar
    Then deshboard sayfasına ulasir
    And deshboard sidebar da Settings linkine tiklar
    Then basic information sayfasina ulaşir
    Then  basic information email alanina "insGecerliEmail" girer
    Then  basic information name alanina "insName" girer
    Then  basic information password alanina "insGecerliPassword" girer
    Then basic information retypepassword alanina "insRetypePassword" girer
    Then  basic information phone alanina "phone" girer
    Then language menuden english secenegini tiklar
    Then  basic information time zone menuden America/New_york secenegini tiklar
    Then next butonuna tiklar
    When images sayfasina ulasir
   Then profile cover linki altındaki yukarı ok ikonuna tiklar ve resim ekler
    Then next butonuna tiklar
    And about sayfasina ulasir
    Then biography alanına "biography" yazar
    Then jobTitle  alanına "jobTitle" yazar
    Then next butonuna tiklar
    When education sayfasina ulasir
    And Add Education butonunu bos birakir
    Then add education save  butonuna tiklar
    When The value field is required uyari mesajini alir

@cenn
  Scenario: Kullanici education  basligi altında eklenen eğitimleri düzenleyebilmeli  //14
    Given Kullanici "url" anasayfaya gider
    And Kullanici senkronizasyon için 5 saniye bekler
    When  ana sayfa barinda login linkine tiklar
    And Kullanici senkronizasyon için 5 saniye bekler
    Then  email alanina "insGecerliEmail" girer
    And password alanina "insGecerliPassword" girer
    When Login butonuna tiklar
    Then deshboard sayfasına ulasir
    And deshboard sidebar da Settings linkine tiklar
    Then basic information sayfasina ulaşir
    Then  basic information email alanina "insGecerliEmail" girer
    Then  basic information name alanina "insName" girer
    Then  basic information password alanina "insGecerliPassword" girer
    Then basic information retypepassword alanina "insRetypePassword" girer
    Then  basic information phone alanina "phone" girer
    Then language menuden english secenegini tiklar
    Then  basic information time zone menuden America/New_york secenegini tiklar
    Then next butonuna tiklar
    When images sayfasina ulasir
    Then profile cover linki altındaki yukarı ok ikonuna tiklar ve resim ekler
    Then next butonuna tiklar
    And about sayfasina ulasir
    Then biography alanına "biography" yazar
    Then jobTitle  alanına "jobTitle" yazar
    Then next butonuna tiklar
    When education sayfasina ulasir
    And Add Education butonuna tiklar eğitim bilgisini girer
    Then add education save  butonuna tiklar
    And ekranın sagında uc noktaya tiklar
    And edit yazısına tiklar ve düzenleme yapar
    Then save butonuna basıp kaydeder


  Scenario:Kullanici education  basligi altında eklenen eğitimleri siebilmeli  //15
    Given Kullanici "url" anasayfaya gider
    And Kullanici senkronizasyon için 5 saniye bekler
    When  ana sayfa barinda login linkine tiklar
    And Kullanici senkronizasyon için 5 saniye bekler
    Then  email alanina "insGecerliEmail" girer
    And password alanina "insGecerliPassword" girer
    When Login butonuna tiklar
    Then deshboard sayfasına ulasir
    And deshboard sidebar da Settings linkine tiklar
    Then basic information sayfasina ulaşir
    Then  basic information email alanina "insGecerliEmail" girer
    Then  basic information name alanina "insName" girer
    Then  basic information password alanina "insGecerliPassword" girer
    Then basic information retypepassword alanina "insRetypePassword" girer
    Then  basic information phone alanina "phone" girer
    Then language menuden english secenegini tiklar
    Then  basic information time zone menuden America/New_york secenegini tiklar
    Then next butonuna tiklar
    When images sayfasina ulasir
    Then profile cover linki altındaki yukarı ok ikonuna tiklar ve resim ekler
    Then next butonuna tiklar
    And about sayfasina ulasir
    Then biography alanına "biography" yazar
    Then jobTitle  alanına "jobTitle" yazar
    Then next butonuna tiklar
    When education sayfasina ulasir
    And Add Education butonuna tiklar eğitim bilgisini girer
    Then save butonuna basıp kaydeder
    And ekranın sagında uc noktaya tiklar
    Then delete yazısına tiklar
    And cıkan delete ikonuna tiklar ve siler
    Then next butonuna tiklar
    When experiences sayfasina ulasir


  Scenario:Kullanici experiences  basligi altında add education butonunu görür ve ekleme yapabilir   //16
    Given Kullanici "url" anasayfaya gider
    And Kullanici senkronizasyon için 5 saniye bekler
    When  ana sayfa barinda login linkine tiklar
    And Kullanici senkronizasyon için 5 saniye bekler
    Then  email alanina "insGecerliEmail" girer
    And password alanina "insGecerliPassword" girer
    When Login butonuna tiklar
    Then deshboard sayfasına ulasir
    And deshboard sidebar da Settings linkine tiklar
   And experiences linkine tiklar
    When experiences sayfasina ulasir
    And Add experiences butonuna tiklar deneyim bilgisi girer
    Then save butonuna basıp kaydeder





  Scenario: Kullanici  experiences   basligi altında add education  texbox ını bos bıraktığında uyari mesaji almali  //17
    Given Kullanici "url" anasayfaya gider
    And Kullanici senkronizasyon için 5 saniye bekler
    When  ana sayfa barinda login linkine tiklar
    And Kullanici senkronizasyon için 5 saniye bekler
    Then  email alanina "insGecerliEmail" girer
    And password alanina "insGecerliPassword" girer
    When Login butonuna tiklar
    Then deshboard sayfasına ulasir
    And deshboard sidebar da Settings linkine tiklar
    And experiences linkine tiklar
    When experiences sayfasina ulasir
    And Add experiences alanını bos birakir
    Then save butonuna basıp kaydeder
    When The value field is required uyari mesajini alir




  Scenario: Kullanici  experiences  basligi altında eklenen deneyileri düzenleyebilmeli  //18
    Given Kullanici "url" anasayfaya gider
    And Kullanici senkronizasyon için 5 saniye bekler
    When  ana sayfa barinda login linkine tiklar
    And Kullanici senkronizasyon için 5 saniye bekler
    Then  email alanina "insGecerliEmail" girer
    And password alanina "insGecerliPassword" girer
    When Login butonuna tiklar
    Then deshboard sayfasına ulasir
    And deshboard sidebar da Settings linkine tiklar
    And experiences linkine tiklar
    When experiences sayfasina ulasir
    And ekranın sagında uc noktaya tiklar
    And edit yazısına tiklar ve düzenleme yapar
    Then save butonuna basıp kaydeder


  Scenario:Kullanici  experiences   basligi altında eklenen deneyimleri siebilmeli  //19
    Given Kullanici "url" anasayfaya gider
    And Kullanici senkronizasyon için 5 saniye bekler
    When  ana sayfa barinda login linkine tiklar
    And Kullanici senkronizasyon için 5 saniye bekler
    Then  email alanina "insGecerliEmail" girer
    And password alanina "insGecerliPassword" girer
    When Login butonuna tiklar
    Then deshboard sayfasına ulasir
    And deshboard sidebar da Settings linkine tiklar
    And experiences linkine tiklar
    When experiences sayfasina ulasir
    And ekranın sagında uc noktaya tiklar
    Then delete yazısına tiklar
    And cıkan delete ikonuna tiklar ve siler
    Then next butonuna tiklar


  Scenario: Kullanici skills basligi altinda yeni skills ekleyip diğer sayfaya gecebilmeli  //20
    Given Kullanici "url" anasayfaya gider
    And Kullanici senkronizasyon için 5 saniye bekler
    When  ana sayfa barinda login linkine tiklar
    And Kullanici senkronizasyon için 5 saniye bekler
    Then  email alanina "insGecerliEmail" girer
    And password alanina "insGecerliPassword" girer
    When Login butonuna tiklar
    Then deshboard sayfasına ulasir
    And deshboard sidebar da Settings linkine tiklar
    And skill topicks linkine tiklar
    Then SDET textini secer
    Then next butonuna tiklar

  Scenario:  Kullanici identity&financial basligi altinda tanımlama yaparak  diğer sayfaya gecebilmeli //21
    Given Kullanici "url" anasayfaya gider
    And Kullanici senkronizasyon için 5 saniye bekler
    When  ana sayfa barinda login linkine tiklar
    And Kullanici senkronizasyon için 5 saniye bekler
    Then  email alanina "insGecerliEmail" girer
    And password alanina "insGecerliPassword" girer
    When Login butonuna tiklar
    Then deshboard sayfasına ulasir
    And deshboard sidebar da Settings linkine tiklar
    And identity&financial linkine tiklar
    And account holder alanini doldurur
    And account ID alanini doldurur
    Then next butonuna tiklar



  Scenario: Kullanici zoom API basligi altında  ilgili alanlari doldurarak zoom hesabi tanımlayabilmeli  //22
    Given Kullanici "url" anasayfaya gider
    And Kullanici senkronizasyon için 5 saniye bekler
    When  ana sayfa barinda login linkine tiklar
    And Kullanici senkronizasyon için 5 saniye bekler
    Then  email alanina "insGecerliEmail" girer
    And password alanina "insGecerliPassword" girer
    When Login butonuna tiklar
    Then deshboard sayfasına ulasir
    And deshboard sidebar da Settings linkine tiklar
    And  zoom API linkine tiklar
    And Zoom Client ID alanini doldurur
    And Zoom Client Secret alanini doldurur
    Then Zoom Account ID alanini doldurur
    Then next butonuna tiklar


  Scenario: Kullanici extra information başlığı altında ilgili yerleri doldurup profil düzenleme işini yapabilmeli  //23
    Given Kullanici "url" anasayfaya gider
    And Kullanici senkronizasyon için 5 saniye bekler
    When  ana sayfa barinda login linkine tiklar
    And Kullanici senkronizasyon için 5 saniye bekler
    Then  email alanina "insGecerliEmail" girer
    And password alanina "insGecerliPassword" girer
    When Login butonuna tiklar
    Then deshboard sayfasına ulasir
    And deshboard sidebar da Settings linkine tiklar
    And  extra information linkine tiklar
    And female checkbox ini secer
    Then Age olarak "45" girer
    And meeting type olarak online secer
    When  extra information save butonuna basıp kaydeder


  Scenario:Kullanici olusturduğu hesabi silebilmek için delete account butonunun görünür ve aktif olduğunu test eder //24
    Given Kullanici "url" anasayfaya gider
    And Kullanici senkronizasyon için 5 saniye bekler
    When  ana sayfa barinda login linkine tiklar
    And Kullanici senkronizasyon için 5 saniye bekler
    Then  email alanina "insGecerliEmail" girer
    And password alanina "insGecerliPassword" girer
    When Login butonuna tiklar
    Then deshboard sayfasına ulasir
    And deshboard sidebar da Settings linkine tiklar
    And  extra information linkine tiklar
    And female checkbox ini secer
    Then Age olarak "45" girer
    And meeting type olarak online secer
  When  extra information save butonuna basıp kaydeder
    When delete account butonuna basar ve hesabi siler


