package com.liujinchai.mapper;

import com.liujinchai.pojo.ShopOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ShopOrderDao {
    int deleteByPrimaryKey(Integer orderId);

    int insert(ShopOrder record);

    int insertSelective(ShopOrder record);

    ShopOrder selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(ShopOrder record);

    int updateByPrimaryKey(ShopOrder record);

    ShopOrder getOrderById(Integer userId);
}