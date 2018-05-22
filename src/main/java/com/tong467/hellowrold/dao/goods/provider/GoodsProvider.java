package com.tong467.hellowrold.dao.goods.provider;

import org.apache.ibatis.jdbc.SQL;

public class GoodsProvider {

    private final String GOODS_TABLE_NAME = "goods";

    public String selectByUserId() {
        return new SQL().SELECT("id", "name,price", "`describe`", "status", "create_time", "update_time", "user_id")
                       .FROM(GOODS_TABLE_NAME).WHERE("user_id = #{userId}").toString();
    }
}
