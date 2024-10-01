import java.util.ArrayList;

import java.util.ArrayList;

public class Arbys extends Order {
    private String souce;
    private String meatType;
    private String additionalChoice;
    public static double rating = 4.5;
    public static int rated = 1;

    public static String[] menuData = new String[]{"Beef'n Cheddar", "Arbys #StayAtHome", "Beef'n Curly"};
    public static String[] souceData = new String[]{"", "Ranch", "Buffalo", "Garlic"};
    public static String[] meatTypeData = new String[]{"", "Steak", "Smoked Steak", "Vegan"};
    public static String[] additionalChoiceData = new String[]{"", "Ice Cream", "Onion Rings", "Tenders"};

    public String getSouce() {
        return souce;
    }

    public String getMeatType() {
        return meatType;
    }

    public String getAdditionalChoice() {
        return additionalChoice;
    }

    public Arbys(int id, String brand, String bread, boolean spicy, String drink, boolean extraCheese, String size, String date, String menu, OrderWay orderway) {
        super(id, brand, bread, spicy, drink, extraCheese, size, date, menu, orderway);
    }

    public Arbys(String souce, String meatType, String additionalChoice, int id, String brand, String bread, boolean spicy, String drink, boolean extraCheese, String size, String date, String menu, OrderWay orderway) {
        super(id, brand, bread, spicy, drink, extraCheese, size, date, menu, orderway);
        this.souce = souce;
        this.meatType = meatType;
        this.additionalChoice = additionalChoice;
    }

    @Override
    public void calcFinalPrice() {
        super.price = 0;
        switch (super.getMenu()) {
            case "Beef'n Cheddar":
                super.price += 35;
                break;
            case "Arbys #StayAtHome":
                super.price += 40;
                break;
            case "Beef'n Curly":
                super.price += 38;
                break;
        }

        switch (souce) {
            case "Ranch":
                super.price += 1;
                break;
            case "Buffalo":
                super.price += 2;
                break;
            case "Garlic":
                super.price += 4;
                break;
        }

        switch (meatType) {
            case "Steak":
                super.price += 0;
                break;
            case "Smoked Steak":
                super.price += 7;
                break;
            case "Vegan":
                super.price += 27;
                break;
        }

        switch (additionalChoice) {
            case "Ice Cream":
                super.price += 6;
                break;
            case "Onion Rings":
                super.price += 7;
                break;
            case "Tenders":
                super.price += 10;
                break;
        }
    }
}
