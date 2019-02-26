package demo.project.system.food.service;

import demo.project.system.food.domain.Food;

import java.util.List;

public interface IFoodService {
    public List<Food> getFoodsBySellerName(String sellerName);
    public Food getFoodByFoodName(String foodName);
    public void insertFood(Food food);
}
