package demo.project.system.seller.service;

import demo.project.system.seller.domain.SellerType;

import java.util.List;

public interface ISellerTypeService {
    public List<SellerType> getListSellerTypeOrderByScore(int number);
    public SellerType getSellerType(String sellerTypeName);
    public int checkSellerTypeName(String sellerTypeName);
    public void insertSellerType(SellerType sellerType);
    public void updateSellerType(String sellerTypeName);
}
