package antonmedinskiy.weatherapp.ui.activities;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import android.widget.LinearLayout.LayoutParams;
import antonmedinskiy.weatherapp.OnWeatherGot;
import antonmedinskiy.weatherapp.R;
import antonmedinskiy.weatherapp.model.Weather;
import antonmedinskiy.weatherapp.model.WeatherDay;
import antonmedinskiy.weatherapp.model.WeatherForecast;
import antonmedinskiy.weatherapp.utils.WeatherService;


public class WeatherActivity extends AppCompatActivity implements OnWeatherGot, View.OnClickListener {
    String TAG = "WEATHER";
    TextView tvTemp;
    ImageView tvImage;
    LinearLayout llForecast;
    Weather weather;
    WeatherDay weatherDay;
    WeatherForecast weatherForecast;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        Bundle b = getIntent().getExtras();
            weather = new Weather(b.getString("cityName"),this);
        tvTemp = (TextView) findViewById(R.id.tvTemp);
        tvImage = (ImageView) findViewById(R.id.ivImage);
        llForecast = (LinearLayout) findViewById(R.id.llForecast);
        saveButton =(Button)findViewById(R.id.saveButton);
        saveButton.setOnClickListener(this);

    }

    public void displayWeather(WeatherDay wd) {

            tvTemp.setText(wd.getCity() + "," + wd.getCountry() + " " + wd.getTempWithDegree());
            Glide.with(WeatherActivity.this).load(wd.getIconUrl()).into(tvImage);

    }

   private void displayForecast(WeatherForecast wf){

       SimpleDateFormat formatDayOfWeek = new SimpleDateFormat("E");
       LayoutParams paramsTextView = new LayoutParams(
               LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
       LayoutParams paramsImageView = new LayoutParams(convertDPtoPX(40, WeatherActivity.this),
               convertDPtoPX(40, WeatherActivity.this));

       int marginRight = convertDPtoPX(15, WeatherActivity.this);
       LayoutParams paramsLinearLayout = new LayoutParams(LayoutParams.WRAP_CONTENT,
               LayoutParams.WRAP_CONTENT);
       paramsLinearLayout.setMargins(0, 0, marginRight, 0);

       llForecast.removeAllViews();

       for (WeatherDay day : wf.getItems()) {
           if ((day.getDate().get(Calendar.HOUR_OF_DAY)) == 15) {
               String date = String.format("%d.%d.%d %d:%d",
                       day.getDate().get(Calendar.DAY_OF_MONTH),
                       day.getDate().get(Calendar.WEEK_OF_MONTH),
                       day.getDate().get(Calendar.YEAR),
                       day.getDate().get(Calendar.HOUR_OF_DAY),
                       day.getDate().get(Calendar.MINUTE)
               );
               Log.d(TAG, date);
               Log.d(TAG, day.getTempInteger());
               Log.d(TAG, "---");

               // child view wrapper
               LinearLayout childLayout = new LinearLayout(WeatherActivity.this);
               childLayout.setLayoutParams(paramsLinearLayout);
               childLayout.setOrientation(LinearLayout.VERTICAL);

               // show day of week
               TextView tvDay = new TextView(WeatherActivity.this);
               String dayOfWeek = formatDayOfWeek.format(day.getDate().getTime());
               tvDay.setText(dayOfWeek);
               tvDay.setLayoutParams(paramsTextView);
               childLayout.addView(tvDay);

               // show image
               ImageView ivIcon = new ImageView(WeatherActivity.this);
               ivIcon.setLayoutParams(paramsImageView);
               Glide.with(WeatherActivity.this).load(day.getIconUrl()).into(ivIcon);
               childLayout.addView(ivIcon);

               // show temp
               TextView tvTemp = new TextView(WeatherActivity.this);
               tvTemp.setText(day.getTempWithDegree());
               tvTemp.setLayoutParams(paramsTextView);
               childLayout.addView(tvTemp);

               llForecast.addView(childLayout);
           }
           }
       }


    public int convertDPtoPX(int dp, Context ctx) {
        float density = ctx.getResources().getDisplayMetrics().density;
        int px = (int)(dp * density);
        return px;
    }

    @Override
    public void onWeatherGot(WeatherDay wd) {
    displayWeather(wd);
        weatherDay = wd;
    }

    @Override
    public void onForecastGot(WeatherForecast wf) {
        displayForecast(wf);
        weatherForecast = wf;
    }

    @Override
    public void onClick(View view) {
        WeatherService ws = new WeatherService(this);
        ws.addCityToDb(weatherDay,weatherForecast);

    }
}
