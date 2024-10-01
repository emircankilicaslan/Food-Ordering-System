
import java.util.ArrayList;

public abstract class Order {
    protected int id;
    public String brand;
    protected double price;
    protected String bread;
    protected boolean spicy;
    public String drink;
    protected boolean extraCheese;
    protected String size;
    protected String date;
    protected String menu;
    public OrderWay orderway;
    public String CustomerName;
    public double Rating;
    
    public Order(){}

    public Order(int id, String brand, String bread, boolean spicy, String drink, boolean extraCheese, String size, String date, String menu, OrderWay orderway) {
        this.id = id;
        this.brand = brand;
        this.bread = bread;
        this.spicy = spicy;
        this.drink = drink;
        this.extraCheese = extraCheese;
        this.size = size;
        this.date = date;
        this.menu = menu;
        this.orderway = orderway;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBread() {
        return bread;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public void setBread(String bread) {
        this.bread = bread;
    }

    public boolean isSpicy() {
        return spicy;
    }

    public void setSpicy(boolean spicy) {
        this.spicy = spicy;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public boolean isExtraCheese() {
        return extraCheese;
    }

    public void setExtraCheese(boolean extraCheese) {
        this.extraCheese = extraCheese;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }


    public OrderWay getOrderway() {
        return orderway;
    }

    public void setOrderway(OrderWay orderway) {
        this.orderway = orderway;
    }
    
    public abstract void calcFinalPrice();

	public Object getCustomerName() {
		// TODO Auto-generated method stub
		return null;
	}

	public double getRating() {
		// TODO Auto-generated method stub
		return 0;
	}
        
}