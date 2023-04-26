@PlaneTicketCase
  Feature: Plane Ticket End To End Test

    Scenario Outline: Ucak Bileti alarak Odeme Sayfasina kadar uctan uca test senaryosu
      Given   Kullanici ana sayfayi ziyaret eder
      Then    Kullanici ana sayfa container'ini goruntuler
      And     Kullanici ana sayfanin header'ini goruntuler
      When    Kullanici Ucak tab'ine tiklar
      Then    Kullanici Ucuz Ucak Bileti yazisini goruntuler
      When    Kullanici Nereden kismi icin "<departurePoint>", Nereye kismi icin "<arrivePoint>", Gidis Tarihi icin 28, Donus Tarihi icin 7 secimini yapar
      And     Kullanici Ucak Bileti Bul butonuna tiklar
      And     Kullanici ucus listesini goruntuler
      When    Kullanici listedeki birinci ucusu secer, Gidis icin varsa Ecofly ucusunu secer yoksa ucusun kendisini secer
      And     Kullanici listedeki birinci ucusu secer, Donus icin varsa Ecofly ucusunu secer yoksa ucusun kendisini secer
      Then    Odeme sayfasinin acildigi goruntulenir

      Examples:
      |departurePoint|arrivePoint|
      |   Ankara           |Antalya           |
