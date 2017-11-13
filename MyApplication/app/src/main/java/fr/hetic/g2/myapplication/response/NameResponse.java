package fr.hetic.g2.myapplication.response;

/**
 * Created by Florian ALONSO on 11/13/17.
 * For Neopixl
 */

public class NameResponse {
    private String title;
    private String first;
    private String last;

    public NameResponse() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
}
