package cn.rpm.goods.provider;


import cn.rpm.goods.bean.Region;
import cn.rpm.goods.mapper.RegionMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/region")
public class RegionController {

    @Autowired
    RegionMapper mapper;

    @RequestMapping("/init")
    public String init() {

        String path = RegionController.class.getClassLoader().getResource("region_dumps.json").getPath();
        BufferedReader brname;
        StringBuilder builder = new StringBuilder();
        try {
            brname = new BufferedReader(new FileReader(path));// 读取NAMEID对应值
            String sname = null;

            while ((sname = brname.readLine()) != null) {
                // System.out.println(sname);
                builder.append(sname);
            }
            brname.close();
            //System.out.println(builder.toString());
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }


        ObjectMapper mapper1 = new ObjectMapper();
        try {
            Map<String, Object> map = mapper1.readValue(builder.toString(), Map.class);
            List<Map<String,Object>> list  = (List<Map<String,Object>> )map.get("districts");
            Map<String, Object> region = list.get(0);
            Region region1 = new Region(0,region.get("name").toString(),0,1,region.get("level").toString(),0);
            //mapper.insert(region1);
          //  List<Map<String,Object>> list2= (List<Map<String,Object>> )region.get("districts");
            //cities(list2,region1.getRegion_id());
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }


    public static void main(String[] args) {
        String path = RegionController.class.getClassLoader().getResource("region_dumps.json").getPath();
        BufferedReader brname;
        StringBuilder builder = new StringBuilder();
        try {
            brname = new BufferedReader(new FileReader(path));// 读取NAMEID对应值
            String sname = null;

            while ((sname = brname.readLine()) != null) {
                builder.append(sname);
            }
            brname.close();
            System.out.println(builder.toString());
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }



    }




    public   void cities(List<Map<String, Object>> list,int pid) {

        for( Map<String, Object> region :list) {
            Region region1 = new Region(0,region.get("name").toString(),pid,1,region.get("level").toString(),0);
            mapper.insert(region1);

            List<Map<String, Object>> sublist = (List<Map<String, Object>>) region.get("districts");
            if (sublist != null && sublist.size() > 0) {
                cities(sublist,region1.getRegion_id());
            }
        }

    }



    public static String unicode2String(String unicode){
        if(StringUtils.isBlank(unicode))return null;
        StringBuilder sb = new StringBuilder();
        int i = -1;
        int pos = 0;

        while((i=unicode.indexOf("\\u", pos)) != -1){
            sb.append(unicode.substring(pos, i));
            if(i+5 < unicode.length()){
                pos = i+6;
                sb.append((char)Integer.parseInt(unicode.substring(i+2, i+6), 16));
            }
        }

        return sb.toString();
    }
}
