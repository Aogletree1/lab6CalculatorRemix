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
import com.example.lab6calculatorremix.databinding.TipcalcBinding;

import java.text.DecimalFormat;

public class tipcalc extends Fragment {
    private TipcalcBinding binding;

    EditText valueNumofPeople;
    EditText valueTotalBill;
    EditText valueTipPercentage;
    private float totalPerPerson;
    private float totalTip;

    DecimalFormat df = new DecimalFormat(".00");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = TipcalcBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Button clicked!");
                String tag = view.getTag().toString();

                if (tag.equals("tipCalculate")){


                    String NumofPeople = binding.valueNumofPeople.getText().toString();
                    String TotalBill = binding.valueTotalBill.getText().toString();
                    String TipPercent = binding.valueTipPercentage.getText().toString();

                    try{
                    int numofPeople = Integer.parseInt(NumofPeople);
                    float totalBill = Float.parseFloat(TotalBill);
                    float tipPercent = Float.parseFloat(TipPercent);
                    tipPercent = tipPercent/100;


                    totalTip = (totalBill * tipPercent);
                    totalPerPerson = ((totalBill * (tipPercent)) + totalBill) / numofPeople;


                    binding.end.setText(String.valueOf("Total Tip: $" + df.format(totalTip) + "\n" +
                            "Total Per Person: $ " + df.format(totalPerPerson)));

                        }

                    catch (Exception e){e.printStackTrace();}

                }


            }
        });
    }
}