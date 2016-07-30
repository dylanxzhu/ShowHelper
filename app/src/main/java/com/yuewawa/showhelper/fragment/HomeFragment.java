package com.yuewawa.showhelper.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yuewawa.showhelper.R;
import com.yuewawa.showhelper.activity.MainActivity;
import com.yuewawa.showhelper.constant.CustomConstant;

/**
 * Created by yuewawa on 2016-07-29.
 */
public class HomeFragment extends BaseFragment{

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        MainActivity.currentTag = CustomConstant.HOME_FRAGMENT;
    }

    @Override
    public void onClick(View view) {

    }
}
