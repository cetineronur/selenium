Feature: Bir kullanici olarak, sayfaya giris yapabilmek ve arama kutusuna yazdigim ürünün sonuclarini görebilmek istiyorum.

  Scenario: TC 01 Kullanici web sayfasina gidebilmeli
    Given Kullanici "url" ye gider
    And Siteye giris yapildigini gorur

  Scenario: TC02: Arama kutusuna bir urun adi yazip search yapabilmeli
    Given Kullanici Ana Sayfadaki Product linkine tiklar
    And Kullanici "ALL PRODUCTS" yazisini gorur
    And Kullanici SearchBox kutusunun gorunur oldugunu dogrular.
    Then Kullanici Arama girişine ürün adını girer ve arama düğmesine tıklar

  Scenario:TC03 Arama kutusuna yazdigi bir urunun sonuclarini gorebilmeli
    Given  Kullanici "SEARCHED PRODUCTS" yazisinin görünür olduğunu doğrular
    And Aramayla ilgili tüm ürünlerin görünür olduğunu doğrular
    Then Kullanici sayfayi kapatir