package com.liujinchai.INI;

import com.liujinchai.mapper.ShopGoodDao;
import com.liujinchai.mapper.ShopGoodOrderDao;
import com.liujinchai.mapper.ShopOrderDao;
import com.liujinchai.mapper.ShopUserDao;
import com.liujinchai.pojo.ShopGood;
import com.liujinchai.pojo.ShopGoodOrder;
import com.liujinchai.pojo.ShopOrder;
import com.liujinchai.pojo.ShopUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * @Author: cytern
 * @Date: 2020/6/9 17:40
 */
@Component
public class Cart {
    @Autowired
    private ShopGoodDao goodDao;
    @Autowired
    private ShopGoodOrderDao goodOrderDao;
    @Autowired
    private ShopOrderDao orderDao;
    @Autowired
    private ShopUserDao userDao;
    @Autowired
    ChangeTotalPrice changeTotalPrice =new ChangeTotalPrice();
    public void addCart(int goodId, HttpSession session){
        ShopUser shopUser = (ShopUser) session.getAttribute("user");
        System.out.println(shopUser);
        ShopOrder shopOrder = orderDao.getOrderById(shopUser.getUserId());
        ShopGood shopGood = goodDao.selectByPrimaryKey(goodId);
        if (shopGood.getGoodId() == 0){
            return;
        }
        ShopGoodOrder shopGoodOrder = new ShopGoodOrder();
        shopGoodOrder.setUserId(shopUser.getUserId());
        shopGoodOrder.setGoodId(goodId);
        shopGoodOrder.setGoodName(shopGood.getGoodName());
        shopGoodOrder.setGoodNum(1);
        shopGoodOrder.setGoodPrice(shopGood.getGoodPrice());
        shopGoodOrder.setOrderId(shopOrder.getOrderId());
        shopGoodOrder.setGoodUrl(shopGood.getGoodUrl());
        goodOrderDao.insertSelective(shopGoodOrder);
        changeTotalPrice.checkPrice(shopOrder.getOrderId());
        return;
    }
    public void removeCart(int goodOrderId,HttpSession session){
        ShopUser shopUser = (ShopUser) session.getAttribute("user");
        ShopOrder shopOrder = orderDao.getOrderById(shopUser.getUserId());
        goodOrderDao.deleteByPrimaryKey(goodOrderId);
        changeTotalPrice.checkPrice(shopOrder.getOrderId());
        return;
    }
}
