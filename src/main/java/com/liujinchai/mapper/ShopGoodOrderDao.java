package com.liujinchai.mapper;

import com.liujinchai.pojo.ShopGoodOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ShopGoodOrderDao {
    int deleteByPrimaryKey(Integer goodOrderId);

    int insert(ShopGoodOrder record);

    int insertSelective(ShopGoodOrder record);

    ShopGoodOrder selectByPrimaryKey(Integer goodOrderId);

    int updateByPrimaryKeySelective(ShopGoodOrder record);

    int updateByPrimaryKey(ShopGoodOrder record);

    List<ShopGoodOrder> getAllGoodOrder(Integer orderId);
}