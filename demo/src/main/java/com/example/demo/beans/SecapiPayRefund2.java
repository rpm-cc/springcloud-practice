package com.example.demo.beans;

import com.alibaba.fastjson.JSON;
import com.example.demo.util.AESUtil;

import weixin.popular.api.PayMchAPI;
import weixin.popular.bean.paymch.SecapiPayRefund;
import weixin.popular.client.LocalHttpClient;
import weixin.popular.util.XMLConverUtil;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


@XmlRootElement(
        name = "xml"
)
public class SecapiPayRefund2 extends SecapiPayRefund {


    @XmlElement
    private String notify_url;

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }


    public static void applayRefund() {
        SecapiPayRefund2 secapiPayRefund = new SecapiPayRefund2();


        //1080192923963793408959936
        //1082982354001108992009664
        String key = "1714907eb8d4465290109bbcd0ec6ee2";
        secapiPayRefund.setAppid("wx731d62ae850c6c5e");
        secapiPayRefund.setNotify_url("https://dev-api.aobei.com/callback/wxrefund");
        secapiPayRefund.setMch_id("1498998082");
        secapiPayRefund.setNonce_str("12345678");
        secapiPayRefund.setOut_trade_no("1080108650942472192009664");
        secapiPayRefund.setOut_refund_no("201804080928005");
        secapiPayRefund.setRefund_fee(1);
        secapiPayRefund.setTotal_fee(1);
        secapiPayRefund.setRefund_fee_type("CNY");
        secapiPayRefund.setSign_type("MD5");
        File file = new File("/Users/aobei-dev/Desktop/cert/apiclient_cert.p12");
        try {
            FileInputStream inputStream = new FileInputStream(file);
            LocalHttpClient.initMchKeyStore("1498998082", inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        weixin.popular.bean.paymch.SecapiPayRefundResult result = PayMchAPI.secapiPayRefund(secapiPayRefund, key);
        System.out.println(JSON.toJSONString(result));

    }


    public static void decodeReqInfo() {
        String ALGORITHM = "PKCS7Padding";


        String req_info = "xXqqYXU1IFEbEPbhb6CT2w9tE08MPWeixsW5cyJsJ1c+0wshJe4t0RgUujbqvUA1FW4gHfa8NrYkAfkbokCs7gmT4Je/a0Sa2VXHiloWwmMiZMuUk6Ibrv+hi0KHS802cgFdIXpZ5THpgjGYK0iVOcvB3ctSGof9v69xgxN7gxylBMgzF/cXPUoeA4dovWQAicTcPhWCAahZJge4P5xQLHZFwyoiiZiUzDjQ+QjyYgAE8ZQHO2jhheL2obCBoSwSHQwZCZfYTVfcpEFAXQh+3lP3qqG5CbRWf9Et3U+a8f7I3fCUGm5vcSdmxuj1rf6dTKUWlPTRt+bscJMdb3mXJil1TmbXeTwajjkACSepmTpOyWH1qy2GabjJxUoM/mYWOyWo9jnxBkURobeq3O6iW4NWMtZAtnZyy8B1kaY38GObstC8+g4bGQA6Pp3Ok5yVlNCQrTLZFEaLeTo92QXiuaOgFiwzKcS4CeSn9+9PV045lp4MWRN6Vt95E7XyIMikUto3ukwS/tzi8882T/abkL7LlHykpEKYo4daBmY5Wv8ZHFaw0sQ0giE7R7M3hg46QDHR8XZElVb//YjblNih+j5Zn+JfT+c6/ZYQ3WGCrZLchJP1MgI7RAoofbEBMuKCldctv1Wo31CDG0vHt/iNciAxP90n4vhV30ZXpcQJSn5Abe3Ce4XNJPtTB03Al2PI46KfD+ccoAasvSfLRVeNUL11TH8R9Di4cyPiH6Wwvti3JdttXZBdJXvlJeWqwETPHaodn2Q7H4ELzRPihoFvRWFKrMvVa/yxU4q2aSlJHao/6+5UjHDTtn1YbdGFffJ0Vpj0o6ZqMP0uuBFr/bNHGr/n21sQB2i4PBlh7gWW1/TzTqu5EWkm7CDUGIVeAp3Iw8ItdAGXuBIbRj9BbxFhd9DvM0QsnXCJT/MZy7IeWS9UziwfdUMG8ORDp34vFvlrzPR5jIB9PcEkBbCVqfZSanViyYmtaysw2OozyifENlJFjJfZIMMMOZ8xePfG3siFH8kE9CDgEH7LPyF2/Vy1bvtj0oGBu5bnRPOPBUfUPzCEANkpocRmVP52WwWwgOzh";
        String key = "1714907eb8d4465290109bbcd0ec6ee2";

        try {
            String result = AESUtil.decryptData(req_info, key);
            SecapiPayRefundResult2 secapiPayRefundResult2 =  XMLConverUtil.convertToObject(SecapiPayRefundResult2.class, result);

            System.out.println(result);
            System.out.println(secapiPayRefundResult2.getRefund_id());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        //applayRefund();
        decodeReqInfo();
    }

}
