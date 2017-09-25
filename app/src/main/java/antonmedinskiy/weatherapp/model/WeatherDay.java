package antonmedinskiy.weatherapp.model;

import com.google.gson.annotations.SerializedName;


import java.util.Calendar;
import java.util.List;

public class WeatherDay {
    public class WeatherTemp {
        Double temp;
    }

    public class WeatherDescription {
        String icon;
    }
    public class Sys{
        String country;
    }

    @SerializedName("sys")
    private Sys sys;

    @SerializedName("main")
    private WeatherTemp temp;

    @SerializedName("weather")
    private List<WeatherDescription> description;

    @SerializedName("name")
    private String city;

    @SerializedName("dt")
    private long timestamp;

    public WeatherDay(WeatherTemp temp, List<WeatherDescription> description, Sys sys) {
        this.temp = temp;
        this.description = description;
        this.sys = sys;
    }

    public Calendar getDate() {
        Calendar date = Calendar.getInstance();
        date.setTimeInMillis(timestamp * 1000);
        return date;
    }

    public String getTemp() { return String.valueOf(temp.temp); }

    public String getTempInteger() { return String.valueOf(temp.temp.intValue()); }

    public String getTempWithDegree() { return String.valueOf(temp.temp.intValue()) + "\u00B0"; }

    public String getCity() { return city; }

    public String getCountry(){
        return String.valueOf(sys.country);
    }



    public String getIcon() { return description.get(0).icon; }

    public String getIconUrl() {
        return "http://openweathermap.org/img/w/" + description.get(0).icon + ".png";
    }
}