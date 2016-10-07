package com.yuewawa.showhelper.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.yuewawa.showhelper.R;
import com.yuewawa.showhelper.biz.IShowBiz;
import com.yuewawa.showhelper.biz.impl.ShowBiz;
import com.yuewawa.showhelper.entity.Show;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ItemSelect;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.annotations.ViewsById;

/**
 * Created by yuewawa on 2016-07-30.
 */
@EActivity(R.layout.show_add)
public class ShowAddActivity extends Activity{

//    @ViewById(R.id.show_name_edt)
//    protected EditText showNameEdt;
//    @ViewById(R.id.latest_season_edt)
//    protected EditText latestSeasonEdt;
//    @ViewById(R.id.total_episodes_edt)
//    protected EditText totalEpisodesEdt;
//    @ViewById(R.id.updated_episode_edt)
//    protected EditText updatedEpisodeEdt;
//    @ViewById(R.id.updated_week_edt)
//    protected EditText updatedWeekEdt;
//    @ViewById(R.id.updated_time_edt)
//    protected EditText updatedTimeEdt;
//    @ViewById(R.id.updated_date_edt)
//    protected EditText updatedDateEdt;
//    @ViewById(R.id.next_date_edt)
//    protected EditText nextDateEdt;
//    @ViewById(R.id.show_type_edt)
//    protected EditText showTypeEdt;
//    @ViewById(R.id.show_status_edt)
//    protected EditText showStatusEdt;
//
//    @ViewById(R.id.showStatus_spinner)
//    protected Spinner showStatusSpinner;
//
//    @ViewById(R.id.show_add_btn)
//    protected Button addShowBtn;
//
//    private IShowBiz showBiz;
//    private Show show;
//    private String showName;
//    private int latestSeason;
//    private String totalEpisodes;
//    private String updatedEpisode;
//    private String updatedWeek;
//    private String updatedTime;
//    private String updatedDate;
//    private String nextDate;
//    private String showRegion;
//    private String showType;
//    private String showStatus;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }
//
//    public void showAdd() {
//        showBiz = new ShowBiz(this);
//        show = new Show();
//        showName = showNameEdt.getText().toString();
//        latestSeason = Integer.parseInt(latestSeasonEdt.getText().toString());
//        totalEpisodes = totalEpisodesEdt.getText().toString();
//        updatedEpisode = updatedEpisodeEdt.getText().toString();
//        updatedWeek = updatedWeekEdt.getText().toString();
//        updatedTime = updatedTimeEdt.getText().toString();
//        updatedDate = updatedDateEdt.getText().toString();
//        nextDate = nextDateEdt.getText().toString();
//        showType = showTypeEdt.getText().toString();
//        showStatus = showStatusEdt.getText().toString();
//
//        show.setShowName(showName);
//        show.setLatestSeason(latestSeason);
//        show.setTotalEpisodes(totalEpisodes);
//        show.setUpdatedEpisode(updatedEpisode);
//        show.setUpdatedWeek(updatedWeek);
//        show.setUpdatedTime(updatedTime);
//        show.setUpdatedDate(updatedDate);
//        show.setNextDate(nextDate);
//        show.setShowType(showType);
//        show.setShowStatus(showStatus);
//        long result = showBiz.showAdd(show);
//    }
//
//    @ItemSelect(R.id.showStatus_spinner)
//    public void setShowStatus(boolean selected, String showStatus) {
//        this.showStatus = showStatus;
//    }
}
