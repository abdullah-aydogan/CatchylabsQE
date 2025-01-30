# Catchylabs - Para Transferi Uygulaması Test Projesi

## 📌 Proje Açıklaması

Bu proje, **Cucumber** ve **Java** kullanarak otomasyon testleri yazmak için oluşturulmuştur. Proje, **TestNG** ve **Selenium WebDriver** gibi popüler test araçlarını içermektedir.

## 📂 Proje Dizini

```
├── src 
│   ├── test
│   │   ├── java
│   │   │   ├── features  # Cucumber .feature dosyaları
│   │   │   ├── pageObjects  # Sayfa sınıfları ve nesneler
│   │   │   ├── stepDefinitions  # Adım tanımları
│   │   │   ├── testComponents  # BaseTest ve Hooks sınıfları
│   │   │   ├── testRunners  # Test çalıştırıcıları
│   │   ├── resources
│   │   │   ├── extent.properties # ExtentReport dosyası
│   │   │   ├── globalData.properties # Data dosyası
│   │   │   ├── logback.xml # Log kaydı için konfigürasyon
├── pom.xml  # Maven bağımlılıkları
├── README.md  # Proje dökümantasyonu
```

## 🚀 Kurulum

### 1️⃣ Bağımlılıkları Yükleyin

Proje **Maven** kullanmaktadır. Gerekli bağımlılıkları yüklemek için:

```
mvn clean install
```

### 2️⃣ Testleri Çalıştırın

Testleri çalıştırmak için aşağıdaki komutu kullanabilirsiniz:

```
mvn test
```

Alternatif olarak, belirli bir **Runner Class** çalıştırabilirsiniz:

```
mvn test -Dtest=RunnerClassName
```

Sadece belirli etiketlere sahip testleri çalıştırabilirsiniz:

```
mvn test -Dcucumber.filter.tags="@tagName"
```

Sadece belirli tarayıcıda testleri çalıştırabilirsiniz:

```
mvn test -Dbrowser=chrome
```

## 🔧 Kullanılan Teknolojiler

- **Java**
- **Cucumber**
- **TestNG**
- **ExtentReport**
- **Selenium WebDriver**
- **Maven**

## 📜 Örnek Feature Dosyası

```gherkin
  Feature: Catchylabs Para Transferi Uygulamasi Account Islemleri

  Background: Catchylabs hesabina giris
    Given Catchylabs hesabina giris yapilir.

  @account @check
  Scenario: TC005 - My Account sayfasi kontrolu
    When Basarili giris sonrasi Open Money Transfer butonuna tiklanir.
    Then My Account yazisi gorulur.
```

## 💡 Faydalı Kaynaklar

- [Cucumber Resmi Dokümantasyon](https://cucumber.io/docs)
- [Selenium WebDriver](https://www.selenium.dev/documentation/)
- [TestNG](https://testng.org/)

## 📞 Destek

Herhangi bir sorun yaşarsanız, lütfen bir **issue** oluşturun veya proje ekibiyle iletişime geçin.

