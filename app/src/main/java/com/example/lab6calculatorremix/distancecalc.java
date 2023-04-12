package com.example.lab6calculatorremix;


import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.example.lab6calculatorremix.databinding.DistancecalcBinding;

import java.text.DecimalFormat;

public class distancecalc extends Fragment {
    private DistancecalcBinding binding;

    EditText valueMiles;
    EditText valueKilometers;

    private double miles;
    private double kilometers;

    DecimalFormat df = new DecimalFormat(".00");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DistancecalcBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.distanceConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Log.i(TAG, "Button clicked!");
                String tag = view.getTag().toString();

                if (tag.equals("distanceConvert")) {

                    valueMiles = valueMiles.findViewById(R.id.mileOutput);
                    valueKilometers = valueKilometers.findViewById(R.id.kilometerOutput);

                    String strMiles = valueMiles.getText().toString();
                    String strKilometers = valueKilometers.getText().toString();



                    if(valueMiles != null){
                        try {

                            miles = Double.parseDouble(strMiles);

                            kilometers = (miles * 1.609344);


                            binding.mileOutput.setText(String.valueOf(df.format(kilometers)));
                            binding.kilometerOutput.setText(String.valueOf(df.format(miles)));
                        }
                        catch (Exception e){
                            kilometers = Double.parseDouble(strKilometers);

                            miles = (kilometers * 0.621371);

                            binding.mileOutput.setText(String.valueOf(df.format(kilometers)));
                            binding.kilometerOutput.setText(String.valueOf(df.format(miles)));
                        }


                    }


            }
        };
    });
}}