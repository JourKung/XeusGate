package com.example.nailamundev.xeusgate.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;

import com.example.nailamundev.xeusgate.R;
import com.example.nailamundev.xeusgate.dao.SiteItemListDao;
import com.example.nailamundev.xeusgate.manager.SitelistManager;
import com.example.nailamundev.xeusgate.models.Topic;
import com.example.nailamundev.xeusgate.view.SiteListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BenZDeV on 4/9/2017.
 */

public class SiteListAdapter extends BaseAdapter {

    List<Topic> mTopics = new ArrayList<>();

    SiteItemListDao dao;

    int lastPosition = -1;

    public SiteItemListDao getDao() {
        return dao;
    }

    public void setDao(SiteItemListDao dao) {
        this.dao = dao;
    }

    public List<Topic> getmTopics() {
        return mTopics;
    }

    public void setmTopics(List<Topic> mTopics) {
        this.mTopics = mTopics;
    }

    @Override
    public int getCount() {

    /*    if(SitelistManager.getInstance().getDao() == null){

            return 0;
        }
        if (SitelistManager.getInstance().getDao().getSite() == null){
            return 0;
        }

*/
        if (mTopics == null){
            return 0;
        }
        //return SitelistManager.getInstance().getDao().getSite().size();
        return mTopics.size();
    }

    @Override
    public Object getItem(int i) {
        return mTopics.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        SiteListItem item;

        // Make View Recycleable
        if (view != null)
            item = (SiteListItem) view;
        else
            item = new SiteListItem(viewGroup.getContext());

            item.setNameText(mTopics.get(i).name);
            item.setAdressText(mTopics.get(i).address);
            item.setImageUrl(mTopics.get(i).img);


        if (i > lastPosition) {
            Animation anim = AnimationUtils.loadAnimation(viewGroup.getContext(),
                    R.anim.up_form_bottom);
            item.startAnimation(anim);
            lastPosition = i;
        }

        return item;
    }
}
