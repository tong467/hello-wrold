package com.tong467.hellowrold.web.controller;

import com.tong467.hellowrold.entity.Goods;
import com.tong467.hellowrold.entity.ResMsg;
import com.tong467.hellowrold.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @PostMapping("")
    public ResMsg insert(@RequestBody Goods goods) {
        goodsService.insert(goods);
        Map<String, Integer> map = new HashMap<>();
        map.put("id", goods.getId());
        return new ResMsg(map);
    }


    @PostMapping("insertByAnnotation")
    public ResMsg insertByAnnotation(@RequestBody Goods goods) {
        goodsService.insertByAnnotation(goods);
        Map<String, Integer> map = new HashMap<>();
        map.put("id", goods.getId());
        return new ResMsg(map);
    }


    @PostMapping("insertBatch")
    public ResMsg insertBatch(@RequestBody List<Goods> goodsList) {
        int total = goodsService.insertBatch(goodsList);
        Map<String, Integer> map = new HashMap<>();
        map.put("total", total);
        return new ResMsg(map);
    }

    @DeleteMapping("/{id}")
    public ResMsg delete(@PathVariable(value = "id") int id) {
        int restult = goodsService.delete(id);
        Map<String, Integer> map = new HashMap<>();
        map.put("number", restult);
        return new ResMsg(map);
    }


    @DeleteMapping("deleteByAnnotation/{id}")
    public ResMsg deleteByAnnotation(@PathVariable(value = "id") int id) {
        int restult = goodsService.deleteByAnnotation(id);
        Map<String, Integer> map = new HashMap<>();
        map.put("number", restult);
        return new ResMsg(map);
    }

    @PutMapping("")
    public ResMsg update(@RequestBody Goods goods) {
        int restult = goodsService.update(goods);
        Map<String, Integer> map = new HashMap<>();
        map.put("number", restult);
        return new ResMsg(map);
    }


    @PutMapping("updateByAnnotation")
    public ResMsg updateByAnnotation(@RequestBody Goods goods) {
        int restult = goodsService.updateByAnnotation(goods);
        Map<String, Integer> map = new HashMap<>();
        map.put("number", restult);
        return new ResMsg(map);
    }


    @GetMapping("/{id}")
    public ResMsg<Goods> findById(@PathVariable("id") int id) {
        return new ResMsg<Goods>(goodsService.findById(id));
    }

    @GetMapping("/listByUser")
    public ResMsg<List<Goods>> findByUserId(@RequestParam("userId") int userId) {
        return new ResMsg<List<Goods>>(goodsService.findByUserId(userId));
    }

    @GetMapping("/byAnnotation/{id}")
    public ResMsg<Goods> findByIdByAnnotation(@PathVariable("id") int id) {
        return new ResMsg<Goods>(goodsService.findById(id));
    }

    @GetMapping("/byAnnotation/listByUser")
    public ResMsg<List<Goods>> findByUserIdByAnnotation(@RequestParam("userId") int userId) {
        return new ResMsg<List<Goods>>(goodsService.findByUserId(userId));
    }


    @GetMapping("/byProvider/listByUser")
    public ResMsg<List<Goods>> findByUserIdByProvider(@RequestParam("userId") int userId) {
        return new ResMsg<List<Goods>>(goodsService.findByUserIdByProvider(userId));
    }

}
