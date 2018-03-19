package com.tong467.hellowrold.web.controller;

import com.tong467.hellowrold.entity.ResMsg;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("")
    public ResMsg index() {
        ResMsg<String> regMsg = new ResMsg<>();
        regMsg.setData("Hello World");
        return regMsg;
    }


    @RequestMapping("header")
    public ResMsg header(
            @RequestHeader(name = "X-Request-Id", required = false, defaultValue = "missing") String requestId,
            HttpServletRequest request) {
        String token = request.getHeader("token");
        ResMsg<Map> regMsg = new ResMsg<>();
        Map<String, String> map = new HashMap();
        map.put("X-Request-Id", requestId);
        map.put("token", token);
        regMsg.setData(map);
        return regMsg;
    }


    @RequestMapping("pathVariable/user/{userId}/order/{orderNo}")
    public ResMsg pathVariable(@PathVariable("userId") String userId, @PathVariable("orderNo") String orderNo) {
        ResMsg<Map> regMsg = new ResMsg<>();
        Map<String, String> map = new HashMap();
        map.put("userId", userId);
        map.put("orderNo", orderNo);
        regMsg.setData(map);
        return regMsg;
    }

    @RequestMapping("parameter")
    public ResMsg parameter(@RequestParam(name = "1key") String key1, String key2, HttpServletRequest request) {
        String key3 = request.getParameter("key3");
        ResMsg<Map> regMsg = new ResMsg<>();
        Map<String, String> map = new HashMap();
        map.put("1key", key1);
        map.put("key2", key2);
        map.put("key3", key3);
        regMsg.setData(map);
        return regMsg;
    }


}
