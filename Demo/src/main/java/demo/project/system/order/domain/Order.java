package demo.project.system.order.domain;

import demo.framework.web.domain.BaseDomain;

public class Order extends BaseDomain {
    private static final long SerialVersionUID=1L;

    private long orderId;
    private long sellerId;
    private long foodId;
    private long userId;
    private String payMethod;
    private int payStatus;
    private float payTotal;

    public long getOrderId() {
        return orderId;
    }

    public long getSellerId() {
        return sellerId;
    }

    public long getFoodId() {
        return foodId;
    }

    public long getUserId() {
        return userId;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public int getPayStatus() {
        return payStatus;
    }

    public float getPayTotal() {
        return payTotal;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public void setSellerId(long sellerId) {
        this.sellerId = sellerId;
    }

    public void setFoodId(long foodId) {
        this.foodId = foodId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public void setPayStatus(int payStatus) {
        this.payStatus = payStatus;
    }

    public void setPayTotal(float payTotal) {
        this.payTotal = payTotal;
    }
}
