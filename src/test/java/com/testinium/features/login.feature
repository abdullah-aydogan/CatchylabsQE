Feature: Catchylabs Para Transferi Uygulamasi Giris Islemleri

  Background: Catchylabs giris ekrani
    Given Catchylabs giris ekranina gidilir.

  @login @positive
  Scenario: Gecerli kullanici adi ve sifre ile uygulamaya giris yapma
    Given Username alanina abdullah.aydogan yazilir.
    And Password alanina @bdullahOtok@r05 yazilir.
    When Login butonuna tıklanir.
    Then Giris isleminin basarili oldugu kontrol edilir.

  @login @negative
  Scenario: Gecersiz kullanici adi ve gecerli sifre ile uygulamaya giris yapma
    Given Username alanina abdullah.abdullah yazilir.
    And Password alanina @bdullahOtok@r05 yazilir.
    When Login butonuna tıklanir.
    Then Giris isleminin basarisiz oldugu kontrol edilir.

  @login @negative
  Scenario: Gecerli kullanici adi ve gecersiz sifre ile uygulamaya giris yapma
    Given Username alanina abdullah.aydogan yazilir.
    And Password alanina @bdullahOtok@r yazilir.
    When Login butonuna tıklanir.
    Then Giris isleminin basarisiz oldugu kontrol edilir.

  @login @negative
  Scenario: Gecersiz kullanici adi ve sifre ile uygulamaya giris yapma
    Given Username alanina abdullah.labs yazilir.
    And Password alanina @bdullah yazilir.
    When Login butonuna tıklanir.
    Then Giris isleminin basarisiz oldugu kontrol edilir.