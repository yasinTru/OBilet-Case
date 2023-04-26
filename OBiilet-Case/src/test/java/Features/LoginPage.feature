@LoginCase
Feature: Ana Sayfa ve Login sayfasi islemleri
  @Home
    Scenario Outline: Ana Sayfanın Yuklenmesinin Kontrolu, Login sayfasinda basarili uyelik acilmasi
      Given   Kullanici ana sayfayi ziyaret eder
      Then    Kullanici ana sayfa container'ini goruntuler
      And     Kullanici ana sayfanin header'ini goruntuler
      When    Kullanici Uye Girisi butonuna tiklar
      Then    Kullanici "<popUp_header>" Pop-up'ini goruntuler
      When    Kullanici Uye Ol butonuna tiklar
      Then    Kullanici "<empty_mail_msg>" ve "<empty_password_msg>" mesajlarini goruntuler
      When    Kullanici e-posta adresine "<valid_mail>" yazar
      And     Kullanici sifre alanina "<valid_password>" yazar
      And     Kullanici Pop-up icindeki Uye Ol butona tiklar
      Then    Uyeligin basarili olarak gerceklestigi kontrol edilir

    Examples:
      |popUp_header|empty_mail_msg|empty_password_msg|valid_mail|valid_password|
      |Üye Girişi|  E-mail adresi boş bırakılamaz    |Şifre boş bırakılamaz|ikincimail@gmail.com            |12345Sifre         |


