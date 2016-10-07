package com.yuewawa.showhelper.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.yuewawa.showhelper.dao.gen.DaoSession;
import com.yuewawa.showhelper.dao.gen.FollowedShowDao;
import com.yuewawa.showhelper.dao.gen.ShowDao;

/**
 * Created by yuewawa on 2016-07-29.
 */
@Entity
public class Show {

    @Id(autoincrement = true)
    private Long showId;
    @Property
    private String showName; //剧名
    @Property
    private int latestSeason; //最新季
    @Property
    private String totalEpisodes; //总集数
    @Property
    private String updatedEpisode; //已更新的集数
    @Property
    private String updatedWeek; //更新星期
    @Property
    private String updatedTime; //更新时间
    @Property
    private String updatedDate; //已更新日期
    @Property
    private String nextDate; //下集更新日期
    @Property
    private String showRegion;//地区
    @Property
    private String showType; //类型
    @Property
    private String showStatus; //状态
    @Property
    private byte[] showImage; //图片
    @Property
    private int episodesOfWeek; //每周更新集数
    @ToMany(referencedJoinProperty = "showId")
    private List<FollowedShow> followedShows;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 623646930)
    private transient ShowDao myDao;
    @Generated(hash = 669697390)
    public Show(Long showId, String showName, int latestSeason, String totalEpisodes,
            String updatedEpisode, String updatedWeek, String updatedTime, String updatedDate,
            String nextDate, String showRegion, String showType, String showStatus, byte[] showImage,
            int episodesOfWeek) {
        this.showId = showId;
        this.showName = showName;
        this.latestSeason = latestSeason;
        this.totalEpisodes = totalEpisodes;
        this.updatedEpisode = updatedEpisode;
        this.updatedWeek = updatedWeek;
        this.updatedTime = updatedTime;
        this.updatedDate = updatedDate;
        this.nextDate = nextDate;
        this.showRegion = showRegion;
        this.showType = showType;
        this.showStatus = showStatus;
        this.showImage = showImage;
        this.episodesOfWeek = episodesOfWeek;
    }
    @Generated(hash = 2080215184)
    public Show() {
    }
    public Long getShowId() {
        return this.showId;
    }
    public void setShowId(Long showId) {
        this.showId = showId;
    }
    public String getShowName() {
        return this.showName;
    }
    public void setShowName(String showName) {
        this.showName = showName;
    }
    public int getLatestSeason() {
        return this.latestSeason;
    }
    public void setLatestSeason(int latestSeason) {
        this.latestSeason = latestSeason;
    }
    public String getTotalEpisodes() {
        return this.totalEpisodes;
    }
    public void setTotalEpisodes(String totalEpisodes) {
        this.totalEpisodes = totalEpisodes;
    }
    public String getUpdatedEpisode() {
        return this.updatedEpisode;
    }
    public void setUpdatedEpisode(String updatedEpisode) {
        this.updatedEpisode = updatedEpisode;
    }
    public String getUpdatedWeek() {
        return this.updatedWeek;
    }
    public void setUpdatedWeek(String updatedWeek) {
        this.updatedWeek = updatedWeek;
    }
    public String getUpdatedTime() {
        return this.updatedTime;
    }
    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }
    public String getUpdatedDate() {
        return this.updatedDate;
    }
    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }
    public String getNextDate() {
        return this.nextDate;
    }
    public void setNextDate(String nextDate) {
        this.nextDate = nextDate;
    }
    public String getShowType() {
        return this.showType;
    }
    public void setShowType(String showType) {
        this.showType = showType;
    }
    public String getShowStatus() {
        return this.showStatus;
    }
    public void setShowStatus(String showStatus) {
        this.showStatus = showStatus;
    }
    public byte[] getShowImage() {
        return this.showImage;
    }
    public void setShowImage(byte[] showImage) {
        this.showImage = showImage;
    }
    public int getEpisodesOfWeek() {
        return this.episodesOfWeek;
    }
    public void setEpisodesOfWeek(int episodesOfWeek) {
        this.episodesOfWeek = episodesOfWeek;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1780417848)
    public List<FollowedShow> getFollowedShows() {
        if (followedShows == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            FollowedShowDao targetDao = daoSession.getFollowedShowDao();
            List<FollowedShow> followedShowsNew = targetDao._queryShow_FollowedShows(showId);
            synchronized (this) {
                if(followedShows == null) {
                    followedShows = followedShowsNew;
                }
            }
        }
        return followedShows;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 371365571)
    public synchronized void resetFollowedShows() {
        followedShows = null;
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 37946965)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getShowDao() : null;
    }
    public String getShowRegion() {
        return this.showRegion;
    }
    public void setShowRegion(String showRegion) {
        this.showRegion = showRegion;
    }
}
