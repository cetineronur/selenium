Feature: US1004 Kullanici kayitlari update eder

  Scenario: Tc04 Kullanici IDHotel degeri verilen Email'i Update edebilmeli

    Given kullanici DBUtil ile HMC veri tabanina baglanir
    Then tHOTEL tablosunda IDHotel degeri 1019 olan kaydin Email bilgisini "cacav@gmail.com" yapar
