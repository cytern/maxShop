package com.liujinchai.INI;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: cytern
 * @Date: 2020/6/9 17:23
 */
@Component
public class Type {
    public Model getType(Model model){
        List<Map<String,String>> types = new ArrayList<>();
        model.addAttribute("type",types);
        return model;
    }
}
