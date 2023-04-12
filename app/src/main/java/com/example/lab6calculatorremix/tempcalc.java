package com.example.lab6calculatorremix;

        import static android.content.ContentValues.TAG;

        import android.os.Bundle;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.EditText;
        import android.widget.ImageView;
        import android.widget.TextView;
        import androidx.fragment.app.Fragment;
        import com.example.lab6calculatorremix.databinding.TempcalcBinding;

        import java.text.DecimalFormat;

public class tempcalc extends Fragment {
    private TempcalcBinding binding;

    private float celsius;
    private float fahrenheit;

    EditText valueReportFahrenheit;
    EditText valueReportCelsius;

    DecimalFormat df = new DecimalFormat(".0");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = TempcalcBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.tempConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Button pressed.");
                String tag = view.getTag().toString();

                if (tag.equals("tempConvert")) {

                    valueReportFahrenheit = valueReportFahrenheit.findViewById(R.id.reportFahrenheit);
                    valueReportCelsius = valueReportCelsius.findViewById(R.id.reportCelsius);

                    String strFahrenheit = valueReportFahrenheit.getText().toString();
                    String strCelsius = valueReportCelsius.getText().toString();



                    if(valueReportFahrenheit != null){
                        try {

                            fahrenheit = Float.parseFloat(strFahrenheit);

                            celsius = ((fahrenheit - 32) * 5 / 9);


                            binding.reportCelsius.setText(String.valueOf(df.format(celsius)));
                            binding.reportFahrenheit.setText(String.valueOf(df.format(fahrenheit)));
                        }
                        catch (Exception e){
                            celsius = Float.parseFloat(strCelsius);

                            fahrenheit = (celsius * 9/5) + 32;

                            binding.reportCelsius.setText(String.valueOf(df.format(celsius)));
                            binding.reportFahrenheit.setText(String.valueOf(df.format(fahrenheit)));
                        }


                    }







                }
        }
    });
}}