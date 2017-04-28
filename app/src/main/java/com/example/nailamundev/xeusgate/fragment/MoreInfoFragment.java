package com.example.nailamundev.xeusgate.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nailamundev.xeusgate.R;
import com.example.nailamundev.xeusgate.models.DashboardValue;
import com.example.nailamundev.xeusgate.utils.keySite;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class MoreInfoFragment extends Fragment {

    TextView tvStatus;
    private DatabaseReference mDatabase,mUserref;
    private ValueEventListener valueEventListener;
    private ChildEventListener mchildEventListener;
    private Query mQuery;

    public MoreInfoFragment() {
        super();
    }

    public static MoreInfoFragment newInstance() {
        MoreInfoFragment fragment = new MoreInfoFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_moreinfo, container, false);
        initInstances(rootView);
        return rootView;
    }

    private void initInstances(View rootView) {
        // Init 'View' instance(s) with rootView.findViewById here
        tvStatus = (TextView) rootView.findViewById(R.id.tvStatus);
        tvStatus.setText("");

        keySite key = new keySite();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mQuery = mDatabase.child("DashboardValue").child("solarSite");

        mchildEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                DashboardValue dashboardValue = dataSnapshot.getValue(DashboardValue.class);
                tvStatus.append(dashboardValue.name + " : " +dashboardValue.value);
                tvStatus.append("/n");

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

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
}
