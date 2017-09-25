package antonmedinskiy.weatherapp.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import antonmedinskiy.weatherapp.R;
import antonmedinskiy.weatherapp.ui.activities.WeatherActivity;


public class Tab1Fragment extends Fragment implements OnClickListener{
    EditText editText;
    Button searchButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1_fragment, container, false);
        editText = (EditText)view.findViewById(R.id.editText);
        searchButton = (Button)view.findViewById(R.id.button_search);
        searchButton.setOnClickListener(this);
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


       }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), WeatherActivity.class);
        Bundle b = new Bundle();
        b.putString("cityName",editText.getText().toString() );
        intent.putExtras(b);
        startActivity(intent);

    }
}