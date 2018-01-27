package cn.rpm.goods.service;

import cn.rpm.goods.bean.Product;
import cn.rpm.goods.mapper.ProductXmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by renpiming on 2018/1/12.
 */
@Service
@Transactional
public class ProductServiceImpl1 implements ProductService {

    @Autowired
    ProductXmlMapper mapper;
    @Autowired
    ProductServiceImpl2 service;

    @Override
    public int insert(Product product) {
        mapper.insert(product);
        //service.setPriceById(product.getpID(),1000);
        return 1;
    }

    @Override
    public Product findProductById(int pID) {
        return mapper.findProductById(pID);
    }

    @Override
    public int setPriceById(int pID, int price) {
        Product product = new Product(pID, price);
        product = null;
        product.setpID(pID);
        return mapper.setPriceById(product);
    }

}
