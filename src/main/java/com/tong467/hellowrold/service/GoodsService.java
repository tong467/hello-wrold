package com.tong467.hellowrold.service;

import com.tong467.hellowrold.entity.Goods;

import java.util.List;

public interface GoodsService {

    int insert(Goods goods);

    int insertByAnnotation(Goods goods);

    int insertBatch(List<Goods> goodsList);

    int delete(int id);

    int deleteByAnnotation(int id);

    int update(Goods goods);

    int updateByAnnotation(Goods goods);

    Goods findById(int id);

    List<Goods> findByUserId(int userId);

    Goods findByIdByAnnotation(int id);

    List<Goods> findByUserIdByAnnotation(int userId);

    List<Goods> findByUserIdByProvider(int userId);
}
