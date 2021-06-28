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

import com.google.firebase.auth.FirebaseAuth;

import static com.mapbox.mapboxsdk.Mapbox.getApplicationContext;

public class SettingsFragment extends Fragment {

    public SettingsFragment() {
        // Required empty public constructor
    }

    RadioButton iRadioButtonMiles;
    RadioButton iRadioButtonKM ;
    Spinner iLandmarkSpinner;
    Button Logout, BackButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_settings, container, false);

        iRadioButtonKM = v.findViewById(R.id.radioButtonRelevance);
        iRadioButtonMiles = v.findViewById(R.id.radioButtonDistance);
        iLandmarkSpinner = v.findViewById(R.id.sLandmarkSpinner);
        Logout = v.findViewById(R.id.logoutButton);
        BackButton = v.findViewById(R.id.backButton);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.landmark_array, R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        iLandmarkSpinner.setAdapter(adapter);

        iRadioButtonKM.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    iRadioButtonMiles.setChecked(false);
                }

            }
        });

        iRadioButtonMiles.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    iRadioButtonKM.setChecked(false);
                }
            }
        });

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getActivity(), Login.class));

            }
        });

        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

        return v;

    }
}