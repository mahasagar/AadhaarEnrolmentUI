package com.mahasagar.aadhaarenrolmentui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by mahasagar on 22/5/16.
 */
public class TabFragmentVerification  extends Fragment implements View.OnClickListener{


    Button btn_submit,btn_prev_tab3;
    ViewPager mViewPager;
    public static TabFragmentVerification newInstance(ViewPager viewPager) {
        TabFragmentVerification fragment3 = new TabFragmentVerification();
        fragment3.mViewPager = viewPager;
        return fragment3;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.tabfragmentverification, container, false);
//        ButterKnife.bind(this, rootView);

        btn_submit = (Button)rootView.findViewById(R.id.btn_submit);
        btn_prev_tab3 = (Button)rootView.findViewById(R.id.btn_prev_tab3);

        btn_submit.setOnClickListener(this);
        btn_prev_tab3.setOnClickListener(this);
        return  rootView;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btn_submit:

                Toast.makeText(getActivity(),"submit",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_prev_tab3:
                try {
                    mViewPager.setCurrentItem(1);
                }catch(NullPointerException e){

                }
                break;
        }
    }
}