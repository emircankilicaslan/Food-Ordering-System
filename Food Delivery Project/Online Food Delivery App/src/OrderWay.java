public class OrderWay {
    String paymentMethod;
    double deliveryFee;
    String deliveryTime;

    public OrderWay(String paymentMethod, double deliveryFee, String deliveryTime) {
        this.paymentMethod = paymentMethod;
        this.deliveryFee = deliveryFee;
        this.deliveryTime = deliveryTime;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(double deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
    
    
    
}

