package com.example.xts.greendaodemo.db;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.example.dell.lianxiqimo5.app.BenDao;

import com.example.xts.greendaodemo.db.BenDaoDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig benDaoDaoConfig;

    private final BenDaoDao benDaoDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        benDaoDaoConfig = daoConfigMap.get(BenDaoDao.class).clone();
        benDaoDaoConfig.initIdentityScope(type);

        benDaoDao = new BenDaoDao(benDaoDaoConfig, this);

        registerDao(BenDao.class, benDaoDao);
    }
    
    public void clear() {
        benDaoDaoConfig.clearIdentityScope();
    }

    public BenDaoDao getBenDaoDao() {
        return benDaoDao;
    }

}
