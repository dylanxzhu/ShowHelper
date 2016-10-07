package com.yuewawa.showhelper.biz;

import com.yuewawa.showhelper.entity.User;

import java.util.List;

/**
 * Created by yuewawa on 2016-10-07.
 */
public interface IUserBiz {

    /**
     * 用户注册
     * @param user 用户
     * @return
     * */
    public long userRegister(User user);

    /**
     * 用户登录
     * @param userName
     * @param userPassword
     * @return
     * */
    public List<User> userLogin(String userName, String userPassword);
}
