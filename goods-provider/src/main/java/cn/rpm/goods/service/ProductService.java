package cn.rpm.goods.service;

import cn.rpm.goods.bean.Product;

/**
 * Created by renpiming on 2018/1/17.
 */
public interface ProductService {

    int insert(Product product);

    Product findProductById(int pID);

    int setPriceById(int pID, int price);

}
