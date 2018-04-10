package com.tong467.hellowrold.web.controller;

import com.tong467.hellowrold.entity.ResMsg;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ConfigController {
    @Value(value = "${spring.application.name}")
    private String appName;
    @Value(value = "${spring.application.index}")
    private String appIndex;

    @RequestMapping(value = "config")
    private ResMsg getConfig() {
        Map<String, Object> map = new HashMap<>();
        map.put("appName", appName);
        map.put("appIndex", appIndex);

        return new ResMsg(map);
    }
}
