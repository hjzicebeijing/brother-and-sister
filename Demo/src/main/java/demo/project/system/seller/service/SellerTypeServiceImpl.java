package demo.project.system.seller.service;

import demo.project.system.seller.domain.SellerType;
import demo.project.system.seller.mapper.SellerTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerTypeServiceImpl implements ISellerTypeService {
    @Autowired
    private SellerTypeMapper sellerTypeMapper;

    @Override
    public List<SellerType> getListSellerTypeOrderByScore(int number) {
        return sellerTypeMapper.getListSellerTypeOrderByScore(number);
    }

    @Override
    public SellerType getSellerType(String sellerTypeName) {
        return sellerTypeMapper.getSellerType(sellerTypeName);
    }

    @Override
    public int checkSellerTypeName(String sellerTypeName) {
        return sellerTypeMapper.checkSellerTypeName(sellerTypeName);
    }

    @Override
    public void insertSellerType(SellerType sellerType) {
        sellerTypeMapper.insertSellerType(sellerType);
    }

    @Override
    public void updateSellerType(String sellerTypeName) {
        sellerTypeMapper.updateSellerType(sellerTypeName);
    }
}
