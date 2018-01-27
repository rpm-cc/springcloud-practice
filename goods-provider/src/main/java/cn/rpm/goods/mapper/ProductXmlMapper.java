package cn.rpm.goods.mapper;

import cn.rpm.goods.bean.Product;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.jdbc.SQL;


/**
 * Created by renpiming on 2018/1/10.
 * xml方式使用mybaties。
 */
public interface ProductXmlMapper {

   int  insert(Product product);
   Product findProductById(int pID);
   int setPriceById(Product product);

}
