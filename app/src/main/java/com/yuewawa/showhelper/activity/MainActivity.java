package com.yuewawa.showhelper.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yuewawa.showhelper.R;
import com.yuewawa.showhelper.constant.CustomConstant;
import com.yuewawa.showhelper.fragment.BaseFragment;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.main)
public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    public static String currentTag = "";
    private String tag;
    private FragmentManager fm;
    private BaseFragment baseFragment;

    @ViewById(R.id.home_tab_txt)
    protected TextView homeTabTxt;
    @ViewById(R.id.favorite_tab_txt)
    protected TextView favoriteTabTxt;
    @ViewById(R.id.mine_tab_txt)
    protected TextView mineTabTxt;

    @ViewById(R.id.home_tab_rel)
    protected RelativeLayout homeTabRel;
    @ViewById(R.id.favorite_tab_rel)
    protected RelativeLayout favoriteTabRel;
    @ViewById(R.id.mine_tab_rel)
    protected RelativeLayout mineTabRel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
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

    @Click({R.id.home_tab_txt, R.id.favorite_tab_txt, R.id.mine_tab_txt})
    protected void changeTabs(View view) {
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
