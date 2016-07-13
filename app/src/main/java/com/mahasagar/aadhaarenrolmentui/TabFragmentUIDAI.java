package com.mahasagar.aadhaarenrolmentui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by mahasagar on 22/5/16.
 */
public class TabFragmentUIDAI  extends Fragment {


   Button bt_prev_tab2,bt_next_tab2;

    ViewPager mViewPager;
    public static TabFragmentUIDAI newInstance(ViewPager viewPager) {
        TabFragmentUIDAI fragment2 = new TabFragmentUIDAI();
        fragment2.mViewPager = viewPager;
        return fragment2;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.tabfragmentuidia, container, false);

        bt_prev_tab2 = (Button)rootView.findViewById(R.id.prev_tab2);
        bt_next_tab2 = (Button)rootView.findViewById(R.id.next_tab2);

        bt_prev_tab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mViewPager.setCurrentItem(0);
                }catch(NullPointerException e){

                }
            }
        });

        bt_next_tab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mViewPager.setCurrentItem(2);
                }catch(NullPointerException e){

                }
            }
        });
        return rootView;
    }
/*
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch(id){
            case R.id.prev_tab2:
                Toast.makeText(getActivity(),"this",Toast.LENGTH_SHORT).show();
                break;
            case R.id.next_tab2:
                Toast.makeText(getActivity(),"next",Toast.LENGTH_SHORT).show();
                break;
        }
    }*/
}