package cn.rpm.goods.mapper;

import cn.rpm.goods.bean.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by renpiming on 2018/1/5.
 */
public interface UserMapper {


    int  insert(User user);
    HashMap getOne(int id);
}
