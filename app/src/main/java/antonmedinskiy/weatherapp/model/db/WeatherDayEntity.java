package antonmedinskiy.weatherapp.model.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Антон on 23.09.2017.
 */
@Entity
public class WeatherDayEntity {
    
    @Id(autoincrement = true)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String temp;
    @NotNull
    private String icon;
    @NotNull
    private String country;

    private Long dayId;


    @Generated(hash = 1262748097)
    public WeatherDayEntity(Long id, @NotNull String name, @NotNull String temp,
            @NotNull String icon, @NotNull String country, Long dayId) {
        this.id = id;
        this.name = name;
        this.temp = temp;
        this.icon = icon;
        this.country = country;
        this.dayId = dayId;
    }

    @Generated(hash = 2042966413)
    public WeatherDayEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDayId() {
        return this.dayId;
    }

    public void setDayId(Long dayId) {
        this.dayId = dayId;
    }
}
