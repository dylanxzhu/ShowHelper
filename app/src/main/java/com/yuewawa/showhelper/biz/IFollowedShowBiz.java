package com.yuewawa.showhelper.biz;

import com.yuewawa.showhelper.entity.FollowedShow;

import java.util.List;

/**
 * Created by yuewawa on 2016-10-07.
 */
public interface IFollowedShowBiz {

    /**
     * 查询所有追看剧集
     * @param userId
     * @return
     * */
    public List<FollowedShow> getAllFollowedShows(Long userId);
}
