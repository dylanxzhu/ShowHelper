package com.yuewawa.showhelper.biz.impl;

import android.content.Context;

import com.yuewawa.showhelper.biz.IUserBiz;
import com.yuewawa.showhelper.dao.gen.UserDao;
import com.yuewawa.showhelper.db.GreenDaoHelper;
import com.yuewawa.showhelper.entity.User;

import java.util.List;

/**
 * Created by yuewawa on 2016-10-07.
 */
public class UserBiz implements IUserBiz {

    private UserDao userDao;

    public UserBiz(Context context) {
        userDao = GreenDaoHelper.getInstance().getDaoSession(context).getUserDao();
    }

    @Override
    public long userRegister(User user) {
        return userDao.insert(user);
    }

    @Override
    public List<User> userLogin(String userName, String userPassword) {
        String whereSql = "WHERE USER_NAME=? AND USER_PASSWORD=?";
        return userDao.queryRaw(whereSql, userName, userPassword);
    }
}
