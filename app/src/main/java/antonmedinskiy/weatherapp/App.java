package antonmedinskiy.weatherapp;

import android.app.Application;

import org.greenrobot.greendao.database.Database;

import antonmedinskiy.weatherapp.model.db.DaoMaster;
import antonmedinskiy.weatherapp.model.db.DaoSession;

/**
 * Created by Антон on 23.09.2017.
 */

public class App extends Application {
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "weather-db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}