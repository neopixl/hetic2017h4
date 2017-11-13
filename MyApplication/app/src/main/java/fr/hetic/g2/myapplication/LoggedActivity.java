package fr.hetic.g2.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.IItem;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import com.mikepenz.fastadapter.listeners.OnClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fr.hetic.g2.myapplication.item.ContactItem;

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


        ItemAdapter<ContactItem> itemAdapter = new ItemAdapter<>();
        FastAdapter fastAdapter = FastAdapter.with(itemAdapter);
        recyclerView.setAdapter(fastAdapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);


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
                Toast.makeText(LoggedActivity.this, "Clicker sur "+ position, Toast.LENGTH_SHORT).show();

                String name = nameList.get(position);
                Toast.makeText(LoggedActivity.this, name, Toast.LENGTH_SHORT).show();

                adapter.getFastAdapter().notifyAdapterItemChanged(position);
                return false;
            }

        });



    }

}
