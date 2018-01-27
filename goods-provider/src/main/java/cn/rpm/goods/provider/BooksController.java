package cn.rpm.goods.provider;

import cn.rpm.goods.bean.Book;
import cn.rpm.goods.bean.Goods;
import cn.rpm.goods.exception.IlegalParamsException;
import cn.rpm.goods.exception.RestIlegalParamsException;
import cn.rpm.goods.mapper.GoodsMapper;
//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiImplicitParams;
//import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * Created by renpiming on 2017/12/14.
 *
 * @ Controller：修饰class，用来创建处理http请求的对象
 * @ RestController：Spring4之后加入的注解，原来在@Controller中返回json需要@ResponseBody来配合，
 * 如果直接用@RestController替代@Controller就不需要再配置@ResponseBody，默认返回json格式。
 * @ RequestMapping：配置url映射
 * <p>
 * <p>
 * 通过@ApiOperation注解来给API增加说明
 * 通过@ApiImplicitParams、
 * 通过@ApiImplicitParam注解来给参数增加说明。
 */


@RestController
@RequestMapping(value = "/goods")
public class BooksController {

    @Autowired
    GoodsMapper goodsMapper;

    //实验返回Book对象的json字符串
    //@ApiOperation(value = "获取一本书的几本信息", notes = "获取默认的信息",httpMethod = "GET")
    @RequestMapping(value = "/book",method = RequestMethod.GET)
    public Book books() {
        Book book = new Book();
        book.setBookName("Spring boot Study");
        book.setDescription("the best way of study Spring boot");
        book.setWords(1000000);
        book.setPublishDate("2017-12-31");
        return book;
    }

    //实验@PathVariable 路径参数
//    @ApiOperation(value = "获取一个商品的基本信息", notes = "一个商品的基本信息",httpMethod = "GET")
//    @ApiImplicitParam(name = "id", value = "商品id", required = true, dataType = "int")
    @RequestMapping(value = "/{id}")
    public Goods goods(@PathVariable int id) {
        Goods goods = new Goods();
        goods.setId(id);
        goods.setType("mytype");
        return goods;
    }

    //实验从参数中直接传一个对象过来
    //?id=100&type=book
//    @ApiOperation(value = "向数据库中插入一个商品的基本信息", notes = "带有事物的数据库操作",httpMethod = "GET")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "id", value = "商品id", required = true, dataType = "int"),
//            @ApiImplicitParam(name = "type", value = "商品类型", required = true, dataType = "String")
//    })
    @Transactional
    @RequestMapping(value = "/add")
    public Goods addGoods(@ModelAttribute Goods goods) {
        goodsMapper.insert("type1");
        goodsMapper.insert(goods.getType());
        goodsMapper.insert("type3");
        return goods;
    }
//    @ApiOperation(value = "测试统一异常处理", notes = "json形式返回异常信息",httpMethod = "GET")
    @RequestMapping(value = "ex")
    public String ex(@RequestParam String ex) throws RestIlegalParamsException {
        if (ex.equals("ex")) {
            throw new RestIlegalParamsException("ex params ilegal");
        }
        return ex;
    }
//    @ApiOperation(value = "根据id查找商品", notes = "在url中拼上int类型的商品id",httpMethod = "GET")
    @RequestMapping(value = "/get/{id}")
    public Goods getGoodsById(@PathVariable int id) {

        return goodsMapper.findById(id);
    }


    public static void main(String[] args) {



    }

}
