package com.yuewawa.showhelper.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.yuewawa.showhelper.R;
import com.yuewawa.showhelper.activity.MainActivity;
import com.yuewawa.showhelper.activity.ShowAddActivity_;
import com.yuewawa.showhelper.constant.CustomConstant;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Created by yuewawa on 2016-07-29.
 */
@EFragment
public class MineFragment extends BaseFragment {

    View view;

    @ViewById(R.id.showManage_txt)
    TextView showManageTxt;

    private Intent intent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mine, container, false);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        MainActivity.currentTag = CustomConstant.MINE_FRAGMENT;
    }

    @Click(R.id.showManage_txt)
    public void toShowManage() {
        Toast.makeText(getActivity(), "Go to Show Manage", Toast.LENGTH_SHORT).show();
        intent = new Intent(getActivity(), ShowAddActivity_.class);
        startActivity(intent);
    }

}
