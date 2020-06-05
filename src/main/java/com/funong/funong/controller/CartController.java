package com.funong.funong.controller;

import com.funong.funong.backPojo.BackOrderOne;
import com.funong.funong.mapper.GoodorderDao;
import com.funong.funong.mapper.OrderDao;
import com.funong.funong.plugin.ChangeDate;
import com.funong.funong.plugin.CheckOrderPrice;
import com.funong.funong.plugin.GetMyOrder;
import com.funong.funong.plugin.GetPageIndex;
import com.funong.funong.pojo.Customer;
import com.funong.funong.pojo.Goodorder;
import com.funong.funong.pojo.Order;
import com.funong.funong.pojo.User;
import com.funong.funong.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @Author: cytern
 * @Date: 2020/5/26 10:56
 */
@Controller
public class CartController {
    @Autowired
    CheckOrderPrice checkOrderPrice = new CheckOrderPrice();
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private GoodorderDao goodorderDao;
    @Autowired
    GetMyOrder getMyOrder = new GetMyOrder();
    GetPageIndex getPageIndex = new GetPageIndex();
    ChangeDate changeDate = new ChangeDate();
    @RequestMapping("addCart/{goodid}")
    public String addCart(Model model, HttpSession session, @PathVariable int goodid){
        Customer customer = (Customer)session.getAttribute("customer");
        User user = (User)session.getAttribute("user");
        BackOrderOne backOrderOne = (BackOrderOne) session.getAttribute("cart");
        Goodorder goodorder = new Goodorder();
        goodorder.setOrderid(backOrderOne.getOrderid());
        goodorder.setUpdatetime(changeDate.getDate());
        goodorder.setUpdatetime(changeDate.getDate());
        goodorder.setGoodnum(1);
        goodorder.setGoodid(goodid);
        goodorderDao.insertSelective(goodorder);
        checkOrderPrice.checkOrderPrice(backOrderOne.getOrderid());
        return "redirect:/page/index";
    }

    @RequestMapping("removeCart/{goodOrderid}")
    public String removeCart(Model model,HttpSession session,@PathVariable int goodOrderid){
        Goodorder goodorder = goodorderDao.selectByPrimaryKey(goodOrderid);
        Order order  = orderDao.selectByPrimaryKey(goodorder.getOrderid());
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer.getCustomerId() == order.getCustomerid()){
            goodorderDao.deleteByPrimaryKey(goodOrderid);
            checkOrderPrice.checkOrderPrice(order.getOrderid());
        }
        return "redirect:/page/index";
    }
}
