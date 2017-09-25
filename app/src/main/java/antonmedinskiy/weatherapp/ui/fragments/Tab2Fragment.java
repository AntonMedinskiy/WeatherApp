package antonmedinskiy.weatherapp.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import antonmedinskiy.weatherapp.R;
import antonmedinskiy.weatherapp.adapter.RecyclerAdapter;
import antonmedinskiy.weatherapp.model.db.CityEntity;
import antonmedinskiy.weatherapp.utils.WeatherService;

public class Tab2Fragment extends Fragment {

   private RecyclerView mRecyclerView;
    private List<CityEntity> mCities;
    RecyclerAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab2_fragment, container, false);
        mRecyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        mCities = new ArrayList<>();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        adapter = new RecyclerAdapter(mCities,getLayoutInflater(this.getArguments()));
        mRecyclerView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onResume() {
        WeatherService wf = new WeatherService(getActivity());
        mCities = wf.getCityEntities();
        adapter.setCities(mCities);
        super.onResume();
    }
}