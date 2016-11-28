package com.udacity.cscan.daoimage;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 *
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig imageDaoConfig;

    private final ImageDao imageDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        imageDaoConfig = daoConfigMap.get(ImageDao.class).clone();
        imageDaoConfig.initIdentityScope(type);

        imageDao = new ImageDao(imageDaoConfig, this);

        registerDao(Image.class, imageDao);
    }

    public void clear() {
        imageDaoConfig.getIdentityScope().clear();
    }

    public ImageDao getImageDao() {
        return imageDao;
    }

}
