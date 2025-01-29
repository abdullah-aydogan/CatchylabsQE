Feature: Catchylabs Para Transferi Uygulamasi Para Yatirma Islemleri

  Background: Catchylabs hesabina giris
    Given Catchylabs hesabina giris yap.

  @addMoney @positive
  Scenario: TC008 - Kart ile para yatirma islemi ve kontrolu
    Given Basarili giris sonrasi Open Money Transfer butonuna tiklanir
    When Add Money butonuna tiklanir.
    And Card number alanina 1234 1234 1234 1234 degeri girilir.
    And Card holder alanina Vahide degeri girilir.
    And Expiry date alanina 10/26 degeri girilir.
    And CVV alanina 110 degeri girilir.
    And Amount alanina 100000 degeri girilir.
    And Add butonuna tiklanir.
    Then Para yatirma isleminin tamamlandigini kontrol et.

  @addMoney @negative
  Scenario: TC009 - Eksi tutar ile para yatirma islemi
    Given Basarili giris sonrasi Open Money Transfer butonuna tiklanir
    When Add Money butonuna tiklanir.
    And Card number alanina 1234 1234 1234 1234 degeri girilir.
    And Card holder alanina Vahide degeri girilir.
    And Expiry date alanina 10/26 degeri girilir.
    And CVV alanina 110 degeri girilir.
    And Amount alanina -33 degeri girilir.
    And Add butonuna tiklanir.
    Then Eksi tutar girildigine dair uyari mesajinin alindigini kontrol et.

  @addMoney @negative
  Scenario: TC010 - 0 - sıfır tutar ile para yatirma islemi
    Given Basarili giris sonrasi Open Money Transfer butonuna tiklanir
    When Add Money butonuna tiklanir.
    And Card number alanina 1234 1234 1234 1234 degeri girilir.
    And Card holder alanina Vahide degeri girilir.
    And Expiry date alanina 10/26 degeri girilir.
    And CVV alanina 110 degeri girilir.
    And Amount alanina 0 degeri girilir.
    And Add butonuna tiklanir.
    Then Tutar girilmedigine dair uyari mesajinin alindigini kontrol et.

  @addMoney @negative
  Scenario: TC011 - Yanlis formatta expiry date ile para yatirma islemi
    Given Basarili giris sonrasi Open Money Transfer butonuna tiklanir
    When Add Money butonuna tiklanir.
    And Card number alanina 1234 1234 1234 1234 degeri girilir.
    And Card holder alanina Vahide degeri girilir.
    And Expiry date alanina 88/88 degeri girilir.
    And CVV alanina tiklanir.
    Then Wrong date uyarisi alinir.