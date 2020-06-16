package com.liujinchai.controller;

import com.liujinchai.mapper.ShopGoodDao;
import com.liujinchai.mapper.ShopGoodOrderDao;
import com.liujinchai.mapper.ShopOrderDao;
import com.liujinchai.mapper.ShopUserDao;
import com.liujinchai.pojo.ShopUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @Author: cytern
 * @Date: 2020/6/9 16:50
 */
@Controller
public class LoginController {

    @Autowired
    private ShopGoodDao goodDao;
    @Autowired
    private ShopGoodOrderDao goodOrderDao;
    @Autowired
    private ShopOrderDao orderDao;
    @Autowired
    private ShopUserDao userDao;
@RequestMapping("login/user/login")
    public String login(@RequestParam String userName,
                        @RequestParam String password,
                        HttpSession session,
                        Model model
    ){
        ShopUser shopUser = userDao.getByUserName(userName);
        if (password.equals(shopUser.getUserPassword())){
            Date date = new Date();
            String acc = date + String.valueOf(date.hashCode());
            session.setAttribute("user",shopUser);
            session.setAttribute("User-Token",acc);
            return "redirect:/";

        }else {
            model.addAttribute("msg","登录失败，账号或密码错误");
            return "account_login";
        }
    }
}
