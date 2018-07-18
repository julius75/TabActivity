package com.chain.tabactivity.Interface;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chain.tabactivity.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class SuggestionFragment extends Fragment {
    View view;

    public SuggestionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view = inflater.inflate(R.layout.fragment_suggestion, container, false);
         return  view;
    }

}
