package cn.rpm.goods.mapper;

import cn.rpm.goods.bean.Goods;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by renpiming on 2018/1/1.
 */
public interface GoodsMapper {

    @Select("SELECT * FROM goods WHERE id = #{id}")
    Goods findById(@Param("id") int id);

    @Insert("INSERT INTO goods(type) VALUES(#{type})")
    int insert(@Param("type") String type);

    //可以使用SelectProvider 的方式实现动态sql
    @SelectProvider(type = UserDaoProvider.class, method = "findUserById")
    List<Goods> findUserById(Goods goos);

    class UserDaoProvider {
        public String findUserById(Goods goods) {
            String sql = "SELECT * FROM user";
            if (goods.getType() != null) {
                sql += " where id = #{id}";
            }
            return sql;
        }

        //SQL语句构建器类
        //http://www.mybatis.org/mybatis-3/zh/statement-builders.html
        private String selectPersonSql() {
            return new SQL() {{
                SELECT("P.ID, P.USERNAME, P.PASSWORD, P.FULL_NAME");
                SELECT("P.LAST_NAME, P.CREATED_ON, P.UPDATED_ON");
                FROM("PERSON P");
                FROM("ACCOUNT A");
                INNER_JOIN("DEPARTMENT D on D.ID = P.DEPARTMENT_ID");
                INNER_JOIN("COMPANY C on D.COMPANY_ID = C.ID");
                WHERE("P.ID = A.ID");
                WHERE("P.FIRST_NAME like ?");
                OR();
                WHERE("P.LAST_NAME like ?");
                GROUP_BY("P.ID");
                HAVING("P.LAST_NAME like ?");
                OR();
                HAVING("P.FIRST_NAME like ?");
                ORDER_BY("P.ID");
                ORDER_BY("P.FULL_NAME");
            }}.toString();
        }
    }

}
