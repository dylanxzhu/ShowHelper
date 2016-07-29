package com.yuewawa.showhelper.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by yuewawa on 2016-07-29.
 */
@DatabaseTable(tableName = "t_show")
public class Show {

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(canBeNull = false)
    private String showName;
    @DatabaseField(canBeNull = false)
    private int latestSeason;
    @DatabaseField(canBeNull = false)
    private String totalEpisodes;
    @DatabaseField(canBeNull = false)
    private String updatedEpisode;
    @DatabaseField(canBeNull = false)
    private String updatedWeek;
    @DatabaseField(canBeNull = false)
    private String updatedTime;
    @DatabaseField(canBeNull = true)
    private String nextTime;
    @DatabaseField(canBeNull = false)
    private String showType;
    @DatabaseField(canBeNull = false)
    private String showStatus;
    @DatabaseField(canBeNull = false)
    private byte[] showImage;

    public Show() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public int getLatestSeason() {
        return latestSeason;
    }

    public void setLatestSeason(int latestSeason) {
        this.latestSeason = latestSeason;
    }

    public String getTotalEpisodes() {
        return totalEpisodes;
    }

    public void setTotalEpisodes(String totalEpisodes) {
        this.totalEpisodes = totalEpisodes;
    }

    public String getUpdatedEpisode() {
        return updatedEpisode;
    }

    public void setUpdatedEpisode(String updatedEpisode) {
        this.updatedEpisode = updatedEpisode;
    }

    public String getUpdatedWeek() {
        return updatedWeek;
    }

    public void setUpdatedWeek(String updatedWeek) {
        this.updatedWeek = updatedWeek;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getNextTime() {
        return nextTime;
    }

    public void setNextTime(String nextTime) {
        this.nextTime = nextTime;
    }

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }

    public String getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(String showStatus) {
        this.showStatus = showStatus;
    }

    public byte[] getShowImage() {
        return showImage;
    }

    public void setShowImage(byte[] showImage) {
        this.showImage = showImage;
    }
}
