package com.yuewawa.showhelper.dao;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.yuewawa.showhelper.db.DBHelper;
import com.yuewawa.showhelper.entity.Show;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by yuewawa on 2016-07-30.
 */
public class ShowDao {

    private DBHelper dbHelper;
    private Dao<Show, Integer> dao;

    public ShowDao(Context context) {
        dbHelper = new DBHelper(context);
        dao = dbHelper.getDao(Show.class);
    }

    public void add(Show show) throws SQLException {
        dao.create(show);
    }

    public List<Show> getAll() throws SQLException {
        return dao.queryForAll();
    }

    /**
     * 通过星期查询
     *
     * @param updatedWeek 更新的星期
     * @return
     */
    public List<Show> getAllByWeek(String updatedWeek) throws SQLException {
        return dao.queryBuilder().where().eq("updatedWeek", updatedWeek).query();
    }

    /**
     * 通过id查询数据
     *
     * @param id
     * @return
     */
    public Show getOneById(int id) throws SQLException {
        return dao.queryForId(id);
    }

    public int update(Show show) throws SQLException {
        return dao.update(show);
    }
}