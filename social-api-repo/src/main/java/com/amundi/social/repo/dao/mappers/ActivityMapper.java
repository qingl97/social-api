package com.amundi.social.repo.dao.mappers;

import com.amundi.social.common.model.IActivity;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by liang on 07/09/2016.
 */
public interface ActivityMapper {

    List<? extends IActivity> getAll();
    List<? extends IActivity> getByUserApplication(@Param("userId") String userId, @Param("appId") String appId);
    List<? extends IActivity> getByUser(@Param("userId") String userId);
    List<? extends IActivity> getByApplication(@Param("appId") String appId);
    int add(@Param("userId") String userId, @Param("appId") String appId, @Param("productId") String productId, Date ts, int type);
    void delete(int activityId);
}
