package com.example.demo.beans;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;

@XmlRootElement(
        name = "root"
)
@XmlAccessorType(XmlAccessType.FIELD)
public class SecapiPayRefundResult2 extends weixin.popular.bean.paymch.SecapiPayRefundResult {

    /**
     * <root>
     * <out_refund_no><![CDATA[201804080928002]]></out_refund_no>
     * <out_trade_no><![CDATA[1072874674615853056668224]]></out_trade_no>
     * <refund_account><![CDATA[REFUND_SOURCE_RECHARGE_FUNDS]]></refund_account>
     * <refund_fee><![CDATA[1]]></refund_fee>
     * <refund_id><![CDATA[50000106162018040804098614389]]></refund_id>
     * <refund_recv_accout><![CDATA[民生银行信用卡0364]]></refund_recv_accout>
     * <refund_request_source><![CDATA[API]]></refund_request_source>
     * <refund_status><![CDATA[SUCCESS]]></refund_status>
     * <settlement_refund_fee><![CDATA[1]]></settlement_refund_fee>
     * <settlement_total_fee><![CDATA[1]]></settlement_total_fee>
     * <success_time><![CDATA[2018-04-08 10:29:11]]></success_time>
     * <total_fee><![CDATA[1]]></total_fee>
     * <transaction_id><![CDATA[4200000077201803202271287121]]></transaction_id>
     * </root>
     **/
    private static Logger logger = LoggerFactory.getLogger(SecapiPayRefundResult2.class);
    private String device_info;
    private String transaction_id;
    private String out_trade_no;
    private String out_refund_no;
    private String refund_id;
    private String refund_channel;
    private Integer refund_fee;
    private Integer total_fee;
    private String fee_type;
    private Integer settlement_refund_fee;
    private Integer settlement_total_fee;
    private Integer cash_fee;
    private Integer cash_refund_fee;
    private Integer coupon_refund_fee;
    private Integer coupon_refund_count;

    public SecapiPayRefundResult2() {
    }

    public String getDevice_info() {
        return this.device_info;
    }

    public void setDevice_info(String device_info) {
        this.device_info = device_info;
    }

    public String getTransaction_id() {
        return this.transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getOut_trade_no() {
        return this.out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getOut_refund_no() {
        return this.out_refund_no;
    }

    public void setOut_refund_no(String out_refund_no) {
        this.out_refund_no = out_refund_no;
    }

    public String getRefund_id() {
        return this.refund_id;
    }

    public void setRefund_id(String refund_id) {
        this.refund_id = refund_id;
    }

    public String getRefund_channel() {
        return this.refund_channel;
    }

    public void setRefund_channel(String refund_channel) {
        this.refund_channel = refund_channel;
    }

    public Integer getRefund_fee() {
        return this.refund_fee;
    }

    public void setRefund_fee(Integer refund_fee) {
        this.refund_fee = refund_fee;
    }

    public Integer getCoupon_refund_fee() {
        return this.coupon_refund_fee;
    }

    public void setCoupon_refund_fee(Integer coupon_refund_fee) {
        this.coupon_refund_fee = coupon_refund_fee;
    }

    public Integer getTotal_fee() {
        return this.total_fee;
    }

    public void setTotal_fee(Integer total_fee) {
        this.total_fee = total_fee;
    }

    public String getFee_type() {
        return this.fee_type;
    }

    public void setFee_type(String fee_type) {
        this.fee_type = fee_type;
    }

    public Integer getCash_fee() {
        return this.cash_fee;
    }

    public void setCash_fee(Integer cash_fee) {
        this.cash_fee = cash_fee;
    }

    public Integer getCash_refund_fee() {
        return this.cash_refund_fee;
    }

    public void setCash_refund_fee(Integer cash_refund_fee) {
        this.cash_refund_fee = cash_refund_fee;
    }

    public Integer getCoupon_refund_count() {
        return this.coupon_refund_count;
    }

    public void setCoupon_refund_count(Integer coupon_refund_count) {
        this.coupon_refund_count = coupon_refund_count;
    }

    public Integer getSettlement_refund_fee() {
        return this.settlement_refund_fee;
    }

    public void setSettlement_refund_fee(Integer settlement_refund_fee) {
        this.settlement_refund_fee = settlement_refund_fee;
    }

    public Integer getSettlement_total_fee() {
        return this.settlement_total_fee;
    }

    public void setSettlement_total_fee(Integer settlement_total_fee) {
        this.settlement_total_fee = settlement_total_fee;
    }

    @Override
    public void buildDynamicField(Map<String, String> map) {

    }
}
