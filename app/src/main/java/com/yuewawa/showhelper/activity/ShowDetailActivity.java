package com.yuewawa.showhelper.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.yuewawa.showhelper.R;
import com.yuewawa.showhelper.dao.ShowDao;
import com.yuewawa.showhelper.entity.Show;

import java.sql.SQLException;

/**
 * Created by yuewawa on 2016-07-30.
 */
public class ShowDetailActivity extends BaseActivity{

    private static final String TAG = "ShowDetailActivity";

    private Intent intent;

    private TextView showNameTxt, showStatusTxt;
    private Show show;
    private ShowDao showDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate()");
        setContentView(R.layout.show_detail);
        initViews();

        setShowDetail();
    }

    private void setShowDetail() {
        intent = getIntent();
        int id = intent.getExtras().getInt("id");
        showDao = new ShowDao(this);
        try {
            show = showDao.getOneById(id);
            showNameTxt.setText(show.getShowName());
            showStatusTxt.setText(show.getShowStatus());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void initViews() {
        showNameTxt = (TextView) findViewById(R.id.show_name_txt);
        showStatusTxt = (TextView) findViewById(R.id.show_status_txt);
    }

    @Override
    public void onClick(View view) {

    }
}
