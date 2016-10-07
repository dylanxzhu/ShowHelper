package com.yuewawa.showhelper.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.yuewawa.showhelper.R;
import com.yuewawa.showhelper.entity.Show;


/**
 * Created by yuewawa on 2016-07-30.
 */
public class ShowDetailActivity extends Activity {

    private static final String TAG = "ShowDetailActivity";

    private Intent intent;

    private TextView showNameTxt, showStatusTxt;
    private Show show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate()");
        setContentView(R.layout.show_detail);
        initViews();
    }

    protected void initViews() {
        showNameTxt = (TextView) findViewById(R.id.show_name_txt);
        showStatusTxt = (TextView) findViewById(R.id.show_status_txt);
    }
}
