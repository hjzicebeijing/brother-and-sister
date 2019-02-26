package demo.project.system.food.service;

import demo.project.system.food.domain.Food;
import demo.project.system.food.mapper.FoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements IFoodService{
    @Autowired
    private FoodMapper foodMapper;

    @Override
    public List<Food> getFoodsBySellerName(String sellerName) {
        return foodMapper.getFoodsBySellerName(sellerName);
    }

    @Override
    public Food getFoodByFoodName(String foodName) {
        return foodMapper.getFoodByFoodName(foodName);
    }

    @Override
    public void insertFood(Food food) {
        foodMapper.insertFood(food);
    }
}
