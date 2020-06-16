package com.liujinchai.controller;

import com.liujinchai.INI.BannerData;
import com.liujinchai.INI.Type;
import com.liujinchai.mapper.ShopGoodDao;
import com.liujinchai.mapper.ShopGoodOrderDao;
import com.liujinchai.mapper.ShopOrderDao;
import com.liujinchai.mapper.ShopUserDao;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.GenericFilter;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Controller
public class PageController {
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

    @RequestMapping({"/","/index"})
    public String index(Model model, HttpSession session) {
        model = type.getType(model);
        model = bannerData.getBannerData(model,session);
        return "index";
    }

    @RequestMapping("/page/category/{type}")
    public String shopBy(Model model, HttpSession session, @PathVariable int type)
    {
        model = bannerData.getBannerData(model,session);
        return "category";
    }
    @RequestMapping("/page/categoryNone")
    public String shopBy123(Model model, HttpSession session)
    {
        model = type.getType(model);
        model = bannerData.getBannerData(model,session);
        return "category";
    }


    @RequestMapping("/page/blog")
    public String blog(Model model,HttpSession session)
    {
        model = type.getType(model);
        model = bannerData.getBannerData(model,session);
        return "blog";
    }
    @RequestMapping("/page/faq")
    public String faq(Model model,HttpSession session) {
        model = type.getType(model);
        model = bannerData.getBannerData(model,session);
        return "faq";
    }
    @RequestMapping("/page/about_us")
    public String aboutUs(Model model,HttpSession session){
        model = type.getType(model);
        model = bannerData.getBannerData(model,session);
        return "about_us";
    }
    @RequestMapping("/page/contact_us")
    public String contactUs(Model model,HttpSession session){
        model = type.getType(model);
        model = bannerData.getBannerData(model,session);
        return "contact_us";
    }
    @RequestMapping("/page/account_login")
    public String login(Model model,HttpSession session){
        model = type.getType(model);
        return "account_login";
    }
    @RequestMapping("/page/account_create")
    public String creatUser(Model model,HttpSession session) {
        model = type.getType(model);
        return "account_create";
    }
    @RequestMapping("/page/404_error")
    public String error(Model model,HttpSession session){
        model = type.getType(model);
        model = bannerData.getBannerData(model,session);
        return "404_error";
    }
    @RequestMapping("/page/cart")
    public String cart(Model model,HttpSession session){
        model = type.getType(model);
        model = bannerData.getBannerData(model,session);
        return "cart";
    }
    @RequestMapping("/logout")
    public String logout(Model model,HttpSession session){
        session.invalidate();
        model = type.getType(model);
        return "account_login";
    }
}
