package fr.hetic.g2.myapplication;

import android.graphics.Color;
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

    void recapJava() {

        int age = 50;
        float agef = 50f;
        boolean jeSuisBeau = true;

        int[] lesAges = {10, 10, 25};
        lesAges[0] = 5;
        //lesAges[3] = 5;
        int taille = lesAges.length;

        List<Integer> lesList = new ArrayList<>();
        lesList.add(10);
        lesList.add(10);
        lesList.add(25);
        lesList.add(42);
        lesList.add(null);
        int taille2 = lesList.size();


        //lesList.add(50, 44);



        Map<Color, Integer> monDico = new HashMap<>();
        //monDico.put(Color.valueOf(Color.RED), 54);
        //monDico.put(Color.valueOf(Color.GREEN), 34);
        //monDico.put(Color.valueOf(Color.RED), 10);


        String monPrenom = "Florian";



        int deux = 2;
        deux++;
        deux += 1;
        deux = deux + 1;


        deux = 2;
        int plusPlusDeux = ++deux; // 3
        deux = 2;
        int deuxPlusPlus = deux++; // 2
        // Deux --> 3
        // plusPlusDeux --> 3
        // deuxPlusPlus --> 2


        int leNombreParfaitDePokemon = 151;
        int leNombreActuelDePokemon = 999;
        int leNombreActuelDeleve = 50;
        int leNombreParfaitDeleve = 0;

        if (leNombreParfaitDePokemon == leNombreActuelDePokemon) {
            Log.d("Hey", "Youpie");
        }

        if (leNombreParfaitDePokemon != leNombreActuelDePokemon) {
            Log.d("Hey", "Triste");
        }

        if (leNombreParfaitDePokemon >= leNombreActuelDePokemon) {
            Log.d("Hey", "Y'en as moins");
        }

        if (leNombreParfaitDePokemon <= leNombreActuelDePokemon) {
            Log.d("Hey", "Y'en as plus");
        }




        if (leNombreParfaitDePokemon == leNombreActuelDePokemon
                && leNombreParfaitDeleve == leNombreActuelDeleve) {
            Log.d("Hey", "Ma vie est belle");
        } else if (leNombreParfaitDePokemon == leNombreActuelDePokemon
                || leNombreParfaitDeleve == leNombreActuelDeleve) {
            Log.d("Hey", "C'est bien, mais peu mieux faire");
        } else {
            Log.d("Hey", "Ma vie est triste");
        }


        List<Boolean> estCeQueCestLeWeekend = new ArrayList<>();
        estCeQueCestLeWeekend.add(false); // Lundi
        estCeQueCestLeWeekend.add(false); // Mardi
        estCeQueCestLeWeekend.add(false);
        estCeQueCestLeWeekend.add(false);
        estCeQueCestLeWeekend.add(false);
        estCeQueCestLeWeekend.add(true); // Samedi
        estCeQueCestLeWeekend.add(true);// Dimanche

        int combienDeJourWeekend = 0;
        for (
                int index = 0
                ; index < estCeQueCestLeWeekend.size()
                ; index += 1) {


            boolean monJourActuel = estCeQueCestLeWeekend.get(index);
            if (monJourActuel == true) {
                combienDeJourWeekend = combienDeJourWeekend + 1;
            }
        }

        combienDeJourWeekend = 0;
        for (boolean valeur : estCeQueCestLeWeekend) {
            if (valeur == true) {
                combienDeJourWeekend = combienDeJourWeekend + 1;
            }
        }
        Log.d("Nombre de jour weekend", "Voici "+ combienDeJourWeekend);


        int index = 0;
        while (index < estCeQueCestLeWeekend.size()) {
            boolean monJourActuel = estCeQueCestLeWeekend.get(index);
            if (monJourActuel == true) {
                combienDeJourWeekend = combienDeJourWeekend + 1;
            }
            index++;
        }

        do {

        } while (index < estCeQueCestLeWeekend.size());



        boolean estVrai = estCeQueJeSuisVrai(false);
        // estVrai --> false
        faireDesTruc(4);
        // Je fait des trucs
        // Je fait des trucs
        // Je fait des trucs
        // Je fait des trucs






        Chat monChat = new Chat();
        monChat.age = 10;
        monChat.prenom = "Boule de neige";
        monChat.miauler();
        monChat.manger(100);


        Chat monChat2 = null;
        monChat2.manger(10);












    }

    /*function maFonction(param1, param2) {

    }*/
    boolean estCeQueJeSuisVrai(boolean value) {
        return value == true;
    }

    void faireDesTruc(int nombreDeFois) {
        for (
             int index = 0
             ; index < nombreDeFois
             ; index++
             ) {
            Log.d("Truc", "Je fait des trucs");
        }
    }


}
