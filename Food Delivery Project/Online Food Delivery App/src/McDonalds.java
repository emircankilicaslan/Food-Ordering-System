import java.util.ArrayList;

public class McDonalds extends Order{
   private String souce;
   private String dessert;
   private String toysChoice;
   public static double rating = 3;
   public static int rated = 1;
   
   public static String[] menuData = new String[] {"Big Mac","Gamer","Mc Chicken"};
   public static String[] souceData = new String[] {"","Ranch","Ketchup","Barbeque"};
   public static String[] dessertData = new String[] {"","Vanilla Milkshake","Sundae","Fluffy Donut"};
   public static String[] toysChoiceData = new String[] {"","Action-Man","Wonder Woman","Unicorn"};

    public String getSouce() {
        return souce;
    }

    public String getDessert() {
        return dessert;
    }

    public String getToysChoice() {
        return toysChoice;
    }
   
   
   

    public McDonalds(int id, String brand, double firstPrice, String bread, boolean spicy, String drink, boolean extraCheese, String size, String date, String menu, OrderWay orderway) {
        super(id, brand, bread, spicy, drink, extraCheese, size, date, menu, orderway);
    }

    public McDonalds(String souce, String dessert, String toysChoice, int id, String brand, String bread, boolean spicy, String drink, boolean extraCheese, String size, String date, String menu, OrderWay orderway) {
        super(id, brand, bread, spicy, drink, extraCheese, size, date, menu, orderway);
        this.souce = souce;
        this.dessert = dessert;
        this.toysChoice = toysChoice;
    }

   

    public void calcFinalPrice() {
        super.price = 0;
        switch(super.getMenu()){
            case "Big Mac":
                super.price+=27;
                break;
            case "Gamer":
                super.price+=37;
                break;
            case "Mc Chicken":
                super.price+=22;
                break;
        }
       
        switch(souce){
            case "Ranch":
                super.price += 1;
                break;
            case "Ketchup":
                super.price += 1;
                break;
            case "Barbeque":
                super.price +=2;
                break;
        }
      
        switch(dessert){
            case  "Vanilla Milkshake":
                super.price += 11;
                break;
            case "Sundae":
                super.price += 7;
                break;
            case "Fluffy Donut":
                super.price += 5;
                break;
            }
       
         switch(toysChoice){
            case "Action-Man":
                super.price += 4;
                break;
            case "Wonder Woman":
                super.price += 7;
                break;
            case "Unicorn":
                super.price += 6;
                break;
        
        } 
   
   
}}
