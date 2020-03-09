package com.atguigu.gmall.bean;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name="ums_member")
public class UserMessage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public  String id;
    public  String member_level_id;
    public  String username;
    public  String password;
    public  String nickname;
    public  String phone;
    public  int status;
    public  Date create_time;
//    public  String icon;
//    public  String gender;
//    public  Date birthday;
//    public  String city;
//    public  String job;
//    public  String personalized_signature;
//    public  String source_type;
//    public  int integration;
//    public  String growth;
//    public  String luckey_count;
//    public  String history_integration;


    public UserMessage(String id, String member_level_id, String username, String password, String nickname, String phone, int status, Date create_time) {
        this.id = id;
        this.member_level_id = member_level_id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.phone = phone;
        this.status = status;
        this.create_time = create_time;
    }

    public UserMessage() {
    }

    public String getId() {
        return id;
    }

    public String getMember_level_id() {
        return member_level_id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPhone() {
        return phone;
    }

    public int getStatus() {
        return status;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMember_level_id(String member_level_id) {
        this.member_level_id = member_level_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "UserMessage{" +
                "id='" + id + '\'' +
                ", member_level_id='" + member_level_id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", phone=" + phone +
                ", status=" + status +
                ", create_time=" + create_time +
                '}';
    }
}
