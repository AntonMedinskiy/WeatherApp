package antonmedinskiy.weatherapp.utils;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;
import antonmedinskiy.weatherapp.App;
import antonmedinskiy.weatherapp.model.WeatherDay;
import antonmedinskiy.weatherapp.model.WeatherForecast;
import antonmedinskiy.weatherapp.model.db.CityEntity;
import antonmedinskiy.weatherapp.model.db.CityEntityDao;
import antonmedinskiy.weatherapp.model.db.DaoSession;
import antonmedinskiy.weatherapp.model.db.WeatherDayEntity;
import antonmedinskiy.weatherapp.model.db.WeatherDayEntityDao;
import antonmedinskiy.weatherapp.model.db.WeatherForecastEntity;
import antonmedinskiy.weatherapp.model.db.WeatherForecastEntityDao;

public class WeatherService {

    private CityEntityDao mCityEntityDao;
    private DaoSession mDaoSession;

    public WeatherService(Activity activity) {
        mDaoSession =((App)activity.getApplication()).getDaoSession();
        mCityEntityDao = mDaoSession.getCityEntityDao();
    }


    public void addCityToDb(WeatherDay wd, WeatherForecast wf){
        CityEntity cityEntity = new CityEntity(getWeatherDayEntity(wd),getWeatherForecastEntity(wf));
        mCityEntityDao.insert(cityEntity);

    }
    private WeatherDayEntity getWeatherDayEntity(final WeatherDay wd){
        WeatherDayEntity weatherDayEntity = convert(wd);
        return weatherDayEntity;
    }

    private  WeatherForecastEntity getWeatherForecastEntity(final WeatherForecast wf){

        List<WeatherDayEntity> weatherDayEntities = new ArrayList<>();
        for ( WeatherDay item : wf.getItems()){
           weatherDayEntities.add(convert(item));
        }
        WeatherForecastEntity weatherForecastEntity = new WeatherForecastEntity(weatherDayEntities);
            return weatherForecastEntity;
    }

    private WeatherDayEntity convert(WeatherDay wd){
        WeatherDayEntity weatherDayEntity = new WeatherDayEntity();
        weatherDayEntity.setName(wd.getCity());
        weatherDayEntity.setCountry(wd.getCountry());
        weatherDayEntity.setIcon(wd.getIconUrl());

        return weatherDayEntity;
    }



    public List<CityEntity> getCityEntities() {
        return mCityEntityDao.loadAll();
    }
}
