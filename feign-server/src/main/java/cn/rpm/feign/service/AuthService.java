package cn.rpm.feign.service;

import cn.rpm.feign.service.impl.AuthServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by renpiming on 2017/11/23.
 */
@FeignClient(value = "service-client",fallback = AuthServiceImpl.class)
public interface AuthService {

    @RequestMapping(value = "/auth/info",method = RequestMethod.GET)
    String info();
    @RequestMapping(value = "/auth/login",method = RequestMethod.GET)
    String login(@RequestParam(value = "phone") String phone,@RequestParam(value = "pwd") String pwd );
}
