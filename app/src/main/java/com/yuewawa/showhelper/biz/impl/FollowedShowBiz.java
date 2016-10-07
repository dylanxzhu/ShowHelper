package com.yuewawa.showhelper.biz.impl;

import android.content.Context;

import com.yuewawa.showhelper.biz.IFollowedShowBiz;
import com.yuewawa.showhelper.dao.gen.FollowedShowDao;
import com.yuewawa.showhelper.db.GreenDaoHelper;
import com.yuewawa.showhelper.entity.FollowedShow;

import java.util.List;

/**
 * Created by Administrator on 2016-10-07.
 */
public class FollowedShowBiz implements IFollowedShowBiz{

    private FollowedShowDao followedShowDao;

    public FollowedShowBiz(Context context) {
        followedShowDao = GreenDaoHelper.getInstance().getDaoSession(context).getFollowedShowDao();
    }

    @Override
    public List<FollowedShow> getAllFollowedShows(Long userId) {
        String whereSql = "WHERE USER_ID=?";
        return followedShowDao.queryRaw(whereSql, String.valueOf(userId));
    }
}
