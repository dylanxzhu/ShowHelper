package com.yuewawa.showhelper.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.yuewawa.showhelper.R;
import com.yuewawa.showhelper.activity.MainActivity;
import com.yuewawa.showhelper.activity.ShowAddActivity;
import com.yuewawa.showhelper.activity.ShowDetailActivity;
import com.yuewawa.showhelper.adapter.CustomBaseAdapter;
import com.yuewawa.showhelper.constant.CustomConstant;
import com.yuewawa.showhelper.dao.ShowDao;
import com.yuewawa.showhelper.entity.Show;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by yuewawa on 2016-07-29.
 */
public class FavoriteFragment extends BaseFragment implements AdapterView.OnItemClickListener{

    private static final String TAG = "FavoriteFragment";

    private Context context;
    private View view;
    private Intent intent;

    private ListView favoriteListView;
    private List<Show> shows;
    private CustomBaseAdapter<Show> showListAdapter;
    private ShowDao showDao;
    private Button addShowBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e(TAG, "onCreateView()");

        view = inflater.inflate(R.layout.fragment_favorite, container, false);

        context = getActivity();
        showDao = new ShowDao(context);
        initViews();
        setListViewData();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "onResume()");

        MainActivity.currentTag = CustomConstant.FAVORITE_FRAGMENT;
    }

    private void setListViewData() {
        try {
            shows = showDao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (shows != null && shows.size() > 0) {
            showListAdapter = new CustomBaseAdapter<Show>(shows, R.layout.favorite_list_item) {

                @Override
                public void bindView(ViewHolder holder, Show obj) {
                    holder.setText(R.id.show_name_txt, obj.getShowName());
                    holder.setText(R.id.latest_season_txt, "第"+String.valueOf(obj.getLatestSeason())+"季");
                    holder.setText(R.id.updated_episode_txt, "第"+obj.getUpdatedEpisode()+"集");
                }
            };
            favoriteListView.setAdapter(showListAdapter);
        }
    }

    private void initViews() {
        favoriteListView = (ListView) view.findViewById(R.id.favorite_list_view);
        favoriteListView.setOnItemClickListener(this);

        addShowBtn = (Button) view.findViewById(R.id.add_show_btn);
        addShowBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_show_btn:
                intent = new Intent(context, ShowAddActivity.class);
                startActivityForResult(intent, 0x001);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Toast.makeText(context, "You click item"+(position+1)+", id="+id, Toast.LENGTH_SHORT).show();
        intent = new Intent(context, ShowDetailActivity.class);
        intent.putExtra("id", position+1);
        startActivity(intent);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 0x001:
                Show show = (Show) data.getExtras().getSerializable("show");
                if (show != null) {
                    showListAdapter.add(shows.size(), show);
                }
                break;
        }
    }
}
