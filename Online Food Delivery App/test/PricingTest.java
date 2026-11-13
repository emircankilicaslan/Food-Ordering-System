import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/** Marka bazlı fiyat hesabı: menü, ek ürünler ve (Burger King için) promosyon kodu. */
class PricingTest {

    private static final OrderWay YOL = new OrderWay("Nakit", 5, "30 dk");

    private static Arbys arbys(String menu, String souce, String meat, String extra) {
        return new Arbys(souce, meat, extra, 1, "Arbys", "Beyaz", false, "Kola", false, "Orta", "2026-11-13", menu, YOL);
    }

    private static McDonalds mcdonalds(String menu, String souce, String dessert, String toy) {
        return new McDonalds(souce, dessert, toy, 2, "McDonalds", "Beyaz", false, "Kola", false, "Orta", "2026-11-13", menu, YOL);
    }

    private static BurgerKing burgerKing(String menu, String appetizer, String extra, String promo, String dessert) {
        return new BurgerKing(appetizer, extra, promo, dessert, 3, "Burger King", "Beyaz", false, "Kola", false, "Orta", "2026-11-13", menu, YOL);
    }

    // ---- Arby's

    @Test
    void arbys_sadeceMenu_menuFiyatiKadar() {
        Arbys o = arbys("Beef'n Cheddar", "", "", "");
        o.calcFinalPrice();
        assertEquals(35, o.getPrice(), 1e-9);
    }

    @Test
    void arbys_butunEklerToplanir() {
        Arbys o = arbys("Beef'n Cheddar", "Ranch", "Smoked Steak", "Tenders");
        o.calcFinalPrice();
        assertEquals(35 + 1 + 7 + 10, o.getPrice(), 1e-9);
    }

    @Test
    void arbys_yenidenHesaplamaFiyatiBirikmez() {
        Arbys o = arbys("Beef'n Curly", "Garlic", "Vegan", "Onion Rings");
        o.calcFinalPrice();
        double ilk = o.getPrice();
        o.calcFinalPrice();
        assertEquals(ilk, o.getPrice(), 1e-9);
        assertEquals(38 + 4 + 27 + 7, ilk, 1e-9);
    }

    // ---- McDonald's

    @Test
    void mcdonalds_butunEklerToplanir() {
        McDonalds o = mcdonalds("Big Mac", "Barbeque", "Sundae", "Wonder Woman");
        o.calcFinalPrice();
        assertEquals(27 + 2 + 7 + 7, o.getPrice(), 1e-9);
    }

    @Test
    void mcdonalds_eklerBosIseSadeceMenu() {
        McDonalds o = mcdonalds("Gamer", "", "", "");
        o.calcFinalPrice();
        assertEquals(37, o.getPrice(), 1e-9);
    }

    // ---- Burger King

    @Test
    void burgerKing_promosyonsuzToplam() {
        BurgerKing o = burgerKing("Whooper", "Caesar Salad", "Cheese Sticks", "", "Baklava");
        o.calcFinalPrice();
        assertEquals(28 + 6 + 17 + 10, o.getPrice(), 1e-9);
    }

    @Test
    void burgerKing_promosyonKodlariIndirimUygular() {
        BurgerKing o = burgerKing("Whooper", "Caesar Salad", "Cheese Sticks", "BORA30", "Baklava");
        o.calcFinalPrice();
        assertEquals(61 * 0.7, o.getPrice(), 1e-9);

        o = burgerKing("King Chicken", "", "", "YIGIT10", "");
        o.calcFinalPrice();
        assertEquals(25 * 0.9, o.getPrice(), 1e-9);
    }

    @Test
    void burgerKing_bilinmeyenPromosyonKoduIndirimYapmaz() {
        BurgerKing o = burgerKing("100 Years", "", "", "YOKBOYLEBIRKOD", "");
        o.calcFinalPrice();
        assertEquals(30, o.getPrice(), 1e-9);
    }
}
