# Food Ordering System – Yemek Sipariş Sistemi (Java Swing)

![CI](https://github.com/emircankilicaslan/Food-Ordering-System/actions/workflows/ci.yml/badge.svg) ![Lisans: MIT](https://img.shields.io/badge/Lisans-MIT-green.svg)

Java ve nesne yönelimli programlama (OOP) ile geliştirilmiş, Swing arayüzlü masaüstü yemek sipariş uygulaması. Üç marka (Arby's, McDonald's, Burger King) için sipariş oluşturma, listeleme ve marka puanlama içerir.

## Özellikler
- Marka, ekmek, içecek, boyut, ekstra peynir ve acılık gibi seçeneklerle **yeni sipariş** oluşturma (`NewOrderFrame`)
- Sipariş listesi ve sipariş **detay ekranı** (`MainFrame`, `DisplayFrame`)
- Seçime göre **fiyat hesabı**: her marka kendi menü ve ek ürün fiyatlarını hesaplar
- Marka bazlı puan (rating) gösterimi

## OOP tasarımı
| Sınıf | Rol |
|---|---|
| `Order` (soyut) | Ortak sipariş alanları ve davranışlar |
| `Arbys`, `McDonalds`, `BurgerKing` | `Order`'dan türeyen, markaya özel `calcFinalPrice()` uygulayan sınıflar (kalıtım ve çok biçimlilik) |
| `OrderSys` | Siparişleri bellekte tutan ekleme/arama/silme işlemleri; `RateBrand` arayüzünü uygular |
| `OrderWay` | Teslimat şekli |
| `BurgericiousMain` | Giriş noktası |

## Çalıştırma
JDK 17+ gerekir (grafik arayüz için masaüstü ortamı).
```bash
cd "Online Food Delivery App/src"
javac -encoding UTF-8 -d out *.java
java -cp out BurgericiousMain
```

## Testler
```bash
mvn test      # 16 test (JUnit 5)
```
Maven yalnızca derleme ve test içindir; kaynak klasörü Eclipse düzeninde kaldı (`Online Food Delivery App/src`). Testler marka bazlı fiyat hesabını (menü, ekler, Burger King promosyon kodları) ve `OrderSys` deposunu (ekleme, yinelenen kimlik, arama, silme, marka ortalaması, puan verme) kapsar. CI her push ve pull request'te JDK 17 ve 21 ile `mvn verify` çalıştırır.

## Bilinen sınırlar
Siparişler yalnızca bellekte tutulur (uygulama kapanınca kaybolur); kimlik ve sipariş verisi için kalıcı depolama yoktur. Nesne yönelimli programlama ilkelerini uygulamak amacıyla geliştirilmiş bir masaüstü uygulamasıdır.


## Lisans

Bu proje [MIT Lisansı](LICENSE) ile paylaşılmaktadır.

---
*Geliştirici: Emircan Kılıçaslan*
