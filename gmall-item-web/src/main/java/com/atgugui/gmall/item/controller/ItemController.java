package com.atgugui.gmall.item.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin
public class ItemController {

    @RequestMapping("index")
    public String index(ModelMap modelMap){

        modelMap.put("hello","hello world");
        return "index";
    }


}
