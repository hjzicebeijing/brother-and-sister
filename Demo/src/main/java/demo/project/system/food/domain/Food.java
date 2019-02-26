package demo.project.system.food.domain;

import demo.framework.web.domain.BaseDomain;

public class Food extends BaseDomain {
    private static final Long SerialVersionUID=1L;

    private long foodId;
    private String sellerName;
    private String foodName;
    private String foodImg;
    private String foodPrice;
    private int foodStatus;

    public long getFoodId() {
        return foodId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getFoodImg() {
        return foodImg;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public int getFoodStatus() {
        return foodStatus;
    }

    public void setFoodId(long foodId) {
        this.foodId = foodId;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setFoodImg(String foodImg) {
        this.foodImg = foodImg;
    }

    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }

    public void setFoodStatus(int foodstatus) {
        this.foodStatus = foodstatus;
    }
}
