package fr.hetic.mymoviedb.moviedb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.search_field)
    EditText searchField;

    @BindView(R.id.search_button)
    Button searchButton;

    @BindView(R.id.cancel_button)
    Button cancelButton;

    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        requestQueue = Volley.newRequestQueue(this);
    }

    @OnClick(R.id.cancel_button)
    public void cancelSearch() {
        searchField.setText("");
    }

    @OnClick(R.id.search_button)
    public void startSearchingForInformations() {
        String userText = searchField.getText().toString();

        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("api_key", "c1ac741d5dd740f9861e794c5363b0c2");
        parameters.put("query", userText);



        BaseRequest<FilmListResponse> request =
                new BaseRequest.Builder<>(
                        Request.Method.GET,
                        "http://api.themoviedb.org/3/search/movie",
                        FilmListResponse.class
                )

                .parameters(parameters)


                .listener(new RequestListener<FilmListResponse>() {
                    @Override
                    public void onSuccess(Request request, NetworkResponse response, FilmListResponse result) {
                        diplaysResult(result);
                    }

                    @Override
                    public void onFailure(Request request, NetworkResponse response, VolleyError error) {
                        Log.d("ERROR", "Network error");
                    }
                })


                .build();

        requestQueue.add(request);
    }

    public void diplaysResult(final FilmListResponse movieList) {
        Toast.makeText(
                MainActivity.this,
                "Total: "+ movieList.getTotal_results(),
                Toast.LENGTH_SHORT)

                .show();

        ItemAdapter<MovieItem> itemAdapter = new ItemAdapter<>();
        FastAdapter fastAdapter = FastAdapter.with(itemAdapter);

        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(this,
                        LinearLayoutManager.VERTICAL,
                        false);

        recyclerView.setAdapter(fastAdapter);
        recyclerView.setLayoutManager(layoutManager);

        for (FilmResponse movie : movieList.getResults()) {
            MovieItem movieItem = new MovieItem();
            movieItem.movie = movie;

            itemAdapter.add(movieItem);
        }


        fastAdapter.withOnClickListener(new OnClickListener() {
            @Override
            public boolean onClick(View v, IAdapter adapter, IItem item, int position) {
                FilmResponse movie = movieList.getResults().get(position);

                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("film", movie);
                startActivity(intent);

                return false;
            }
        });
    }
}
