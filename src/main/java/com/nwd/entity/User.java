package com.nwd.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"password"})
public class User {
    @TableId(value = "id")
    private Long id;
    private String username;


    private String password;

    private String imgurl;

    private Integer mgstate;

    //姓名
    private String fullname;

    //手机号
    private String mobile;

    //邮箱
    private String email;

    @TableField(value = "memorySize")
    private int memorySize;

    public User() {
    }

    public User( String username,String password ,String imgurl, Integer mgstate, String fullname, String mobile, String email, int memorySize) {
        this.username = username;
        this.password=password;
        this.imgurl = imgurl;
        this.mgstate = mgstate;
        this.fullname = fullname;
        this.mobile = mobile;
        this.email = email;
        this.memorySize = memorySize;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", imgurl='" + imgurl + '\'' +
                ", mgstate=" + mgstate +
                ", fullname='" + fullname + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", memorySize=" + memorySize +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public Integer getMgstate() {
        return mgstate;
    }

    public void setMgstate(Integer mgstate) {
        this.mgstate = mgstate;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
