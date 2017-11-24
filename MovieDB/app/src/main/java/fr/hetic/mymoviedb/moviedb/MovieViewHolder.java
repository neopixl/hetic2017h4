package fr.hetic.mymoviedb.moviedb;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Florian ALONSO on 11/20/17.
 * For Neopixl
 */

public class MovieViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.title_textview)
    TextView titleTextView;

    @BindView(R.id.score_textview)
    TextView scoreTextView;

    @BindView(R.id.poster_imageview)
    ImageView imageView;

    public MovieViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this, itemView);
    }

    public void fill(FilmResponse film) {
        Context context = imageView.getContext();
        String title = film.getTitle();
        double score = film.getVote_average();

        titleTextView.setText(title);
        scoreTextView.setText(""+ score);

        String posterName = film.getPoster_path();
        String url = "http://image.tmdb.org/t/p/w150/"+ posterName;
        Glide.with(context).load(url).into(imageView);
    }

}
