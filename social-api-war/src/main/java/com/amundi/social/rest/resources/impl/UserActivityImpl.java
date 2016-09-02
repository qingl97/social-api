package com.amundi.social.rest.resources.impl;

import com.amundi.social.common.model.Favorite;
import com.amundi.social.common.model.Follow;
import com.amundi.social.common.model.IActivity;
import com.amundi.social.common.model.IActivity.ActionType;
import com.amundi.social.common.model.Like;
import com.amundi.social.core.providers.impl.ActivityService;
import com.amundi.social.rest.resources.UserActivity;
import com.amundi.social.rest.resources.util.DefaultJsonResponseBuilder;
import net.active.services.server.util.AbstractResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;

/**
 * Created by liang on 04/08/2016.
 */
public class UserActivityImpl extends AbstractResource implements UserActivity  {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserActivityImpl.class);

    private ActivityService activityService = new ActivityService();
    @Override
    public Response getAllUserActivity(String action, String appId, String productId, String userId) {

        LOGGER.debug("action [" + action + "]");
        LOGGER.debug("appId [" + appId + "]");
        LOGGER.debug("productId [" + productId + "]");
        LOGGER.debug("userId [" + userId + "]");
        if(action == null)
            return Response.status(Response.Status.BAD_REQUEST).entity("action must be specified").build();

        ActionType actionType = ActionType.fromString(action);

        /*********************************************************
         *  activities not by a specific user
         ********************************************************/

        if(appId != null && productId != null && userId == null) {
            // get action did by all users on product of aoo
            return DefaultJsonResponseBuilder.build(activityService.get(appId, productId, actionType));
        }

        if(appId != null && productId == null && userId == null) {
            // get action did by all users on all products of app
            return DefaultJsonResponseBuilder.build(activityService.get(appId, actionType));
        }

        if(appId == null && productId == null && userId == null) {
            // get action did by all users on all apps
            return DefaultJsonResponseBuilder.build(activityService.getAll(actionType));
        }

        /*********************************************************
         *  activities by a specific user
         ********************************************************/

        if(userId != null && appId == null && productId == null) {
            // get action did by user
            return DefaultJsonResponseBuilder.build(activityService.getByUser(userId, actionType));
        }

        if(userId != null && appId != null && productId == null) {
            // get action did by user on app
            return DefaultJsonResponseBuilder.build(activityService.getByUser(userId, appId, actionType));
        }

        if(userId != null && appId != null && productId != null) {
            // get action did by user on product of app
            return DefaultJsonResponseBuilder.build(activityService.getByUser(userId, appId, productId, actionType));
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    @Override
    public Response doAction(String action, String appId, String productId, String userId, CommentBody comment) {
        if(action == null || appId == null || productId == null || userId == null)
            return Response.status(Response.Status.BAD_REQUEST).build();


        return buildDeletedResponse();
    }

    @Override
    public Response undoAction(String action, String appId, String productId, String userId) {
        if(action == null || appId == null || productId == null || userId == null)
            return Response.status(Response.Status.BAD_REQUEST).build();

        IActivity activity = null;

        if(ActionType.fromString(action).equals(ActionType.LIKE)) {
            activity = new Like();
        }

        if(ActionType.fromString(action).equals(ActionType.FAVORITE)) {
            activity = new Favorite();
        }

        if(ActionType.fromString(action).equals(ActionType.FOLLOW)) {
            activity = new Follow();
        }

        if(ActionType.fromString(action).equals(ActionType.COMMENT)) {
        }

        activityService.remove(activity);
        return buildDeletedResponse();
    }
}
