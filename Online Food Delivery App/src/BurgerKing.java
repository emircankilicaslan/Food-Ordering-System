import java.util.ArrayList;

public class BurgerKing extends Order{
    public static int rated1 = 0;
    public static double rating1 = 0.0;
   

    
        private String appetizer;
        private String additionalChoice;
        private String promoCode;
        private String dessert;

        public String getAppetizer() {
            return appetizer;
        }

        public String getAdditionalChoice() {
            return additionalChoice;
        }

        public String getPromoCode() {
            return promoCode;
        }

        public String getDessert() {
            return dessert;
        }
        public static double rating = 2;
        public static int rated = 1;
        
        public static String[] menuData = new String[] {"King Chicken","100 Years","Whooper"};
        public static String[] appetizerData = new String[] {"","Caesar Salad","Chips&Dips","Cheese Tray"};
        public static String[] dessertData = new String[] {"","Puding","Turkish Delight","Baklava"};
        public static String[] additionalChoiceData = new String[] {"","Chicken Nuggets","Onion Rings","Cheese Sticks"};
        
        
        
        
        

        public BurgerKing(int id, String brand, String bread, boolean spicy, String drink, boolean extraCheese, String size, String date, String menu, OrderWay orderway) {
            super(id, brand,  bread, spicy, drink, extraCheese, size, date, menu, orderway);
        }

        public BurgerKing(String appetizer, String additionalChoice, String promoCode, String dessert, int id, String brand, String bread, boolean spicy, String drink, boolean extraCheese, String size, String date, String menu, OrderWay orderway) {
            super(id, brand, bread, spicy, drink, extraCheese, size, date, menu, orderway);
            this.appetizer = appetizer;
            this.additionalChoice = additionalChoice;
            this.promoCode = promoCode;
            this.dessert = dessert;
        }

        

        @Override
        public void calcFinalPrice() {
            super.price = 0;
            switch(super.getMenu()){
                case "King Chicken":
                    super.price+=25;
                    break;
                case "100 Years":
                    super.price+=30;
                    break;
                case "Whooper":
                    super.price+=28;
                    break;
            }
            
            switch(appetizer){
                case "Caesar Salad":
                    super.price += 6;
                    break;
                case "Chips&Dips":
                    super.price += 8;
                    break;
                case "Cheese Tray":
                    super.price +=12;
                    break;
            }
            
            switch(dessert){
                case "Puding":
                    super.price += 9;
                    break;
                case "Turkish Delight":
                    super.price += 14;
                    break;
                case "Baklava":
                    super.price += 17;
                    break;
                }
            
            switch(additionalChoice){
                case "Chicken Nuggets":
                    super.price += 6;
                    break;
                case "Onion Rings":
                    super.price += 7;
                    break;
                case "Cheese Sticks":
                    super.price += 10;
                    break;
            
            } 
            
            switch(promoCode){
                case "BORA30":
                    super.price *= 0.7;
                    break;
                case "BEDIRHAN20":
                    super.price *= 0.8;
                    break;
                case "YIGIT10":
                    super.price *= 0.9;
                    break;
                case "BILKENTSENATO2ARALIK":
                    super.price *= 10;
                    break;
            }
            
        }
        
    
}