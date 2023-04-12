package com.example.lab6calculatorremix;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.example.lab6calculatorremix.databinding.DistancecalcBinding;

public class distancecalc extends Fragment {
    private DistancecalcBinding binding;

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
            public void onClick(View view) {
                binding.kilometerOutput.setText("Hello, World!");
            }
        });
    }
}