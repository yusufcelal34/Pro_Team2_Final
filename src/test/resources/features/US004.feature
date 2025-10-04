Feature: US004 Kullanici  sitenin islevlerinden yararlanmak icin siteye kayit olabilmeli


  Scenario: Kullanici ilgili url i yazdığında anasayfaya erişebilmeliu
    Given Kullanici "url" anasayfaya gider



  Scenario: Kullanici  ana sayfa barında register linkini gorup tiklayabilmeli
    Given Kullanici "url" anasayfaya gider
    And Kullanici senkronizasyon için 5 saniye bekler
    When Kullanici ana sayfa barinda register linkini gorur ve goruldugunu test eder
    And Kullanici senkronizasyon için 5 saniye bekler
    Then Kullanici  register linkini tiklar




  Scenario:Kullanici  register sayfasının sol bolumunde ilgili resmi goruyor olmali    //3
    Given Kullanici "url" anasayfaya gider
    When Kullanici ana sayfa barinda register linkini gorur ve goruldugunu test eder
    And Kullanici senkronizasyon için 3 saniye bekler
    Then Kullanici  register linkini tiklar
    And Kullanici senkronizasyon için 3 saniye bekler
    Then Kullanici register sayfasının sol bolumunde ilgili resmin gorunur oldugunu test eder


  Scenario: Kullanici register sayfasının sag bolumunde signup formunun gorunur ve aktif olduğunu test eder
    Given Kullanici "url" anasayfaya gider
    When Kullanici ana sayfa barinda register linkini gorur ve goruldugunu test eder
    And Kullanici senkronizasyon için 3 saniye bekler
    Then Kullanici  register linkini tiklar
    And Kullanici senkronizasyon için 3 saniye bekler
    And Kullanici register sayfasının sag bolumunde signup formunu gorur
    And Kullanici senkronizasyon için 3 saniye bekler
    And Kullanici email texboxını görür
    And  Kullanici email texboxına tıklar ve aktifligini test eder



  Scenario: Kullanici register sayfasında  signup butonunun  gorunur ve aktif olduğunu test eder
    Given Kullanici "url" anasayfaya gider
    When Kullanici ana sayfa barinda register linkini gorur ve goruldugunu test eder
    And Kullanici senkronizasyon için 3 saniye bekler
    Then Kullanici  register linkini tiklar
    And Kullanici senkronizasyon için 3 saniye bekler
    When signup butonuna tiklar



  Scenario:Kullanici geçerli bilgilerle giris yapabilmeli               //6
    Given Kullanici "url" anasayfaya gider
    When Kullanici ana sayfa barinda register linkini gorur ve goruldugunu test eder
    And Kullanici senkronizasyon için 3 saniye bekler
    Then Kullanici  register linkini tiklar
    And Kullanici senkronizasyon için 3 saniye bekler
    And Kullanıcı account type nı  student olarak secer ve tıklar
    And Kullanici senkronizasyon için 3 saniye bekler
    Then Kullanici  email olarak "gecerliEmail" girer
    And Kullanici senkronizasyon için 5 saniye bekler
    Then Kullanici  fullName olarak "gecerliFullName" girer
    And Kullanici senkronizasyon için 3 saniye bekler
    Then Kullanici  password olarak "gecerliPassword" girer
    And Kullanici senkronizasyon için 3 saniye bekler
    Then Kullanici  retype password olarak "gecerliRetypePassword" girer
    And Kullanici senkronizasyon için 10 saniye bekler
    Then time zone alaninda America/Nome  secenegini tiklar
    And Kullanici senkronizasyon için 10 saniye bekler
    And Kullanici I agree with terms & rules checbox ını tiklar
    And Kullanici senkronizasyon için 5 saniye bekler
    When signup butonuna tiklar
    And Kullanici senkronizasyon için 3 saniye bekler
    And basarili giris yapabildigini test eder



  Scenario: Kullanici gecersiz email ile giris yapamamali
    Given Kullanici "url" anasayfaya gider
    When Kullanici ana sayfa barinda register linkini gorur ve goruldugunu test eder
    And Kullanici senkronizasyon için 3 saniye bekler
    Then Kullanici  register linkini tiklar
    And Kullanici senkronizasyon için 3 saniye bekler
    And Kullanıcı account type nı  student olarak secer ve tıklar
    And Kullanici senkronizasyon için 3 saniye bekler
    Then email olarak "gecersizEmail" girer
    And Kullanici senkronizasyon için 3 saniye bekler
    Then Kullanici  fullName olarak "gecerliFullName" girer
    And Kullanici senkronizasyon için 3 saniye bekler
    Then Kullanici  password olarak "gecerliPassword" girer
    And Kullanici senkronizasyon için 3 saniye bekler
    Then Kullanici  retype password olarak "gecerliRetypePassword" girer
    And Kullanici senkronizasyon için 3 saniye bekler
    When Kullanici time zone alaninda America/Nome  secenegini tiklar
    And Kullanici senkronizasyon için 3 saniye bekler
    Then Kullanici I agree with terms & rules checbox ını tiklar
    And Kullanici senkronizasyon için 3 saniye bekler
    When signup butonuna tiklar
    And Kullanici senkronizasyon için 3 saniye bekler
    And  uyari mesaji aldigini  test eder





  Scenario:  Kullanici gecersiz password ile giris yapamamali     //8
    Given Kullanici "url" anasayfaya gider
    When Kullanici ana sayfa barinda register linkini gorur ve goruldugunu test eder
    And Kullanici senkronizasyon için 3 saniye bekler
    Then Kullanici  register linkini tiklar
    And Kullanici senkronizasyon için 3 saniye bekler
    And Kullanıcı account type nı  student olarak secer ve tıklar
    And Kullanici senkronizasyon için 3 saniye bekler
    Then Kullanici  email olarak "gecerliEmail" girer
    And Kullanici senkronizasyon için 3 saniye bekler
    Then Kullanici  fullName olarak "gecerliFullName" girer
    And Kullanici senkronizasyon için 3 saniye bekler
    Then password olarak "gecersizPassword" girer
    And Kullanici senkronizasyon için 3 saniye bekler
    Then Kullanici  retype password olarak "gecerliRetypePassword" girer
    When Kullanici time zone alaninda America/Nome  secenegini tiklar
    And Kullanici senkronizasyon için 3 saniye bekler
    And Kullanici I agree with terms & rules checbox ını tiklar
    And Kullanici senkronizasyon için 3 saniye bekler
    When signup butonuna tiklar
    And Kullanici senkronizasyon için 3 saniye bekler
    And  The password uyari mesaji aldigini  test eder




  Scenario:Kullanici email alanini bos biraktiginda uyarı mesaji almali
    Given Kullanici "url" anasayfaya gider
    When Kullanici ana sayfa barinda register linkini gorur ve goruldugunu test eder
    And Kullanici senkronizasyon için 3 saniye bekler
    Then Kullanici  register linkini tiklar
    And Kullanici senkronizasyon için 3 saniye bekler
    And Kullanıcı account type nı  student olarak secer ve tıklar
    And Kullanici senkronizasyon için 3 saniye bekler
    Then Kullanici  fullName olarak "gecerliFullName" girer
    And Kullanici senkronizasyon için 3 saniye bekler
    Then Kullanici  password olarak "gecerliPassword" girer
    And Kullanici senkronizasyon için 3 saniye bekler
    Then Kullanici  retype password olarak "gecerliRetypePassword" girer
    And Kullanici senkronizasyon için 3 saniye bekler
    When Kullanici time zone alaninda America/Nome  secenegini tiklar
    And Kullanici senkronizasyon için 3 saniye bekler
    When signup butonuna tiklar
    And Kullanici senkronizasyon için 5 saniye bekler
    And The email field is required uyari mesaji aldıgini test eder


  Scenario: Kullanici  full name  alanini bos biraktiginda uyari mesaji almali   //10
    Given Kullanici "url" anasayfaya gider
    When Kullanici ana sayfa barinda register linkini gorur ve goruldugunu test eder
    And Kullanici senkronizasyon için 3 saniye bekler
    Then Kullanici  register linkini tiklar
    And Kullanici senkronizasyon için 3 saniye bekler
    And Kullanıcı account type nı  student olarak secer ve tıklar
    And Kullanici senkronizasyon için 3 saniye bekler
    Then Kullanici  email olarak "gecerliEmail" girer
    And Kullanici senkronizasyon için 3 saniye bekler
    Then Kullanici  password olarak "gecerliPassword" girer
    And Kullanici senkronizasyon için 3 saniye bekler
    Then Kullanici  retype password olarak "gecerliRetypePassword" girer
    And Kullanici senkronizasyon için 3 saniye bekler
    When Kullanici time zone alaninda America/Nome  secenegini tiklar
    And Kullanici senkronizasyon için 3 saniye bekler
    And Kullanici I agree with terms & rules checbox ını tiklar
    And Kullanici senkronizasyon için 3 saniye bekler
    When signup butonuna tiklar
    And Kullanici senkronizasyon için 3 saniye bekler
    And The full name field is required uyari mesaji aldıgini test eder


  Scenario: Kullanici password  alanini bos biraktiginda uyari mesaji almali
    Given Kullanici "url" anasayfaya gider
    When Kullanici ana sayfa barinda register linkini gorur ve goruldugunu test eder
    And Kullanici senkronizasyon için 3 saniye bekler
    Then Kullanici  register linkini tiklar
    And Kullanici senkronizasyon için 3 saniye bekler
    And Kullanıcı account type nı  student olarak secer ve tıklar
    And Kullanici senkronizasyon için 3 saniye bekler
    Then Kullanici  email olarak "gecerliEmail" girer
    And Kullanici senkronizasyon için 3 saniye bekler
    Then Kullanici  fullName olarak "gecerliFullName" girer
    And Kullanici senkronizasyon için 3 saniye bekler
    Then Kullanici  retype password olarak "gecerliRetypePassword" girer
    And Kullanici senkronizasyon için 3 saniye bekler
    When Kullanici time zone alaninda America/Nome  secenegini tiklar
    And Kullanici senkronizasyon için 3 saniye bekler
    And Kullanici I agree with terms & rules checbox ını tiklar
    And Kullanici senkronizasyon için 3 saniye bekler
    When signup butonuna tiklar
    And Kullanici senkronizasyon için 3 saniye bekler
    Then The password field is required uyari mesaji aldıgini test eder



  Scenario: Kullanici retype password alanini bos biraktiginda uyari mesaji almali
    Given Kullanici "url" anasayfaya gider
    When Kullanici ana sayfa barinda register linkini gorur ve goruldugunu test eder
    And Kullanici senkronizasyon için 3 saniye bekler
    Then Kullanici  register linkini tiklar
    And Kullanici senkronizasyon için 3 saniye bekler
    And Kullanıcı account type nı  student olarak secer ve tıklar
    And Kullanici senkronizasyon için 3 saniye bekler
    Then Kullanici  email olarak "gecerliEmail" girer
    And Kullanici senkronizasyon için 3 saniye bekler
    Then Kullanici  fullName olarak "gecerliFullName" girer
    And Kullanici senkronizasyon için 3 saniye bekler
    Then Kullanici  password olarak "gecerliPassword" girer
    And Kullanici senkronizasyon için 3 saniye bekler
    When Kullanici time zone alaninda America/Nome  secenegini tiklar
    And Kullanici senkronizasyon için 3 saniye bekler
    And Kullanici I agree with terms & rules checbox ını tiklar
    And Kullanici senkronizasyon için 3 saniye bekler
    When signup butonuna tiklar
    And Kullanici senkronizasyon için 3 saniye bekler
    Then The password confirmation field is required uyari mesaji aldıgini test eder




  Scenario: Kullanici "I agree with terms & rules" alanini bos biraktiginda uyari mesaji almali
    Given Kullanici "url" anasayfaya gider
    When Kullanici ana sayfa barinda register linkini gorur ve goruldugunu test eder
    And Kullanici senkronizasyon için 3 saniye bekler
    Then Kullanici  register linkini tiklar
    And Kullanici senkronizasyon için 3 saniye bekler
    And Kullanıcı account type nı  student olarak secer ve tıklar
    And Kullanici senkronizasyon için 3 saniye bekler
    Then Kullanici  email olarak "gecerliEmail" girer
    And Kullanici senkronizasyon için 3 saniye bekler
    Then Kullanici  fullName olarak "gecerliFullName" girer
    And Kullanici senkronizasyon için 3 saniye bekler
    Then Kullanici  password olarak "gecerliPassword" girer
    And Kullanici senkronizasyon için 3 saniye bekler
    Then Kullanici  retype password olarak "gecerliRetypePassword" girer
    And Kullanici senkronizasyon için 3 saniye bekler
    When Kullanici time zone alaninda America/Nome  secenegini tiklar
    And Kullanici senkronizasyon için 3 saniye bekler
    When signup butonuna tiklar
    And Kullanici senkronizasyon için 3 saniye bekler
    Then The term field is required uyari mesaji aldıgini test eder



  Scenario:  Kullanici  signup butonuna tikladiginda  login sayfasina ulasabilmeli   //14
    Given Kullanici "url" anasayfaya gider
    When Kullanici ana sayfa barinda register linkini gorur ve goruldugunu test eder
    And Kullanici senkronizasyon için 3 saniye bekler
    Then Kullanici  register linkini tiklar
    And Kullanici senkronizasyon için 3 saniye bekler
    And Kullanıcı account type nı  student olarak secer ve tıklar
    And Kullanici senkronizasyon için 3 saniye bekler
    Then Kullanici  email olarak "gecerliEmail" girer
    And Kullanici senkronizasyon için 5 saniye bekler
    Then Kullanici  fullName olarak "gecerliFullName" girer
    And Kullanici senkronizasyon için 3 saniye bekler
    Then Kullanici  password olarak "gecerliPassword" girer
    And Kullanici senkronizasyon için 3 saniye bekler
    Then Kullanici  retype password olarak "gecerliRetypePassword" girer
    And Kullanici senkronizasyon için 6 saniye bekler
    When Kullanici time zone alaninda America/Nome  secenegini tiklar
    And Kullanici senkronizasyon için 10 saniye bekler
    And Kullanici I agree with terms & rules checbox ını tiklar
    And Kullanici senkronizasyon için 3 saniye bekler
    When signup butonuna tiklar
    And Kullanici senkronizasyon için 3 saniye bekler
    And basarili giris yapabildigini test eder
























