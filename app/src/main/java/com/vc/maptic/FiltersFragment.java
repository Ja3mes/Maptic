package com.vc.maptic;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Spinner;


public class FiltersFragment extends Fragment {

    public FiltersFragment() {
        // Required empty public constructor
    }

    RadioButton iRadioButtonDistance;
    RadioButton iRadioButtonRelevance;
    Spinner iFLandmarkSpinner;
    Button BackButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_filters, container, false);

        iRadioButtonDistance = v.findViewById(R.id.radioButtonDistance);
        iRadioButtonRelevance = v.findViewById(R.id.radioButtonRelevance);
        iFLandmarkSpinner = v.findViewById(R.id.fLandmarkSpinner);
        BackButton = v.findViewById(R.id.backButton);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.landmark_array, R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        iFLandmarkSpinner.setAdapter(adapter);

        iRadioButtonDistance.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    iRadioButtonRelevance.setChecked(false);
                }

            }
        });

        iRadioButtonRelevance.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    iRadioButtonDistance.setChecked(false);
                }
            }
        });

        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), MainActivity.class));
            }
        });



        return v;
    }


}