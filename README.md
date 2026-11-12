# Food Ordering System – Yemek Sipariş Sistemi (Java Swing)

![CI](https://github.com/emircankilicaslan/Food-Ordering-System/actions/workflows/ci.yml/badge.svg)

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

## Bilinen sınırlar
Siparişler yalnızca bellekte tutulur (uygulama kapanınca kaybolur); otomatik test yoktur; CI her push'ta JDK 17 ve 21 ile derlemeyi doğrular. Nesne yönelimli programlama ilkelerini uygulamak amacıyla geliştirilmiş bir masaüstü uygulamasıdır.

---
*Geliştirici: Emircan Kılıçaslan*