package com.yuewawa.showhelper.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.yuewawa.showhelper.constant.ShowStatus;
import com.yuewawa.showhelper.constant.ShowType;
import com.yuewawa.showhelper.dao.ShowDao;
import com.yuewawa.showhelper.entity.Show;
import com.yuewawa.showhelper.util.TimeUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by yuewawa on 2016-07-31.
 */
public class ShowService extends Service{

    public static final String TAG = "ShowService";
    private ShowDao showDao;
    private String currentTime;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return super.onStartCommand(intent, flags, startId);
    }

    private void updateShow() {
        showDao = new ShowDao(this);
        String currentWeek;
        try {
            currentWeek = TimeUtil.getCurrentWeek();
            List<Show> shows = showDao.getAllByWeek(currentWeek);

            if (shows != null && shows.size() > 0) {
                for (Show show : shows) {
                    String totalEpisodes = show.getTotalEpisodes();
                    String updatedEpisode = show.getUpdatedEpisode();
                    String updatedTime = show.getUpdatedTime();
                    String nextTime = show.getNextTime();
                    String showType = show.getShowType();
                    String showStatus = show.getShowStatus();

                    if (showStatus.equals(ShowStatus.UPDATING)) {//如果状态是连载，就更新

                        currentTime = TimeUtil.getCurrentTime("yyyy-MM-dd HH:mm");

                        if (nextTime.equals(currentTime)) { //如果下次更新时间等于当前时间

                            if (showType.equals(ShowType.ENT)) { //如果类型是综艺
                                updatedEpisode = TimeUtil.getSevenDaysLater(updatedEpisode, "yyyy-MM-dd");
                                updatedTime = nextTime;
                                nextTime = TimeUtil.getSevenDaysLater(nextTime, "yyyy-MM-dd HH:mm");
                                totalEpisodes = updatedEpisode;

                                show.setTotalEpisodes(totalEpisodes);
                            } else if (showType.equals(ShowType.TV_NET)) { //如果是网络剧
                                updatedEpisode = updatedEpisode + "";
                                if (Integer.parseInt(updatedEpisode) >= Integer.parseInt(totalEpisodes)) {
                                    //如果已更新集数大于等于总集数，则设置nextTime=""，showStatus="季终"
                                } else {
                                    //如果已更新集数小于总集数，则设置nextTime="7天后时间"
                                }
                            } else { //如果是美剧，英剧，动漫
                                updatedEpisode = String.valueOf(Integer.parseInt(updatedEpisode)+1);
                                updatedTime = nextTime;
                                nextTime = TimeUtil.getSevenDaysLater(nextTime, "yyyy-MM-dd HH:mm");

                                if (totalEpisodes.equals(updatedEpisode)) { //如果总集数等于已更新集数
                                    showStatus = ShowStatus.SEASON_END;
                                    nextTime = "";

                                    show.setShowStatus(showStatus);
                                }
                            }
                            show.setUpdatedEpisode(updatedEpisode);
                            show.setUpdatedTime(updatedTime);
                            show.setNextTime(nextTime);
                            showDao.update(show);
                        }
                    }

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
