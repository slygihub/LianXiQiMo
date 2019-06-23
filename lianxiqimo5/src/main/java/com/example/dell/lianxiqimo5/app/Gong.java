package com.example.dell.lianxiqimo5.app;

import com.example.xts.greendaodemo.db.BenDaoDao;
import com.example.xts.greendaodemo.db.DaoMaster;

import java.util.List;

public class Gong {
    private static Gong gong;
    private final BenDaoDao benDaoDao;

    private Gong() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(App.getApp(), "sly.db");
        benDaoDao = new DaoMaster(helper.getWritableDatabase()).newSession().getBenDaoDao();
    }

    public static Gong getGong() {
        if (gong == null) {
            synchronized (Gong.class) {
                if (gong == null) {
                    gong = new Gong();
                }
            }
        }
        return gong;
    }

    public void insert(BenDao benDao) {
        if (has()) {
            benDaoDao.insertOrReplaceInTx(benDao);
        }
    }

    public List<BenDao> query() {
        return benDaoDao.queryBuilder().list();
    }

    public void data(BenDao benDao) {
        benDaoDao.delete(benDao);
    }

    private boolean has() {
        List<BenDao> list = benDaoDao.queryBuilder().list();
        if (list!=null&&list.size()>=0){
            return true;
        }else{
            return false;
        }
    }
}
