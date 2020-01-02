package com.world.music.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.world.music.R;

public class PhoneBookFragment extends Fragment{

    public PhoneBookFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = (View)inflater.inflate(R.layout.fragment_phone_book, container, false);
        return view;
    }
}
