package demo.project.system.seller.service;

import demo.project.system.seller.domain.Seller;
import demo.project.system.seller.mapper.SellerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerServiceImpl implements ISellerService{
    @Autowired
    private SellerMapper sellerMapper;

    @Override
    public void insertSeller(Seller seller) {
        sellerMapper.insertSeller(seller);
    }

    @Override
    public Seller getSellerBySellerName(String sellerName) {
        return sellerMapper.getSellerBySellerName(sellerName);
    }

    @Override
    public List<Seller> getSellerBySellerTypeName(String sellerTypeName) {
        return sellerMapper.getSellerBySellerTypeName(sellerTypeName);
    }

    @Override
    public List<Seller> getSellersByLoginName(String loginName) {
        return sellerMapper.getSellersByLoginName(loginName);
    }

    @Override
    public List<Seller> getWholeSeller() {
        return sellerMapper.getWholeSeller();
    }
}
