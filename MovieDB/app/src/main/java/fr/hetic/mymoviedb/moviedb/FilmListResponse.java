package fr.hetic.mymoviedb.moviedb;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Florian ALONSO on 11/20/17.
 * For Neopixl
 */

public class FilmListResponse {

    private int page;
    private int total_results;
    private int total_pages;
    private List<FilmResponse> results;

    public FilmListResponse() {}

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public List<FilmResponse> getResults() {
        return results;
    }

    public void setResults(List<FilmResponse> results) {
        this.results = results;
    }
}
