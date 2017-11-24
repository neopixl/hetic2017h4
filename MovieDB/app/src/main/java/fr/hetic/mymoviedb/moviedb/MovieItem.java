package fr.hetic.mymoviedb.moviedb;

import android.view.View;

import com.mikepenz.fastadapter.items.AbstractItem;

import java.util.List;

/**
 * Created by Florian ALONSO on 11/20/17.
 * For Neopixl
 */

public class MovieItem extends AbstractItem<MovieItem, MovieViewHolder> {

    public FilmResponse movie;

    @Override
    public int getType() {
        return 0;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.row_movie;
    }

    @Override
    public MovieViewHolder getViewHolder(View v) {
        return new MovieViewHolder(v);
    }

    @Override
    public void bindView(MovieViewHolder holder, List<Object> payloads) {
        super.bindView(holder, payloads);

        holder.fill(movie);
    }
}
