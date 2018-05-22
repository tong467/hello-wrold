package com.tong467.hellowrold.service.impl;

import com.tong467.hellowrold.dao.goods.GoodsMapper;
import com.tong467.hellowrold.entity.Goods;
import com.tong467.hellowrold.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public int insert(Goods goods) {
        Long dataTime = System.currentTimeMillis();
        goods.setStatus(0);
        goods.setCreateTime(dataTime);
        goods.setUpdateTime(dataTime);
        return goodsMapper.insert(goods);
    }

    @Override
    public int insertByAnnotation(Goods goods) {
        Long dataTime = System.currentTimeMillis();
        goods.setStatus(0);
        goods.setCreateTime(dataTime);
        goods.setUpdateTime(dataTime);
        return goodsMapper.insertByAnnotation(goods);
    }

    @Override
    public int insertBatch(List<Goods> goodsList) {
        Long dataTime = System.currentTimeMillis();
        goodsList.forEach(p -> {
            p.setStatus(0);
            p.setCreateTime(dataTime);
            p.setUpdateTime(dataTime);
        });
        return goodsMapper.insertBatch(goodsList);
    }

    @Override
    public int delete(int id) {
        return goodsMapper.delete(id);
    }

    @Override
    public int deleteByAnnotation(int id) {
        return goodsMapper.deleteByAnnotation(id);
    }

    @Override
    public int update(Goods goods) {
        Long dataTime = System.currentTimeMillis();
        goods.setUpdateTime(dataTime);
        return goodsMapper.updateByPrimaryKeySelective(goods);
    }

    @Override
    public int updateByAnnotation(Goods goods) {
        Long dataTime = System.currentTimeMillis();
        goods.setUpdateTime(dataTime);
        return goodsMapper.updateByAnnotation(goods);
    }

    @Override
    public Goods findById(int id) {
        return goodsMapper.selectById(id);
    }

    @Override
    public List<Goods> findByUserId(int userId) {
        return goodsMapper.selectByUserId(userId);
    }

    @Override
    public Goods findByIdByAnnotation(int id) {
        return goodsMapper.selectByIdByAnnotation(id);
    }

    @Override
    public List<Goods> findByUserIdByAnnotation(int userId) {
        return goodsMapper.selectByUserIdByAnnotation(userId);
    }

    @Override
    public List<Goods> findByUserIdByProvider(int userId) {
        return goodsMapper.selectByUserIdByProvider(userId);
    }





}
