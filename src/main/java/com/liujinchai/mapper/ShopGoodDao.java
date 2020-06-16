package com.liujinchai.mapper;

import com.liujinchai.pojo.ShopGood;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ShopGoodDao {
    int deleteByPrimaryKey(Integer goodId);

    int insert(ShopGood record);

    int insertSelective(ShopGood record);

    ShopGood selectByPrimaryKey(Integer goodId);

    int updateByPrimaryKeySelective(ShopGood record);

    int updateByPrimaryKey(ShopGood record);

    List<ShopGood> getAllGood();
}