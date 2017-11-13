package fr.hetic.g1.myapplication.request.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Florian ALONSO on 11/13/17.
 * For Neopixl
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonResponse {
    private String email;
    private String phone;

    public PersonResponse() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
