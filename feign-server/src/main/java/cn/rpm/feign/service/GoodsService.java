package cn.rpm.feign.service;

import cn.rpm.feign.service.impl.AuthServiceImpl;
import cn.rpm.feign.service.impl.GoodsServiceImpl;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by renpiming on 2017/11/24.
 */
@FeignClient(value = "service-goods",fallback = GoodsServiceImpl.class)
public interface GoodsService {
}
