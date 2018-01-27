package cn.rpm.goods.bean;


import java.util.Date;

/**
 * Created by renpiming on 2018/1/10.
 */
public class Product {
    int pID;
    String pName;
    String pFactory;
    String pDescribe;
    Date pDay;
    int pPrice;

    public Product() {

    }

    public Product(int pID, int pPrice) {
        this.pID = pID;
        this.pPrice = pPrice;
    }

    public int getpID() {
        return pID;
    }

    public void setpID(int pID) {
        this.pID = pID;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpFactory() {
        return pFactory;
    }

    public void setpFactory(String pFactory) {
        this.pFactory = pFactory;
    }

    public String getpDescribe() {
        return pDescribe;
    }

    public void setpDescribe(String pDescribe) {
        this.pDescribe = pDescribe;
    }

    public Date getpDay() {
        return pDay;
    }

    public void setpDay(Date pDay) {
        this.pDay = pDay;
    }

    public int getpPrice() {
        return pPrice;
    }

    public void setpPrice(int pPrice) {
        this.pPrice = pPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pID=" + pID +
                ", pName='" + pName + '\'' +
                ", pFactory='" + pFactory + '\'' +
                ", pDescribe='" + pDescribe + '\'' +
                ", pDay=" + pDay +
                ", pPrice=" + pPrice +
                '}';
    }
}
