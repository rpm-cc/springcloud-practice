package cn.rpm.eureka.user.provider;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by renpiming on 2017/11/23.
 */

@RestController
@RequestMapping("/auth")
public class AuthController {


    @RequestMapping("/info")
    public String info(){



        return "this is auth info ";

    }

    @RequestMapping("/login")
    public  String login(@RequestParam String phone,@RequestParam String pwd){

        if (phone.equals("18600203527")&&pwd.equals("14343342")){
            return "login success!";
        }else{
            return  "username or password was wrong";
        }


    }

}
