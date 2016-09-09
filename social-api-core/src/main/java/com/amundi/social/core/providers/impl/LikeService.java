package com.amundi.social.core.providers.impl;

import com.amundi.social.common.model.Like;
import com.amundi.social.repo.dao.ILikeDao;

/**
 * Created by liang on 07/09/2016.
 */
public class LikeService extends AbstractActivityService<Like> {

    public LikeService(ILikeDao dao) {
       super(dao);
    }
}

