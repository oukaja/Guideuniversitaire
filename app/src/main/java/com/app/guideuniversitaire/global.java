package com.app.guideuniversitaire;

import android.app.Application;

import com.app.guideuniversitaire.entities.DaoMaster;
import com.app.guideuniversitaire.entities.DaoSession;

public class global extends Application {

    private DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        mDaoSession = new DaoMaster(new DaoMaster.DevOpenHelper(this, "universites.db").getWritableDb()).newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

}
