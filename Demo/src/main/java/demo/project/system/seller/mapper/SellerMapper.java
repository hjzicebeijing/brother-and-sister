package demo.project.system.seller.mapper;

import demo.project.system.seller.domain.Seller;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerMapper {
    public void insertSeller(Seller seller);
    public Seller getSellerBySellerName(String sellerName);
    public List<Seller> getSellerBySellerTypeName(String sellerTypeName);
    public List<Seller> getWholeSeller();
    public List<Seller> getSellersByLoginName(String loginName);
}
