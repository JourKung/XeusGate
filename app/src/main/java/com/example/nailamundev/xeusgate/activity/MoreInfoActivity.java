package com.example.nailamundev.xeusgate.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.nailamundev.xeusgate.R;
import com.example.nailamundev.xeusgate.fragment.MainFragment;
import com.example.nailamundev.xeusgate.fragment.MoreInfoFragment;

public class MoreInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);


        if(savedInstanceState == null){

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainerMore, MoreInfoFragment.newInstance())
                    .commit();
        }

    }
}
