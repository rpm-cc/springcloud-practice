package cn.rpm.goods.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by renpiming on 2018/1/9.
 * 所遇到的未解决的问题：在git中的配置文件中有中文配置，读取到的是乱码！
 */
@RestController
@RefreshScope
@RequestMapping(value = "/config")
public class ConfigController {
    @Autowired
    RestTemplate template;
    @Value("${profile}")
    String profile;
    @Value("${pro.name}")
    String name;
    @Value("${pro.conf}")
    String conf;

    @RequestMapping(value = "/")
    public Map getConf() {
        Map<String, String> map = new HashMap<>();
        map.put("goods.conf", conf);
        map.put("profile", profile);
        map.put("name", name);
        map.put("code", "汉字编码");
        return map;

    }

    @RequestMapping(value = "/refresh")
    public String refresh() {
        template.postForEntity("http://localhost:8763/refresh", null, String.class);
        return null;
    }
}
