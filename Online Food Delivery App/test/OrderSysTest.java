import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

/** Sipariş deposu: ekleme, arama, silme ve marka bazlı ortalama puan. OrderSys statik olduğundan her test kendi kayıtlarını temizler. */
class OrderSysTest {

    private static final OrderWay YOL = new OrderWay("Kart", 0, "20 dk");
    private final ArrayList<Integer> kullanilanIdler = new ArrayList<>();

    private Order siparis(int id, String marka, String musteri, double puan) {
        Order o = new Arbys("", "", "", id, marka, "Beyaz", false, "Kola", false, "Orta", "2026-11-13", "Beef'n Cheddar", YOL);
        o.CustomerName = musteri;
        o.Rating = puan;
        kullanilanIdler.add(id);
        return o;
    }

    @AfterEach
    void temizle() {
        kullanilanIdler.forEach(OrderSys::removeOrder);
        kullanilanIdler.clear();
    }

    @Test
    void ekleVeIdIleBul() {
        Order o = siparis(9001, "Arbys", "Ayşe", 4);
        assertTrue(OrderSys.addOrder(o));
        assertSame(o, OrderSys.searchOrder(9001));
    }

    @Test
    void ayniIdIkinciKezEklenemez() {
        assertTrue(OrderSys.addOrder(siparis(9002, "Arbys", "Ayşe", 4)));
        assertFalse(OrderSys.addOrder(siparis(9002, "Arbys", "Mehmet", 5)));
        assertEquals("Ayşe", OrderSys.searchOrder(9002).getCustomerName());
    }

    @Test
    void silinenSiparisBulunamaz_olmayaniSilmekFalseDoner() {
        OrderSys.addOrder(siparis(9003, "Arbys", "Ayşe", 4));
        assertTrue(OrderSys.removeOrder(9003));
        assertNull(OrderSys.searchOrder(9003));
        assertFalse(OrderSys.removeOrder(9003));
    }

    @Test
    void musteriAdiIleAra_bulunamazsaNullDoner() {
        Order o = siparis(9004, "Arbys", "Zeynep", 3);
        OrderSys.addOrder(o);
        assertSame(o, OrderSys.searchOrderByCustomerName("Zeynep"));
        assertNull(OrderSys.searchOrderByCustomerName("Kimse"));
        assertNull(OrderSys.searchOrderByCustomerName(null));
    }

    @Test
    void musteriAdiBosOlanSiparisAramayiBozmaz() {
        OrderSys.addOrder(siparis(9005, "Arbys", null, 0));
        OrderSys.addOrder(siparis(9006, "Arbys", "Can", 0));
        assertEquals(9006, OrderSys.searchOrderByCustomerName("Can").getId());
    }

    @Test
    void markaOrtalamasi_yalnizcaOMarkanin_siparisleriniKapsar() {
        OrderSys.addOrder(siparis(9007, "Zz Test Marka", "A", 4));
        OrderSys.addOrder(siparis(9008, "Zz Test Marka", "B", 2));
        OrderSys.addOrder(siparis(9009, "Baska Marka", "C", 5));
        assertEquals(3.0, OrderSys.calculateAverageRating("Zz Test Marka"), 1e-9);
    }

    @Test
    void siparisiOlmayanMarkaninOrtalamasiSifirdir() {
        assertEquals(0.0, OrderSys.calculateAverageRating("Hic Siparisi Olmayan Marka"), 1e-9);
    }

    @Test
    void puanVerme_butunMarkalardaKayitEder() {
        double[] once = {Arbys.rating, McDonalds.rating, BurgerKing.rating};
        int[] onceSayi = {Arbys.rated, McDonalds.rated, BurgerKing.rated};
        try {
            OrderSys.rate(5, "Arbys");
            OrderSys.rate(4, "McDonalds");
            OrderSys.rate(3, "Burger King");

            assertEquals(once[0] + 5, Arbys.rating, 1e-9);
            assertEquals(once[1] + 4, McDonalds.rating, 1e-9);
            assertEquals(once[2] + 3, BurgerKing.rating, 1e-9);
            assertEquals(onceSayi[0] + 1, Arbys.rated);
            assertEquals(onceSayi[1] + 1, McDonalds.rated);
            assertEquals(onceSayi[2] + 1, BurgerKing.rated);
        } finally {
            Arbys.rating = once[0]; McDonalds.rating = once[1]; BurgerKing.rating = once[2];
            Arbys.rated = onceSayi[0]; McDonalds.rated = onceSayi[1]; BurgerKing.rated = onceSayi[2];
        }
    }
}
