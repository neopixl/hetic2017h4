package fr.hetic.g2.myapplication.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Florian ALONSO on 11/13/17.
 * For Neopixl
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonResponse {
    public String email;
    public String phone;
    public NameResponse name;

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

    public NameResponse getName() {
        return name;
    }

    public void setName(NameResponse name) {
        this.name = name;
    }
}
