package demo.project.system.food.mapper;

import demo.project.system.food.domain.Food;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodMapper {
    public List<Food> getFoodsBySellerName(String sellerName);
    public Food getFoodByFoodName(String foodName);
    public void insertFood(Food food);
}
