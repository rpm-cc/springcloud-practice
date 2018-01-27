package cn.rpm.goods.provider;

import cn.rpm.goods.bean.Product;
import cn.rpm.goods.exception.RestIlegalParamsException;
import cn.rpm.goods.mapper.ProductMapper;
import cn.rpm.goods.service.ProductServiceImpl1;
import cn.rpm.goods.service.ProductServiceImpl2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


//1、处理requet uri 部分（这里指uri template中variable，不含queryString部分）的注解：   @PathVariable;
//
//2、处理request header部分的注解：   @RequestHeader, @CookieValue;
//
//3、处理request body部分的注解：@RequestParam,  @RequestBody;
//
//4、处理attribute类型是注解： @SessionAttributes, @ModelAttribute;

/**
 * Created by renpiming on 2018/1/10.
 */
@RestController
@RequestMapping(value = "/p")
public class ProductController {

    @Autowired
    ProductMapper mapper;
    @Autowired
    ProductServiceImpl1 service;
    @Autowired
    ProductServiceImpl2 service2;

    //实验了两个全注解形式的mapper
    @RequestMapping(value = "/add")
    public String addAProduct(@ModelAttribute Product product) throws RestIlegalParamsException {

        if (product.getpName() == null
                || product.getpFactory() == null
                || product.getpDescribe() == null
                || product.getpPrice() == 0) {
            throw new RestIlegalParamsException("needs params [pName ,pFactory,pDescribe,pPrice}");
        }

        mapper.addProduct(product);

        return "success:id=" + product.getpID();


    }

    @RequestMapping(value = "/set/{pID}/{pPrice}")
    public String setPrice(@PathVariable int pID, @PathVariable int pPrice) {
        Product product = new Product(pID, pPrice);
        mapper.setprice(product);

        return "success";
    }

    //以下为使用xml方式配置的mapper
    //事物传递性的测试证明。事物传递针对的是service的嵌套操作。嵌套的外层service的事物才能传递下去。
    @RequestMapping(value = "/add/get", method = RequestMethod.GET)
    public Product addAndGet(@ModelAttribute Product product) {
        product.setpDescribe("首先调用带有事物的service，嵌套没有事物的service");
        service.insert(product);
//        product.setpDescribe("其次调用不带有事物的service，嵌套没无事物的service");
//        service2.insert(product);
        int pID = product.getpID();
        product = service.findProductById(pID);

        return product;

    }

    @RequestMapping(value = "/{pID}/{pPrice}", method = RequestMethod.GET)
    public String setPriceById(@PathVariable int pID, @PathVariable int pPrice) {
        service.setPriceById(pID, pPrice);
        return "success";
    }


}
