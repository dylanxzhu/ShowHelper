package com.yuewawa.showhelper.biz.impl;

import android.content.Context;

import com.yuewawa.showhelper.biz.IShowBiz;
import com.yuewawa.showhelper.dao.gen.ShowDao;
import com.yuewawa.showhelper.db.GreenDaoHelper;
import com.yuewawa.showhelper.entity.Show;

/**
 * Created by yuewawa on 2016-10-07.
 */
public class ShowBiz implements IShowBiz{

    private ShowDao showDao;

    public ShowBiz(Context context) {
        showDao = GreenDaoHelper.getInstance().getDaoSession(context).getShowDao();
    }

    @Override
    public long showAdd(Show show) {
        return showDao.insert(show);
    }
}
