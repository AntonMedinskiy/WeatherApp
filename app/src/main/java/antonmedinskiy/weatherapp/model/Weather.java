package antonmedinskiy.weatherapp.model;

import android.util.Log;
import antonmedinskiy.weatherapp.OnWeatherGot;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class Weather {
    WeatherApi.ApiInterface api;
    String CityName;
    OnWeatherGot listener;

    public Weather(String name, OnWeatherGot listener) {
        CityName = name;
        this.listener = listener;
        api = WeatherApi.getClient().create(WeatherApi.ApiInterface.class);
        downloadWeatherForToday();
        downloadWeatherForecast();
    }


    private void downloadWeatherForToday(){

        String units = "metric";
        String key = WeatherApi.KEY;
        // get weather for today
        Call<WeatherDay> callToday = api.getToday(CityName, units, key);
        callToday.enqueue(new Callback<WeatherDay>(){
            @Override
            public void onResponse(Call<WeatherDay> call, Response<WeatherDay> response) {
                Log.e(TAG, "onResponse");
                Log.d(TAG, response.toString());

                if (response.isSuccessful()) {
                    listener.onWeatherGot(response.body());

                }
            }
            @Override
            public void onFailure(Call<WeatherDay> call, Throwable t) {
                Log.e(TAG, "onFailure");
                Log.e(TAG, t.toString());
            }
        });

    }

    public void downloadWeatherForecast(){
        String cityName = CityName;

        String units = "metric";
        String key = WeatherApi.KEY;
        // get weather forecast
        Call<WeatherForecast> callForecast = api.getForecast(cityName,units, key);
        callForecast.enqueue(new Callback<WeatherForecast>() {
            @Override
            public void onResponse(Call<WeatherForecast> call, Response<WeatherForecast> response) {
                Log.e(TAG, "onResponse");
                Log.d(TAG,response.toString());
                if (response.isSuccessful()) {
                    listener.onForecastGot(response.body());
                }
            }
            @Override
            public void onFailure(Call<WeatherForecast> call, Throwable t) {
                Log.e(TAG, "onFailure");
                Log.e(TAG, t.toString());
            }
        });

    }
}
