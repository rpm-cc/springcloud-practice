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
