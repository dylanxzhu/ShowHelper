package com.yuewawa.showhelper.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.yuewawa.showhelper.dao.gen.DaoSession;
import com.yuewawa.showhelper.dao.gen.UserDao;
import com.yuewawa.showhelper.dao.gen.ShowDao;
import com.yuewawa.showhelper.dao.gen.FollowedShowDao;

/**
 * Created by yuewawa on 2016-10-06.
 */
@Entity
public class FollowedShow {

    @Id(autoincrement = true)
    private Long id;//主键id
    @ToOne(joinProperty = "userId")
    private User user;
    private Long userId;
    @ToOne(joinProperty = "showId")
    private Show show;
    private Long showId;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 495204126)
    private transient FollowedShowDao myDao;
    @Generated(hash = 1379876284)
    public FollowedShow(Long id, Long userId, Long showId) {
        this.id = id;
        this.userId = userId;
        this.showId = showId;
    }
    @Generated(hash = 1223995030)
    public FollowedShow() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getUserId() {
        return this.userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getShowId() {
        return this.showId;
    }
    public void setShowId(Long showId) {
        this.showId = showId;
    }
    @Generated(hash = 251390918)
    private transient Long user__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 859885876)
    public User getUser() {
        Long __key = this.userId;
        if (user__resolvedKey == null || !user__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            UserDao targetDao = daoSession.getUserDao();
            User userNew = targetDao.load(__key);
            synchronized (this) {
                user = userNew;
                user__resolvedKey = __key;
            }
        }
        return user;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 496399742)
    public void setUser(User user) {
        synchronized (this) {
            this.user = user;
            userId = user == null ? null : user.getUserId();
            user__resolvedKey = userId;
        }
    }
    @Generated(hash = 1196175850)
    private transient Long show__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 363292378)
    public Show getShow() {
        Long __key = this.showId;
        if (show__resolvedKey == null || !show__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ShowDao targetDao = daoSession.getShowDao();
            Show showNew = targetDao.load(__key);
            synchronized (this) {
                show = showNew;
                show__resolvedKey = __key;
            }
        }
        return show;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1233626317)
    public void setShow(Show show) {
        synchronized (this) {
            this.show = show;
            showId = show == null ? null : show.getShowId();
            show__resolvedKey = showId;
        }
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
    @Generated(hash = 1061579441)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getFollowedShowDao() : null;
    }

}
