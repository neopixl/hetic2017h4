package fr.hetic.g1.myapplication.request.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by Florian ALONSO on 11/13/17.
 * For Neopixl
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class RandomNamesResponse {
    private List<PersonResponse> results;

    public RandomNamesResponse() {

    }

    public List<PersonResponse> getResults() {
        return results;
    }

    public void setResults(List<PersonResponse> results) {
        this.results = results;
    }
}
