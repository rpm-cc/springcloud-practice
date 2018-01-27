package cn.rpm.goods.mapper;

import cn.rpm.goods.bean.Product;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;


/**
 * Created by renpiming on 2018/1/10.
 * 使用注解的方式进行的。我们还需要一个使用xml的 。
 */
public interface ProductMapper {
    //@Insert("insert into _product (name,factory,_describe,pro_day,price) values (#{product.pName},#{product.pFactory},#{product.pDescribe},#{product.pDay},#{product.pPrice})")

    @InsertProvider(type = CreateSqlFactory.class, method = "createAddProduct")
    @Options(useGeneratedKeys = true, keyProperty = "product.pID")
    int addProduct(@Param("product") Product product);

    @UpdateProvider(type = CreateSqlFactory.class, method = "createSetprice")
    int setprice(@Param("product") Product product);

    class CreateSqlFactory {

        public String createAddProduct() {

            return new SQL() {
                {
                    INSERT_INTO("_product");
                    INTO_COLUMNS("name", "factory", "_describe", "price");
                    INTO_VALUES("#{product.pName}", "#{product.pFactory}", "#{product.pDescribe}", "#{product.pPrice}");
                }
            }.toString();
        }

        public String createSetprice() {
            return new SQL() {
                {
                    UPDATE("_product");
                    SET("price=#{product.pPrice}");
                    WHERE("id=#{product.pID}");
                }
            }.toString();

        }

    }


}
