package com.yuewawa.showhelper.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yuewawa.showhelper.R;
import com.yuewawa.showhelper.dao.ShowDao;
import com.yuewawa.showhelper.entity.Show;

import java.sql.SQLException;

/**
 * Created by yuewawa on 2016-07-30.
 */
public class ShowAddActivity extends BaseActivity{

    private EditText showNameEdt, latestSeasonEdt, totalEpisodesEdt, updatedEpisodeEdt,
            updatedWeekEdt, updatedTimeEdt, nextTimeEdt, showTypeEdt, showStatusEdt;
    private Button addShowBtn;

    private Show show;
    private ShowDao showDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_add);

        showDao = new ShowDao(this);

        initViews();
    }

    @Override
    protected void initViews() {
        showNameEdt = (EditText) findViewById(R.id.show_name_edt);
        latestSeasonEdt = (EditText) findViewById(R.id.latest_season_edt);
        totalEpisodesEdt = (EditText) findViewById(R.id.total_episodes_edt);
        updatedEpisodeEdt = (EditText) findViewById(R.id.updated_episode_edt);
        updatedWeekEdt = (EditText) findViewById(R.id.updated_week_edt);
        updatedTimeEdt = (EditText) findViewById(R.id.updated_time_edt);
        nextTimeEdt = (EditText) findViewById(R.id.next_time_edt);
        showTypeEdt = (EditText) findViewById(R.id.show_type_edt);
        showStatusEdt = (EditText) findViewById(R.id.show_status_edt);
        addShowBtn = (Button) findViewById(R.id.add_show_btn);
        addShowBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_show_btn:
                addShow();
                break;
        }
    }

    private void addShow() {
        String showName = showNameEdt.getText().toString();
        int latestSeason = Integer.parseInt(latestSeasonEdt.getText().toString());
        String totalEpisodes = totalEpisodesEdt.getText().toString();
        String updatedEpisode = updatedEpisodeEdt.getText().toString();
        String updatedWeek = updatedWeekEdt.getText().toString();
        String updatedTime = updatedTimeEdt.getText().toString();
        String nextTime = nextTimeEdt.getText().toString();
        String showType = showTypeEdt.getText().toString();
        String showStatus = showStatusEdt.getText().toString();

        show = new Show();
        show.setShowName(showName);
        show.setLatestSeason(latestSeason);
        show.setTotalEpisodes(totalEpisodes);
        show.setUpdatedEpisode(updatedEpisode);
        show.setUpdatedWeek(updatedWeek);
        show.setUpdatedTime(updatedTime);
        show.setNextTime(nextTime);
        show.setShowType(showType);
        show.setShowStatus(showStatus);

        try {
            showDao.add(show);
            Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putSerializable("show", show);
            intent.putExtras(bundle);
            setResult(0x101, intent);
            this.finish();
        } catch (SQLException e) {
            e.printStackTrace();
            Toast.makeText(this, "添加失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("show", null);
        intent.putExtras(bundle);
        setResult(0x102, intent);
        this.finish();
    }
}
