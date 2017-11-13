package fr.hetic.g1.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ButterKnife.bind(this);


        List<String> nameList = new ArrayList<>();
        nameList.add("Florian");
        nameList.add("Joris");
        nameList.add("Yvan");
        nameList.add("David");
        nameList.add("Antoine");

        for (int index = 0; index < 6000; index++) {
            nameList.add("Florian_"+ index);
        }


        ItemAdapter<ContactItem> itemAdapter = new ItemAdapter();
        FastAdapter fastAdapter = FastAdapter.with(itemAdapter);

        for (String name : nameList) {
            ContactItem contactItem = new ContactItem();
            contactItem.name = name;
            itemAdapter.add(contactItem);
        }

        recyclerView.setAdapter(fastAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
