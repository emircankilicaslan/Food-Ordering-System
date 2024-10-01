import java.util.ArrayList;

public class OrderSys implements RateBrand {
    private static ArrayList<Order> orderList = new ArrayList<>();

    public static boolean addOrder(Order order) {
        if (searchOrder(order.getId()) == null) {
            orderList.add(order);
            return true;
        } else {
            return false;
        }
    }

    private static Order searchOrder(int id) {
        for (Order order : orderList) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }

    public static void displayOrdersByBrand(String brand) {
        for (Order order : orderList) {
            if (order.getBrand().equals(brand)) {
                System.out.println(order);
            }
        }
    }

    public static Order searchOrderByCustomerName(String customerName) {
        for (Order order : orderList) {
            if (order.getCustomerName().equals(customerName)) {
                return order;
            }
        }
        return null;
    }

    public static boolean removeOrder(int i) {
        for (Order a : orderList) {
            if (a.getId() == i) {
                orderList.remove(a);
                return true;
            }
        }
        return false;
    }

    public static void rate(double newRate, String brand) {
        switch (brand) {
            case "Burger King":
                BurgerKing.rated++;
                BurgerKing.rating += newRate;
                break;
            case "Arbys":
                Arbys.rated++;
                Arbys.rating += newRate;
                break;
            case "McDonalds":
                // McDonalds.rated++;
                // McDonalds.rating+=newRate;
                break;
        }
    }

    public static double calculateAverageRating(String brand) {
        int ratedCount = 0;
        double totalRating = 0.0;
        for (Order order : orderList) {
            if (order.getBrand().equals(brand)) {
                ratedCount++;
                totalRating += order.getRating();
            }
        }
        return (ratedCount > 0) ? (totalRating / ratedCount) : 0.0;
    }

    public static ArrayList<Order> getOrderList() {
        return OrderSys.orderList;
    }
} 