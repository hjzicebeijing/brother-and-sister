package demo.project.system.pay.domain;

import demo.framework.web.domain.BaseDomain;

public class Pay extends BaseDomain {
    private static final long SerialVersionUID=1L;

    private long payId;
    private long sellerId;
    private long userId;
    private long orderId;
    private String payTime;
    private int payStatus;

    public long getPayId() {
        return payId;
    }

    public long getSellerId() {
        return sellerId;
    }

    public long getUserId() {
        return userId;
    }

    public long getOrderId() {
        return orderId;
    }

    public String getPayTime() {
        return payTime;
    }

    public int getPayStatus() {
        return payStatus;
    }

    public void setPayId(long payId) {
        this.payId = payId;
    }

    public void setSellerId(long sellerId) {
        this.sellerId = sellerId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public void setPayStatus(int payStatus) {
        this.payStatus = payStatus;
    }
}
