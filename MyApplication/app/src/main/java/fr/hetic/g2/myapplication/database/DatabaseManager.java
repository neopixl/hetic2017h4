package fr.hetic.g2.myapplication.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Florian ALONSO on 11/20/17.
 * For Neopixl
 */

public class DatabaseManager {

    // Il s'agit d'un singleton
    private static DatabaseManager instance;
    public static DatabaseManager getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseManager(context);
        }
        return instance;
    }


    private DaoMaster.DevOpenHelper helper;
    private SQLiteDatabase db;
    private DaoMaster daoMaster;
    private DaoSession daoSession;

    // Le constructeur est privée pour bloquer la creation
    private DatabaseManager(Context context) {
        helper = new DaoMaster.DevOpenHelper(context, "groupe2", null);
        db = helper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public PersonDBDao getPersonDao() {
        return daoSession.getPersonDBDao();
    }

    public PhoneDBDao getPhoneDao() {
        return daoSession.getPhoneDBDao();
    }
}
