package fr.hetic.g2.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import com.mikepenz.fastadapter.listeners.OnClickListener;
import com.neopixl.spitfire.listener.RequestListener;
import com.neopixl.spitfire.request.BaseRequest;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.hetic.g2.myapplication.database.DatabaseManager;
import fr.hetic.g2.myapplication.database.PersonDB;
import fr.hetic.g2.myapplication.database.PersonDBDao;
import fr.hetic.g2.myapplication.database.PhoneDB;
import fr.hetic.g2.myapplication.database.PhoneDBDao;
import fr.hetic.g2.myapplication.item.ContactItem;
import fr.hetic.g2.myapplication.response.PersonResponse;
import fr.hetic.g2.myapplication.response.RandomNamesResponse;

public class LoggedActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged);

        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setResult(RESULT_OK);
                LoggedActivity.this.finish();
            }
        });



        final List<String> nameList = new ArrayList<>();
        for (int index = 0 ; index < 6000; index++) {
            nameList.add("Florian_"+ index);
        }

        fillrecycler(nameList);

        loadDistantNames();
    }

    public void fillrecycler(final List<String> nameList) {
        // Crée les adapteur de la library

        ItemAdapter<ContactItem> itemAdapter = new ItemAdapter<>();
        FastAdapter fastAdapter = FastAdapter.with(itemAdapter);
        recyclerView.setAdapter(fastAdapter);

        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        layoutManager =
                new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);
        // Defini le layout en grid, donc en grille de 3 colone


        for (String name : nameList) {
            ContactItem item = new ContactItem();
            item.name = name;
            itemAdapter.add(item);
        }

        fastAdapter.withSelectable(true);
        fastAdapter.withMultiSelect(false);
        fastAdapter.withOnClickListener(new OnClickListener() {

            @Override
            public boolean onClick(View v, IAdapter adapter, IItem item, int position) {
                // Lors du click on affiche les information
                Toast.makeText(LoggedActivity.this, "Clicker sur "+ position, Toast.LENGTH_SHORT).show();

                String name = nameList.get(position);
                Toast.makeText(LoggedActivity.this, name, Toast.LENGTH_SHORT).show();

                // Demande à l'adapter de faire un refresh de cet item
                // Est donc il ce redesine en prennant en compte le changement
                // De couleurs
                adapter.getFastAdapter().notifyAdapterItemChanged(position);
                return false;
            }

        });
    }

    public void loadDistantNames() {
        // Lance une requette reseau pour recuperer des noms aleatoire sur le site randomuser.me
        BaseRequest<RandomNamesResponse> request =
                new BaseRequest.Builder<>(Request.Method.GET
                        , "https://randomuser.me/api/?results=100"
                        , RandomNamesResponse.class)
                        .listener(new RequestListener<RandomNamesResponse>() {
                            @Override
                            public void onSuccess(Request request, NetworkResponse response, RandomNamesResponse result) {
                                fillRecyclerFromRandomNamesResponse(result); // Affiche les valeur a l'ecrans
                                fillDatabase(result.getResults()); // Remplie la BDD
                                deleteJames(); // Supprime les James de la BDD
                                diplayPeopleNumber(); // Affiche le nombre de personne dans la BDD
                            }

                            @Override
                            public void onFailure(Request request, NetworkResponse response, VolleyError error) {
                                Toast.makeText(LoggedActivity.this, "FAIL", Toast.LENGTH_SHORT).show();
                            }
                        })
                .build();


        HeticApplication heticApplication =
                (HeticApplication) getApplication();
        heticApplication.getRequestQueue().add(request);
    }

    public void fillRecyclerFromRandomNamesResponse(RandomNamesResponse response) {
        List<String> distantNameList = new ArrayList<>();

        for (PersonResponse personResponse : response.getResults()) {
            String name = personResponse.getName().getFirst();
            distantNameList.add(name);
        }

        fillrecycler(distantNameList);
    }

    public void diplayPeopleNumber() {
        // Affiche le nombre de personne en DB grace a un TOAST.

        DatabaseManager manager = DatabaseManager.getInstance(this);
        PersonDBDao personDBDao = manager.getPersonDao();

        List<PersonDB> personDBList = personDBDao
                .queryBuilder()
                .where(PersonDBDao.Properties.Firstname.isNotNull())
                .list();

        int size = personDBList.size();

        Toast.makeText(this,
                "Il y'a "+ size +" Personnes",
                Toast.LENGTH_SHORT).show();


        // recupere une seulle personne
        PhoneDB phoneDB = manager.getPhoneDao().
                queryBuilder()
                .where(PhoneDBDao.Properties.Id.eq(0))
                .unique();
        Toast.makeText(this,
                "La premiere personne est : "+ phoneDB.getPerson().getFirstname(),
                Toast.LENGTH_SHORT).show();
    }

    public void fillDatabase(List<PersonResponse> personResponseList) {
        // Remplie la DB grace a la requette internet

        DatabaseManager manager = DatabaseManager.getInstance(this);
        PersonDBDao personDBDao = manager.getPersonDao();

        for (int index = 0; index < personResponseList.size(); index++) {
            PersonResponse personResponse = personResponseList.get(index);

            long id = index;
            String firstname = personResponse.getName().getFirst();
            String lastname = personResponse.getName().getLast();

            PersonDB personDB = new PersonDB();
            personDB.setId(id);
            personDB.setFirstname(firstname);
            personDB.setLastname(lastname);

            personDBDao.insertOrReplace(personDB);
            //personDBDao.insert(personDB);
            //personDBDao.update(personDB);
            //personDBDao.delete(personDB);

            long idPhone = index;
            String phoneNumber = personResponse.getPhone();

            PhoneDB phoneDB = new PhoneDB();
            phoneDB.setId(idPhone);
            phoneDB.setNumber(phoneNumber);
            phoneDB.setPersonId(id);

            manager.getPhoneDao().insertOrReplace(phoneDB);
        }
    }

    public void deleteJames() {
        // Supprime tous les james si y'a

        DatabaseManager manager = DatabaseManager.getInstance(this);
        PersonDBDao personDBDao = manager.getPersonDao();

        personDBDao.queryBuilder()
                .where(PersonDBDao.Properties.Firstname.like("%kai%"))
                .buildDelete()
                .executeDeleteWithoutDetachingEntities();
    }

}
