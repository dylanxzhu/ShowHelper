package com.yuewawa.showhelper.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.yuewawa.showhelper.R;
import com.yuewawa.showhelper.activity.MainActivity;
import com.yuewawa.showhelper.adapter.CustomBaseAdapter;
import com.yuewawa.showhelper.constant.CustomConstant;
import com.yuewawa.showhelper.entity.Show;

import java.util.List;

/**
 * Created by yuewawa on 2016-07-29.
 */
public class FavoriteFragment extends BaseFragment{

    private View view;
    private ListView favoriteListView;
    private List<Show> shows;
    private CustomBaseAdapter<Show> showListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_favorite, container, false);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        MainActivity.currentTag = CustomConstant.FAVORITE_FRAGMENT;
    }
}
