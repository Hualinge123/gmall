package com.atguigu.gmall.user.mapper;


import com.atguigu.gmall.bean.UserMessage;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

//Mapper<UserMessage>
@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<UserMessage> {

     List<UserMessage> selectAllUser();
}
