package antonmedinskiy.weatherapp.model.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

/**
 * Created by Антон on 23.09.2017.
 */
@Entity
public class CityEntity {

    @Id (autoincrement = true)
    private Long id;

    @NotNull
    @ToOne
    private WeatherDayEntity wde;

    @NotNull
    @ToOne
    private WeatherForecastEntity wfe;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1928598513)
    private transient CityEntityDao myDao;

    @Generated(hash = 159492260)
    public CityEntity(Long id) {
        this.id = id;
    }

    @Generated(hash = 2001321047)
    public CityEntity() {
    }

    public CityEntity(WeatherDayEntity wde, WeatherForecastEntity wfe) {
        this.wde = wde;
        this.wfe = wfe;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Generated(hash = 1443835676)
    private transient boolean wde__refreshed;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1017012883)
    public WeatherDayEntity getWde() {
        if (wde != null || !wde__refreshed) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            WeatherDayEntityDao targetDao = daoSession.getWeatherDayEntityDao();
            targetDao.refresh(wde);
            wde__refreshed = true;
        }
        return wde;
    }

    /** To-one relationship, returned entity is not refreshed and may carry only the PK property. */
    @Generated(hash = 1322619256)
    public WeatherDayEntity peakWde() {
        return wde;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 54093163)
    public void setWde(@NotNull WeatherDayEntity wde) {
        if (wde == null) {
            throw new DaoException(
                    "To-one property 'wde' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.wde = wde;
            wde__refreshed = true;
        }
    }

    @Generated(hash = 1118025029)
    private transient boolean wfe__refreshed;

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 7728071)
    public WeatherForecastEntity getWfe() {
        if (wfe != null || !wfe__refreshed) {
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            WeatherForecastEntityDao targetDao = daoSession
                    .getWeatherForecastEntityDao();
            targetDao.refresh(wfe);
            wfe__refreshed = true;
        }
        return wfe;
    }

    /** To-one relationship, returned entity is not refreshed and may carry only the PK property. */
    @Generated(hash = 1253721513)
    public WeatherForecastEntity peakWfe() {
        return wfe;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 95787640)
    public void setWfe(@NotNull WeatherForecastEntity wfe) {
        if (wfe == null) {
            throw new DaoException(
                    "To-one property 'wfe' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.wfe = wfe;
            wfe__refreshed = true;
        }
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 564858177)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getCityEntityDao() : null;
    }

}
