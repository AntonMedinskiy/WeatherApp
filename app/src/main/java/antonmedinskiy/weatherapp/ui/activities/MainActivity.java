package antonmedinskiy.weatherapp.ui.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import antonmedinskiy.weatherapp.R;
import antonmedinskiy.weatherapp.ui.fragments.Tab2Fragment;
import antonmedinskiy.weatherapp.adapter.SectionsPageAdapter;

import antonmedinskiy.weatherapp.ui.fragments.Tab1Fragment;


public class MainActivity extends AppCompatActivity {
    private SectionsPageAdapter mSectionsPageAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager)findViewById(R.id.container);
        setUpViewPager(mViewPager);
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    private void setUpViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1Fragment(),getResources().getString(R.string.tab1_title));
        adapter.addFragment(new Tab2Fragment(),getResources().getString(R.string.tab2_title));

        viewPager.setAdapter(adapter);
    }
}