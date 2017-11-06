package fr.hetic.g1.myapplication;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Florian ALONSO on 11/6/17.
 * For Neopixl
 */

public class GrosPate {

    static void recapJava() {




        int monEntier = 1;
        long monLong = 1l;
        float monFloat = 0.3f;
        boolean monBool = true;


        monEntier = 20;


        int[] monTableau = {1,2,3,4};
        monTableau[0] = 2;
        monTableau[1] = 2;
        monTableau[2] = 2;
        monTableau[3] = 2;
        int laLongeurDuTableau = monTableau.length; // 4


        int[][] monDoubleTableau = {{1,2}, {2,3}};
        monDoubleTableau[1][0] = 10;
        //{{1,2}, {10,3}};

        boolean[] monTableauBoolean = {true, true, false};

        int[] monTableauDepuisVariable = {1, 100, monEntier};
        //monTableauDepuisVariable[3] = 50;

        List<String> maListe = new ArrayList<>();
        String florianNom = "Florian";
        String yvanNom = "Yvan";

        maListe.add(florianNom);
        maListe.add(yvanNom);
        maListe.add(0, "Adrien");
        // Adrien
        // Florian
        // Yvan
        maListe.remove(0);
        // Florian
        // Yvan
        maListe.set(0, "Adrien");
        // Adrien
        // Yvan
        //maListe.add(100, "Marcel"); --> Ne marche pas ;)
        String adrien = maListe.get(0);



        List<Integer> maFauseListeDentier = new ArrayList<>();
        Integer monObjetEntier = new Integer(58);
        Boolean monObjetBoolean = new Boolean(false);
        Float monObjetFloat = new Float(1.2f);


        Map<String, Integer> monDictionaire = new HashMap<>();
        monDictionaire.put("Yvan", 1);
        monDictionaire.put("Florian", 65);
        monDictionaire.put("Marcel", 13);
        monDictionaire.get("Marcel");
        monDictionaire.remove("Marcel");
        monDictionaire.put("Florian", 44); // Remplace la valeur existante


        int monDix = 10;
        int monSix = 6;
        float resutat = monSix / monDix; // 1,4
        float resutat6 = Math.round(resutat); // 1,4
        int resutat3 = monSix / monDix; // 1
        int resutat2 = monSix % monDix; // 4

        monDix++; // 11
        monDix--; // 10
        monDix = monDix + 1; // 11
        monDix = monDix - 1; // 10
        ++monDix; // 11
        --monDix; // 10


        int deux = 2;
        int plusPlusDeux = ++deux; // 3
        deux = 2;
        int deuxPlusPlus = deux++; // 2

        // deux --> 3
        // plusPlusDeux --> 3
        // deuxPlusPlus --> 2

        if (deux == deuxPlusPlus) Log.d("Hey", "YOUPIE");
        if (deux != deuxPlusPlus) Log.d("Hey", "YOUPIE");
        if (deux > deuxPlusPlus) Log.d("Hey", "YOUPIE");
        if (deux < deuxPlusPlus) Log.d("Hey", "YOUPIE");
        if (deux >= deuxPlusPlus) Log.d("Hey", "YOUPIE");
        if (deux <= deuxPlusPlus) Log.d("Hey", "YOUPIE");


        int leNombreDeChatQueJai = 0;
        leNombreDeChatQueJai = leNombreDeChatQueJai + 1;
        leNombreDeChatQueJai++;
        leNombreDeChatQueJai += 100;
        leNombreDeChatQueJai -= 1;






        int leMeileurNombreDePokemon = 151;
        int leNombreActuelDePokemon = 999;
        int leNombreDeleve = 50;
        int leNombreParfaitDeleve = 0;

        if (leMeileurNombreDePokemon == leNombreActuelDePokemon
                && leNombreParfaitDeleve == leNombreDeleve) {
            Log.d("Message", "La vie est bele");
        } else if (leMeileurNombreDePokemon == leNombreActuelDePokemon
                || leNombreParfaitDeleve == leNombreDeleve) {
            Log.d("Message", "Peu mieux faire");
        } else {
            Log.d("Message", "La vie est nulle");
        }



        List<Boolean> estCeQueCestLeWeekEnd = new ArrayList<>();
        estCeQueCestLeWeekEnd.add(false); // Lundi
        estCeQueCestLeWeekEnd.add(false); // Mardi
        estCeQueCestLeWeekEnd.add(false);
        estCeQueCestLeWeekEnd.add(false);
        estCeQueCestLeWeekEnd.add(false);
        estCeQueCestLeWeekEnd.add(true);
        estCeQueCestLeWeekEnd.add(true); // Dimanche


        int nombreDeJourWeekend = 0;
        //for (int index = 0; ????; index++) {
        //for (int index = 0; ????; index += 1) {
        for (int index = 0
             ; index < estCeQueCestLeWeekEnd.size()
             ; index = index + 1) {

            boolean leJourActuel = estCeQueCestLeWeekEnd.get(index);
            if (leJourActuel == true) {
                nombreDeJourWeekend += 1;
            }

        }
        Log.d("Nombre de jour weekend", "Voici "+ nombreDeJourWeekend);



        int index = 0;
        while (index < estCeQueCestLeWeekEnd.size()) {
            boolean leJourActuel = estCeQueCestLeWeekEnd.get(index);
            if (leJourActuel == true) {
                nombreDeJourWeekend += 1;
            }
            index += 1;
        }
        // Ce code fait la meme chose

        do {

        } while (index < estCeQueCestLeWeekEnd.size());



        boolean test = estCequeCestVrai(false);


        Chat monChat = new Chat();
        monChat.age = 10;
        monChat.nom = "Boule de neige";
        monChat.poids = 200f;
    }

    static boolean estCequeCestVrai(boolean value) {
        return value == true;
    }
}
