package com.mahasagar.aadhaarenrolmentui;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import java.text.DateFormat;
import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by mahasagar on 22/5/16.
 */
public class TabFragmentPersonal extends Fragment {

    private Calendar cal;
    private int day;
    private int month;
    private int year;

    DateFormat fmtDateAndTime = DateFormat.getDateInstance();

    @Bind(R.id.tab_one_nextButton)  Button tab_one_nextButton;
    @Bind(R.id.img_birthdate)  ImageButton img_birthdate;

    @Bind(R.id.et_birthdate)  EditText et_birthdate;
    @Bind(R.id.et_email)  EditText et_email;
    @Bind(R.id.et_mobile)  EditText et_mobile;
    @Bind(R.id.district_spinner)  Spinner spinnerDistrict;
    @Bind(R.id.state_spinner)  Spinner spinnerState;
    @Bind(R.id.spin_title)  Spinner spin_title;

    private ViewPager mViewPager;
    public TabFragmentPersonal(){

    }
    public static TabFragmentPersonal newInstance(ViewPager viewPager) {
        TabFragmentPersonal fragment = new TabFragmentPersonal();
        fragment.mViewPager = viewPager;
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.tabfragmentpersonal, container, false);

        cal = Calendar.getInstance();
        day = cal.get(Calendar.DAY_OF_MONTH);
        month = cal.get(Calendar.MONTH);
        year = cal.get(Calendar.YEAR);

        ButterKnife.bind(this, rootView);
        img_birthdate = (ImageButton)rootView.findViewById(R.id.img_birthdate);
        tab_one_nextButton = (Button)rootView.findViewById(R.id.tab_one_nextButton);


        img_birthdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseDate(v);

            }
        });

        try {
            Account[] accounts = AccountManager.get(getActivity()).getAccountsByType("com.google");
            et_email.setText("" + accounts[0].name);
            TelephonyManager tm = (TelephonyManager)getContext().getSystemService(Context.TELEPHONY_SERVICE);
            String number = tm.getLine1Number();
            et_mobile.setText("" +number);
        }catch(Exception e){

        }
        tab_one_nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mViewPager.setCurrentItem(1);
                }catch(NullPointerException e){

                }
            }
        });
        return rootView;
    }


    private void updateLabel() {
        et_birthdate.setText(fmtDateAndTime.format(cal.getTime()));
        //int age = cal.get(Calendar.YEAR) - 0;
    }

    public void chooseDate(View v) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                mdatePickerDialog,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    DatePickerDialog.OnDateSetListener mdatePickerDialog = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            cal.set(Calendar.YEAR, year);
            cal.set(Calendar.MONTH, monthOfYear);
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }
    };
}