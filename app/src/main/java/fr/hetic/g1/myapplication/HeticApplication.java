package fr.hetic.g1.myapplication;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Florian ALONSO on 11/13/17.
 * For Neopixl
 */

public class HeticApplication extends Application {

    private RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();

        // Il faut cree la request queue dans l'application car si on le fait dans l'activiter
        // Quand on change d'activité celle-ci est detruite et donc la requete aussi
        requestQueue = Volley.newRequestQueue(this);
        requestQueue.start();
    }

    public RequestQueue getRequestQueue() {
        return this.requestQueue;
    }
}
