package com.tong467.hellowrold.dao.goods;

import com.tong467.hellowrold.dao.goods.provider.GoodsProvider;
import com.tong467.hellowrold.entity.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodsMapper {

    int insert(Goods goods);


    int insertBatch(List<Goods> goodsList);


    @Insert("INSERT INTO test.goods (name, price, `describe`, status, create_time, update_time, user_id) " +
                    "VALUES (#{name}, #{price}, #{describe}, #{status}, #{createTime}, #{updateTime}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insertByAnnotation(Goods goods);

    int delete(@Param("id") int id);

    @Delete("delete from goods where id = #{id}")
    int deleteByAnnotation(@Param("id") int id);

    @Update("update goods set name=#{name}, price = #{price}, " +
                    "`describe`=#{describe}, status=#{status}, " +
                    "update_time =#{updateTime}, user_id=#{userId}" +
                    " where id = #{id}")
    int updateByAnnotation(Goods goods);

    int updateByPrimaryKeySelective(Goods goods);

    /**
     * 根据id获取商品信息
     *
     * @param id id
     * @return
     */
    Goods selectById(@Param("id") int id);

    /**
     * 根据添加人获取商品信息
     *
     * @param userId userId
     * @return
     */
    List<Goods> selectByUserId(@Param("userId") int userId);

    @Select("select id,name,price ,`describe`,status,create_time,update_time,user_id from goods where id = #{id}")
    Goods selectByIdByAnnotation(@Param("id") int id);


    @Select("select id,name,price ,`describe`,status,create_time,update_time,user_id from goods where user_id = #{userId};")
    List<Goods> selectByUserIdByAnnotation(@Param("userId") int userId);


    @SelectProvider(type = GoodsProvider.class, method = "selectByUserId")
    List<Goods> selectByUserIdByProvider(@Param("userId") int userId);


}
