package cn.rpm.feign.service.impl;

import cn.rpm.feign.service.AuthService;
import org.springframework.stereotype.Component;

/**
 * Created by renpiming on 2017/11/23.
 */
@Component
public class AuthServiceImpl implements AuthService {
    @Override
    public String info() {
        return "sorry info";
    }

    @Override
    public String login(String phone, String pwd) {
        return "sorry login";
    }
}
