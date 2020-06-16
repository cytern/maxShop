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
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: cytern
 * @Date: 2020/6/9 16:47
 */
@Component
public class BannerData {
    @Autowired
    private ShopGoodDao goodDao;
    @Autowired
    private ShopGoodOrderDao goodOrderDao;
    @Autowired
    private ShopOrderDao orderDao;
    @Autowired
    private ShopUserDao userDao;
    public Model getBannerData(Model model, HttpSession session){
        ShopUser shopUser = (ShopUser) session.getAttribute("user");
        ShopOrder order = orderDao.getOrderById(shopUser.getUserId());
        List<ShopGood> goods = goodDao.getAllGood();
        model.addAttribute("goods",goods);
        if (order.getOrderId() != 0){
            List<ShopGoodOrder> goodOrders = goodOrderDao.getAllGoodOrder(order.getOrderId());
            int maxCount = goodOrders.size();
            model.addAttribute("maxCount",maxCount);
            model.addAttribute("goodOrders",goodOrders);
            model.addAttribute("order",order);
            model.addAttribute("adviceList",goods);
            model.addAttribute("goodList",goods);
            return model;
        }else {
            ShopOrder order1 = new ShopOrder();
            order1.setUserId(shopUser.getUserId());
            order1.setOrderStatus("1");
            orderDao.insertSelective(order1);
            model.addAttribute("order",order);
            List<ShopGoodOrder> shopGoodOrders = new ArrayList<>();
            model.addAttribute("goodOrders",shopGoodOrders);
            int maxCount = shopGoodOrders.size();
            model.addAttribute("maxCount",maxCount);
            model.addAttribute("adviceList",goods);
            model.addAttribute("goodList",goods);
            return model;
        }

    }
}
