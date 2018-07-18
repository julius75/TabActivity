package com.chain.tabactivity.Interface;


import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chain.tabactivity.R;
import com.chain.tabactivity.model.Suggestion;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class SuggestionFragment extends Fragment {
    Activity activity = getActivity();
    View view;
    private EditText mPostTitle;
    private EditText mPostDesc;
    private ImageView mPostImage;
    private Button mSubmitButton;
    private DatabaseReference mPostDatabase;
    //private FirebaseDatabase mDatabase;
    private FirebaseUser mUser;
    private FirebaseAuth mAuth;
    private ProgressDialog mProgress;



    public SuggestionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view = inflater.inflate(R.layout.fragment_suggestion, container, false);

         mProgress = new ProgressDialog(getActivity());
         mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        mPostDatabase = FirebaseDatabase.getInstance().getReference().child("Suggestion");

        mPostTitle = view.findViewById(R.id.postTitle);
        mPostDesc = view.findViewById(R.id.postDesc);
        mPostImage = view.findViewById(R.id.postImage);
        mSubmitButton = view.findViewById(R.id.postsubmit);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "here", Toast.LENGTH_SHORT).show();
                startPosting();
            }
        });

         return  view;
    }

    private void startPosting() {
        mProgress.setMessage("Submitting...");
        mProgress.show();

        String titleVal = mPostTitle.getText().toString().trim();
        String descVal = mPostDesc.getText().toString().trim();
        if(!TextUtils.isEmpty(titleVal) &&  !TextUtils.isEmpty(descVal) ){
            //start uploading

            Suggestion suggestion = new Suggestion("Theft",
                    "look after our property","imageurl",
                    "user","day");
            mPostDatabase .setValue(suggestion).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(getContext(), "Submitted successfully",
                            Toast.LENGTH_LONG).show();
                    mProgress.dismiss();

                }
            });
        }
    }

}
