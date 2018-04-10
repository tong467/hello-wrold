package com.tong467.hellowrold.entity;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderRequest {

    /**
     * 用户标识
     */
    @Expose(serialize = false)
    @SerializedName("user_id")
    private String userId;
    /**
     * 商品标识
     */
    @Expose(deserialize = false)
    @SerializedName("goods_id")
    private String goodsId;
    /**
     * 价格
     */
    private int price;
    @Expose
    @SerializedName("order_no")
    private String orderNo;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("userId:%s ,goodsId:%s,price:%d,orderNo:%s", userId, goodsId, price, orderNo);
    }
}
