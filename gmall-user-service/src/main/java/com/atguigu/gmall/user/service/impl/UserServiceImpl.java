package com.atguigu.gmall.user.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.UserMessage;
import com.atguigu.gmall.service.UserService;
import com.atguigu.gmall.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public List<UserMessage> getAllUserMessage() {

        List<UserMessage> userMessages = userMapper.selectAllUser();
        return userMessages;
    }

    @Override
    public List<UserMessage> getIdUser(int id) {

        Example example = new Example(UserMessage.class);
        System.out.println(id);
        example.createCriteria().andEqualTo("id",String.valueOf(id));
        System.out.println(example.toString());

//        UserMessage userMessage = new UserMessage();
//        userMessage.setId(String.valueOf(id));

        List<UserMessage> userMessages = userMapper.selectByExample(example);

//        List<UserMessage> userMessages = userMapper.select(userMessage);userMapper.selectByExample(example);


        return userMessages;

    }


}
