package com.liujinchai.mapper;

import com.liujinchai.pojo.ShopUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ShopUserDao {
    int deleteByPrimaryKey(Integer userId);

    int insert(ShopUser record);

    int insertSelective(ShopUser record);

    ShopUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(ShopUser record);

    int updateByPrimaryKey(ShopUser record);

    ShopUser getByUserName(String userName);
}