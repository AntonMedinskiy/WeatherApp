package antonmedinskiy.weatherapp;

import antonmedinskiy.weatherapp.model.WeatherDay;
import antonmedinskiy.weatherapp.model.WeatherForecast;

/**
 * Created by Антон on 21.09.2017.
 */

public interface OnWeatherGot {
    void onWeatherGot(WeatherDay wd);
    void onForecastGot(WeatherForecast wf);
}
