package com.yuewawa.showhelper.activity;

import android.app.FragmentManager;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yuewawa.showhelper.R;
import com.yuewawa.showhelper.constant.CustomConstant;
import com.yuewawa.showhelper.fragment.BaseFragment;

public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";

    public static String currentTag = "";
    private String tag;
    private FragmentManager fm;
    private BaseFragment baseFragment;

    private TextView homeTabTxt, favoriteTabTxt, mineTabTxt;
    private RelativeLayout homeTabRel, favoriteTabRel, mineTabRel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        initViews();
        setDefaultFragment();
    }

    @Override
    protected void onStop() {
        super.onStop();
        currentTag = "";
    }

    private void setDefaultFragment() {
        baseFragment = new BaseFragment();
        fm = getFragmentManager();
        baseFragment.setDefaultFragment(R.id.fragment_content, CustomConstant.HOME_FRAGMENT, currentTag, fm);
        setDefaultTabColor();
    }

    private void setDefaultTabColor() {
        homeTabTxt.setSelected(true);
        homeTabRel.setSelected(true);
    }

    private void resetTabColor() {
        homeTabTxt.setSelected(false);
        homeTabRel.setSelected(false);
        favoriteTabTxt.setSelected(false);
        favoriteTabRel.setSelected(false);
        mineTabTxt.setSelected(false);
        mineTabRel.setSelected(false);
    }

    @Override
    protected void initViews() {
        Log.e(TAG, "initViews()");

        homeTabTxt = (TextView) findViewById(R.id.home_tab_txt);
        favoriteTabTxt = (TextView) findViewById(R.id.favorite_tab_txt);
        mineTabTxt = (TextView) findViewById(R.id.mine_tab_txt);

        homeTabTxt.setOnClickListener(this);
        favoriteTabTxt.setOnClickListener(this);
        mineTabTxt.setOnClickListener(this);

        homeTabRel = (RelativeLayout) findViewById(R.id.home_tab_rel);
        favoriteTabRel = (RelativeLayout) findViewById(R.id.favorite_tab_rel);
        mineTabRel = (RelativeLayout) findViewById(R.id.mine_tab_rel);
    }


    @Override
    public void onClick(View view) {
        resetTabColor();
        switch (view.getId()) {
            case R.id.home_tab_txt:
                homeTabTxt.setSelected(true);
                homeTabRel.setSelected(true);
                tag = CustomConstant.HOME_FRAGMENT;
                break;
            case R.id.favorite_tab_txt:
                favoriteTabTxt.setSelected(true);
                favoriteTabRel.setSelected(true);
                tag = CustomConstant.FAVORITE_FRAGMENT;
                break;
            case R.id.mine_tab_txt:
                mineTabTxt.setSelected(true);
                mineTabRel.setSelected(true);
                tag = CustomConstant.MINE_FRAGMENT;
                break;
        }
        baseFragment.changeFragment(R.id.fragment_content, tag, currentTag, fm);
    }
}
