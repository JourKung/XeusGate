package com.example.nailamundev.xeusgate.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nailamundev.xeusgate.R;
import com.example.nailamundev.xeusgate.activity.MoreInfoActivity;
import com.example.nailamundev.xeusgate.adapter.SiteListAdapter;
import com.example.nailamundev.xeusgate.dao.SiteItemListDao;
import com.example.nailamundev.xeusgate.manager.SitelistManager;
import com.example.nailamundev.xeusgate.models.Topic;
import com.example.nailamundev.xeusgate.utils.keySite;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class MainFragment extends Fragment {

    ProgressBar progressBar;
    ListView listView;
    TextView tvSumSite;
    SiteListAdapter listAdapter;
    SwipeRefreshLayout swipeRefreshLayout;
    private DatabaseReference mDatabase,mUserref;
    private ValueEventListener valueEventListener;
    private ChildEventListener mchildEventListener;
    private Query mQuery;
    List<String> mTopicIds = new ArrayList<>();
    List<Topic> mTopics = new ArrayList<>();


    public MainFragment() {
        super();
    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        // Init 'View' instance(s) with rootView.findViewById here

        listView = (ListView) rootView.findViewById(R.id.listView);
        listAdapter = new SiteListAdapter();
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(listViewItemClickListener);
        swipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                reload();

            }
        });
        tvSumSite = (TextView) rootView.findViewById(R.id.tvSumSite);
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {

                swipeRefreshLayout.setEnabled(i == 0);
            }
        });

        reload();



    }

    public void reload() {

        mTopicIds.clear();
        mTopics.clear();
        mDatabase = FirebaseDatabase.getInstance().getReference();          // References Root Database in Firebase
        mQuery = mDatabase.child("sitemain");                             // Child Site

        //TODO: ChildEvent
        mchildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                swipeRefreshLayout.setRefreshing(false);
/*
                Map map = (Map) dataSnapshot.getValue();
                String value = String.valueOf(map.get("name"));
                Log.d("onChildAdded", value);
                Log.d("onChildAdded", dataSnapshot.getKey());*/

/*                SiteItemListDao dao = dataSnapshot.getValue(SiteItemListDao.class);
                SitelistManager.getInstance().setDao(dao);
                listAdapter.notifyDataSetChanged();*/

                Topic topic = dataSnapshot.getValue(Topic.class);
                Log.d("onChildAdded", topic.name);
                mTopicIds.add(dataSnapshot.getKey());
                mTopics.add(topic);
                listAdapter.setmTopics(mTopics);
                listAdapter.notifyDataSetChanged();
                tvSumSite.setText("Site List - " +mTopics.size() + " sites" );



                //SiteItemDao dao = dataSnapshot.getValue(SiteItemDao.class);

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                swipeRefreshLayout.setRefreshing(false);
            }
        };

        mQuery.addChildEventListener(mchildEventListener);




    }


    @Override
    public void onStart() {
        super.onStart();



    }

    @Override
    public void onStop() {


        if(valueEventListener != null){
            mQuery.removeEventListener(mchildEventListener);

        }
        super.onStop();
    }

    /*
     * Save Instance State Here
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save Instance State here
    }

    /*
     * Restore Instance State Here
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore Instance State here
        }
    }

    /*************************************
     * Listener Zone
     *********************************/

    AdapterView.OnItemClickListener listViewItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            Intent intent = new Intent(getContext(), MoreInfoActivity.class);
            keySite key = new keySite();
            key.setKeySite(mTopics.get(i).name);
            startActivity(intent);

           // Toast.makeText(getContext(),"Position : " + i + "Key : " + mTopicIds.get(i).toString(),Toast.LENGTH_SHORT).show();

        }
    };


}
