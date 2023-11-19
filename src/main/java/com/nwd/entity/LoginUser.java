package com.nwd.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName(value = "nwd_user")
public class LoginUser {

    private Long id;

    private String username;

    private String password;

    @TableField(value = "memorySize")
    private int memorySize=1;


    public LoginUser() {
    }

    public LoginUser(Long id, String username, String password, int memorySize) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.memorySize = memorySize;
    }

    @Override
    public String toString() {
        return "LoginUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }
}
