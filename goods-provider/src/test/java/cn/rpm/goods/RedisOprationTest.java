package cn.rpm.goods;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by renpiming on 2018/1/8.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisOprationTest {


    @Autowired
    StringRedisTemplate templete;

    @Test
    public void testString(){
        Assert.assertEquals("ab",templete.opsForValue().get("mykey"));

    }
}
