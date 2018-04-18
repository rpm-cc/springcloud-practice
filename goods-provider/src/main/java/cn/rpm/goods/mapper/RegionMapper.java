package cn.rpm.goods.mapper;

import cn.rpm.goods.bean.Region;

import java.util.List;
import java.util.Map;

public interface RegionMapper {

    int insert(Region region);
    Region getOne(int id);
    List<Region> list(Map<String,String> param);
}
