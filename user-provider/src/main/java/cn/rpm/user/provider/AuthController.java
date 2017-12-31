package cn.rpm.user.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by renpiming on 2017/11/23.
 */

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    RestTemplate template;

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

    @RequestMapping("/default/goods")
    public  String getDefaultGoods(){

        String url = "http://localhost:8763/goods/book";
        template.getForObject(url,String.class);

        return template.getForObject(url,String.class);
    }

}
