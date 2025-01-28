Feature: Catchylabs Para Transferi Uygulamasi Account Islemleri

  Background: Catchylabs hesabina giris
    Given Catchylabs hesabina giris yapilir.

  @account @check
  Scenario: TC005 - My Account sayfasi kontrolu
    When Basarili giris sonrasi Open Money Transfer butonuna tiklanir.
    Then My Account yazisi gorulur.

  @account @edit @positive
  Scenario: TC006 - Edit Account ozelliginin kontrolu
    Given Basarili giris sonrasi Open Money Transfer butonuna tiklanir.
    When Edit Account butonuna tiklanir.
    And Account name alanina abdullah yazilir.
    And Update butonuna tiklanir.
    Then Account adinin abdullah oldugu kontrol edilir.

  @account @edit @negative
  Scenario: TC007 - Edit Account ozelliginde bos deger eklenmesi
    Given Basarili giris sonrasi Open Money Transfer butonuna tiklanir.
    When Edit Account butonuna tiklanir.
    And Account name alani bos birakilir.
    Then Update butonunun pasif oldugu kontrol edilir.