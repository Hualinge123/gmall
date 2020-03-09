package com.atguigu.gmall.user.controller;

import com.atguigu.gmall.bean.UserMessage;
import com.atguigu.gmall.user.controller.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("alluser")
    @ResponseBody
    public List<UserMessage> getAllUser(){
       List<UserMessage> allUserMessage = userService.getAllUserMessage();
       return allUserMessage;

    }

    @RequestMapping("selectById")
    @ResponseBody
    public List<UserMessage> getIdUser(@RequestParam int id){

        return  userService.getIdUser(id);
    }

}
