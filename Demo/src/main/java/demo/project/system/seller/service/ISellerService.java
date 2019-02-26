package demo.project.system.seller.service;

import demo.project.system.seller.domain.Seller;

import java.util.List;

public interface ISellerService {
    public void insertSeller(Seller seller);
    public Seller getSellerBySellerName(String sellerName);
    public List<Seller> getSellerBySellerTypeName(String sellerTypeName);
    public List<Seller> getSellersByLoginName(String loginName);
    public List<Seller> getWholeSeller();
}
