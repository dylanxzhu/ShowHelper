package com.yuewawa.showhelper.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.yuewawa.showhelper.dao.gen.DaoMaster;
import com.yuewawa.showhelper.dao.gen.DaoSession;

/**
 * Created by yuewawa on 2016-10-07.
 */
public class GreenDaoHelper {

    private DaoMaster daoMaster;
    private DaoMaster.DevOpenHelper helper;
    private DaoSession daoSession;
    private SQLiteDatabase db;

    private static GreenDaoHelper instance;
    public static GreenDaoHelper getInstance() {
        if (instance == null) {
            instance = new GreenDaoHelper();
        }
        return instance;
    }

    private void initGreenDao(Context context) {
        helper = new DaoMaster.DevOpenHelper(context, "showhelper", null);
        db = helper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public DaoSession getDaoSession(Context context) {
        if (daoSession == null) {
            initGreenDao(context);
        }
        return daoSession;
    }

    public SQLiteDatabase getDb(Context context) {
        if (db == null) {
            initGreenDao(context);
        }
        return db;
    }
}
