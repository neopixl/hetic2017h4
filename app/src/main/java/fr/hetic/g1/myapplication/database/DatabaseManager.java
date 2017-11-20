package fr.hetic.g1.myapplication.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Florian ALONSO on 11/20/17.
 * For Neopixl
 */

public class DatabaseManager {


    // This is a singleton
    private static DatabaseManager intances;

    public static DatabaseManager getIntances(Context context) {
        if (intances == null) {
            intances = new DatabaseManager(context);
        }
        return intances;
    }


    private Context context;
    private DaoMaster.DevOpenHelper helper;
    private SQLiteDatabase db;
    private DaoMaster daoMaster;
    private DaoSession daoSession;

    // Constructeur par defaut privé avec le contexte
    private DatabaseManager(Context context) {
        this.context = context;

        helper = new DaoMaster.DevOpenHelper(context, "groupe1", null);
        db = helper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public PersonDBDao getPersonDBDao() {
        return daoSession.getPersonDBDao();
    }

    public PhoneDBDao getPhoneDBDao() {
        return daoSession.getPhoneDBDao();
    }
}
