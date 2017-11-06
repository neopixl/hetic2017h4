package fr.hetic.g2.myapplication;

import android.util.Log;

/**
 * Created by Florian ALONSO on 11/6/17.
 * For Neopixl
 */

public class Chat {

    int age;
    String prenom;

    void miauler() {
        Log.d("Le chat","Est en train de miauler");
    }

    void manger(int nombreDeCroquette) {
        Log.d("Le chat", "est en train de manger "+ nombreDeCroquette + "Croquette");
    }

}
