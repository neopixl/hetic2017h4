package fr.hetic.g1.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.hetic.g1.myapplication.item.ContactItem;
import fr.hetic.g1.myapplication.request.response.PersonResponse;
import fr.hetic.g1.myapplication.request.response.RandomNamesResponse;

public class ListActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ButterKnife.bind(this);

        Map<String, String> headers = new HashMap<>();
        headers.put("X-PROVENANCE", "HETIC");


        // Lance une requette reseau pour recuperer des noms aleatoire sur le site randomuser.me
        BaseRequest<RandomNamesResponse> request =
                new BaseRequest.Builder<>(Request.Method.GET,
                    "https://randomuser.me/api/?results=100", RandomNamesResponse.class)
                .listener(new RequestListener<RandomNamesResponse>() {
                    @Override
                    public void onSuccess(Request request, NetworkResponse response, RandomNamesResponse result) {
                        List<String> emailList = new ArrayList<>();
                        for (PersonResponse person : result.getResults()) {
                            emailList.add(person.getEmail());
                        }

                        fillRecycler(emailList);
                    }

                    @Override
                    public void onFailure(Request request, NetworkResponse response, VolleyError error) {
                        Toast.makeText(ListActivity.this, "FAIL", Toast.LENGTH_SHORT).show();
                    }
                })
                        .headers(headers)
                        .build();

        request.setTag("1");

        HeticApplication heticApplication =
                (HeticApplication) getApplication();

        heticApplication.getRequestQueue().add(request);
        //heticApplication.getRequestQueue().cancelAll("1");



        // START Generation random de nom
        final List<String> nameList = new ArrayList<>();
        nameList.add("Florian");
        nameList.add("Joris");
        nameList.add("Yvan");
        nameList.add("David");
        nameList.add("Antoine");
        for (int index = 0; index < 6000; index++) {
            nameList.add("Florian_"+ index);
        }
        // END

        fillRecycler(nameList);






    }


    public void fillRecycler(final List<String> nameList) {
        // Crée les adapteur de la library
        ItemAdapter<ContactItem> itemAdapter = new ItemAdapter();
        FastAdapter fastAdapter = FastAdapter.with(itemAdapter);

        for (String name : nameList) {
            ContactItem contactItem = new ContactItem();
            contactItem.name = name;
            itemAdapter.add(contactItem);
        }

        recyclerView.setAdapter(fastAdapter);

        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(this,
                        LinearLayoutManager.VERTICAL,
                        false);
        layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);
        // Defini le layout en grid, donc en grille de 3 colone

        fastAdapter.withSelectable(true);
        fastAdapter.withMultiSelect(false);
        fastAdapter.withOnClickListener(new OnClickListener() {
            @Override
            public boolean onClick(View v, IAdapter adapter, IItem item, int position) {

                // Lors du click on affiche les information
                Toast.makeText(ListActivity.this,
                        "Cliked on "+ position,
                        Toast.LENGTH_SHORT).show();

                String name = nameList.get(position);
                Toast.makeText(ListActivity.this,
                        name,
                        Toast.LENGTH_SHORT).show();

                // Demande à l'adapter de faire un refresh de cet item
                // Est donc il ce redesine en prennant en compte le changement
                // De couleurs
                adapter.getFastAdapter().notifyAdapterItemChanged(position);


                return false;
            }
        });
    }
}
