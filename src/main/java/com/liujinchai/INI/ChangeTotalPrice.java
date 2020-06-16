package com.liujinchai.INI;

import com.liujinchai.mapper.ShopGoodDao;
import com.liujinchai.mapper.ShopGoodOrderDao;
import com.liujinchai.mapper.ShopOrderDao;
import com.liujinchai.mapper.ShopUserDao;
import com.liujinchai.pojo.ShopGoodOrder;
import com.liujinchai.pojo.ShopOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: cytern
 * @Date: 2020/6/9 17:32
 */
@Component
public class ChangeTotalPrice {
    @Autowired
    private ShopGoodDao goodDao;
    @Autowired
    private ShopGoodOrderDao goodOrderDao;
    @Autowired
    private ShopOrderDao orderDao;
    @Autowired
    private ShopUserDao userDao;
    @Autowired
    BannerData bannerData =new BannerData();
    @Autowired
    Type type =new Type();

    public void checkPrice(int oderId){
        ShopOrder order = orderDao.selectByPrimaryKey(oderId);
        System.out.println(124214521);
        List<ShopGoodOrder> goodOrders = goodOrderDao.getAllGoodOrder(order.getOrderId());
        BigDecimal bigDecimal = new BigDecimal(0);
        for (ShopGoodOrder goodOrder :goodOrders){
           bigDecimal = bigDecimal.add(goodOrder.getGoodPrice().multiply(BigDecimal.valueOf(goodOrder.getGoodNum())));
        }
        System.out.println(bigDecimal);
        order.setTotalPrice(bigDecimal);
        orderDao.updateByPrimaryKeySelective(order);
    }

}
