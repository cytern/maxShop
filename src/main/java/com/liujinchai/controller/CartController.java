package com.liujinchai.controller;


import com.liujinchai.INI.Cart;
import com.liujinchai.mapper.ShopGoodDao;
import com.liujinchai.mapper.ShopGoodOrderDao;
import com.liujinchai.mapper.ShopOrderDao;
import com.liujinchai.mapper.ShopUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: cytern
 * @Date: 2020/5/26 10:56
 */
@Controller
public class CartController {
    @Autowired
    private ShopGoodDao goodDao;
    @Autowired
    private ShopGoodOrderDao goodOrderDao;
    @Autowired
    private ShopOrderDao orderDao;
    @Autowired
    private ShopUserDao userDao;
    @Autowired
    Cart cart = new Cart();

    @RequestMapping("addCart/{goodId}")
    public String addCart(Model model, HttpSession session, @PathVariable int goodId){
      cart.addCart(goodId,session);

        return "redirect:/index";
    }

    @RequestMapping("removeCart/{goodOrderid}")
    public String removeCart(Model model,HttpSession session,@PathVariable int goodOrderid){
 cart.removeCart(goodOrderid,session);
        return "redirect:/index";
    }

}
