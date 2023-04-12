package com.example.lab6calculatorremix;

        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;
        import androidx.fragment.app.Fragment;
        import com.example.lab6calculatorremix.databinding.TempcalcBinding;
public class tempcalc extends Fragment {
    private TempcalcBinding binding;

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
                binding.reportCelsius.setText("Hello, World!");
            }
        });
    }
}