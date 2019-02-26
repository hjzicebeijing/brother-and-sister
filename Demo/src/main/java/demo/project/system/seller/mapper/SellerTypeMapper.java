package demo.project.system.seller.mapper;

import demo.project.system.seller.domain.SellerType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerTypeMapper {
    public List<SellerType> getListSellerTypeOrderByScore(int number);
    public SellerType getSellerType(String sellerTypeName);
    public int checkSellerTypeName(String sellerTypeName);
    public void insertSellerType(SellerType sellerType);
    public void updateSellerType(String sellerTypeName);
}
