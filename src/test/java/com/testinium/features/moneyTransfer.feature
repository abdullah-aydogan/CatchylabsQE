Feature: Catchylabs Para Transferi Uygulamasi Para Transferi Islemleri

  Background: Catchylabs hesabina giris
    Given Catchylabs hesabina girilir

  @moneyTransfer @positive
  Scenario: TC012 - Varsayilan alici hesaba para transferi islemi
    Given Open Money Transfer butonuna tiklanir
    When Transfer Money butonuna tiklanir
    And Amount alanina 4000 degeri girilir
    And Send butonuna tiklanir
    Then Para transferi isleminin tamamlandigini kontrol et

  @moneyTransfer @negative
  Scenario: TC013 - Varsayilan alici hesaba tutar girmeden para transferi islemi
    Given Open Money Transfer butonuna tiklanir
    When Transfer Money butonuna tiklanir
    And Amount alani bos birakilir
    Then Send butonunun tiklanamadigi kontrol edilir

  @moneyTransfer @negative
  Scenario: TC014 - Varsayilan alici hesaba 0 - sifir tutar ile para transferi islemi
    Given Open Money Transfer butonuna tiklanir
    When Transfer Money butonuna tiklanir
    And Amount alanina 0 degeri girilir
    And Send butonuna tiklanir
    Then Para transferi isleminin yapilamadigini kontrol et

  @moneyTransfer @negative
  Scenario: TC015 - Varsayilan alici hesaba eksi tutar ile para transferi islemi
    Given Open Money Transfer butonuna tiklanir
    When Transfer Money butonuna tiklanir
    And Amount alanina -50000 degeri girilir
    And Send butonuna tiklanir
    Then Para transferi isleminin yapilamadigini kontrol et

  @moneyTransfer @negative
  Scenario: TC016 - Varsayilan alici hesaba bakiyeden fazla tutar ile para transferi islemi
    Given Open Money Transfer butonuna tiklanir
    When Bakiye bilgisi alinir
    And Transfer Money butonuna tiklanir
    And Amount alanina bakiyeden fazla deger girilir
    And Send butonuna tiklanir
    Then Para transferi isleminin yapilamadigini kontrol et

  @moneyTransfer @positive
  Scenario: TC017 - Baska bir hesaba para transferi islemi
    Given Open Money Transfer butonuna tiklanir
    When Transfer Money butonuna tiklanir
    And Receiver account alaninda Testinium-4 secilir
    And Amount alanina 39000 degeri girilir
    And Send butonuna tiklanir
    Then Para transferi isleminin yapildigini kontrol et