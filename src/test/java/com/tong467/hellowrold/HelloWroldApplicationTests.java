package com.tong467.hellowrold;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tong467.hellowrold.entity.OrderRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloWroldApplicationTests {

    @Test
    public void testSerialization() {
        OrderRequest request = new OrderRequest();
        request.setPrice(10);
        request.setGoodsId("g01");
        request.setUserId("1");
        request.setOrderNo("20180331100001");
        Gson gson = new Gson();
        System.out.println("Gson:" + gson.toJson(request));
        Gson excludeGson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        System.out.println("ExcludeGson:" + excludeGson.toJson(request));
    }


    @Test
    public void testDeserialization() {
        String json = "{\"user_id\":\"1\",\"goods_id\":\"goods\",\"price\":10,\"order_no\":\"20180331100001\"}";
        Gson gson = new Gson();
        System.out.println(gson.fromJson(json, OrderRequest.class));
        Gson excludeGson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        System.out.println(excludeGson.fromJson(json, OrderRequest.class));
    }

}
