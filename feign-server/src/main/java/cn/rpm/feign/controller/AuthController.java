package cn.rpm.feign.controller;

import cn.rpm.feign.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by renpiming on 2017/11/23.
 */
@RestController
public class AuthController {
    //此处。默认注入的是注册服务中的实现@FeignClient(value = "service-user",fallback = AuthServiceImpl.class)
    //fallback中的实现类是我们自己实现的，只有当出现问题的时候才会使用到。此时在idea中会提示出现多个bean。不能注入。但是不影响编译和使用
    //我在设置中降低了检查级别。没有显示报错。
    //作用：当我们启动多个eureka-user-provider 服务后。fegin 会自己进行运算然后选择一个服务器访问。（eureka中的service-user）
    @Autowired
    private AuthService authService;
    @RequestMapping(value = "/auth/info",method = RequestMethod.GET)
    public String info(){
        return authService.info();
    }
    @RequestMapping(value = "/auth/login",method = RequestMethod.GET)
    public String login(@RequestParam(value ="phone") String phone,@RequestParam(value = "pwd") String pwd){
        return authService.login(phone,pwd);
    }


}
