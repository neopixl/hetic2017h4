package fr.hetic.mymoviedb.moviedb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends AppCompatActivity {

    @BindView(R.id.backdrop_imageview)
    ImageView backdropImageview;
    @BindView(R.id.title_textview)
    TextView titleTextview;
    @BindView(R.id.release_textview)
    TextView releaseTextview;
    @BindView(R.id.overview_textview)
    TextView overviewTextview;

    FilmResponse filmResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);


        if (getIntent() != null) {
            // All the line below is to display the film value
            filmResponse = getIntent().getParcelableExtra("film");

            if (filmResponse != null) {

                titleTextview.setText(filmResponse.getTitle());
                releaseTextview.setText(filmResponse.getRelease_date());
                overviewTextview.setText(filmResponse.getOverview());

                String posterName = filmResponse.getPoster_path();
                String url = "http://image.tmdb.org/t/p/w150/"+ posterName;
                Glide.with(this).load(url).into(backdropImageview);
            }
        }
    }
}
