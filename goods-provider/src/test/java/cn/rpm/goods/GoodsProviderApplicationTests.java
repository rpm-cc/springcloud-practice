package cn.rpm.goods;

import cn.rpm.goods.bean.User;
import cn.rpm.goods.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsProviderApplicationTests {
    @Autowired
    UserMapper mapper;

    @Test
    public void contextLoads() {

        User  user = new User();
        user.setName("任丕明");
        user.setAge(33);
        mapper.insert(user);


    }

}
