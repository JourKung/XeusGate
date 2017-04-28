package com.example.nailamundev.xeusgate.manager;

import android.content.Context;

import com.example.nailamundev.xeusgate.dao.SiteItemListDao;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class SitelistManager {

    private static SitelistManager instance;
    private SiteItemListDao dao;

    public SiteItemListDao getDao() {
        return dao;
    }

    public void setDao(SiteItemListDao dao) {
        this.dao = dao;
    }

    public static SitelistManager getInstance() {
        if (instance == null)
            instance = new SitelistManager();
        return instance;
    }

    private Context mContext;

    private SitelistManager() {
        mContext = Contextor.getInstance().getContext();
    }

}
