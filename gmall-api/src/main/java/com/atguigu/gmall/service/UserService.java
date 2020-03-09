package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.UserMessage;

import java.util.List;

public interface UserService {

      List<UserMessage> getAllUserMessage();

      List<UserMessage> getIdUser(int id);
}
