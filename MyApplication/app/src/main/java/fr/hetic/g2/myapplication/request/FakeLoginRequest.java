package fr.hetic.g2.myapplication.request;

/**
 * Created by Florian ALONSO on 11/13/17.
 * For Neopixl
 */

public class FakeLoginRequest {
    private String email;
    private String password;

    public FakeLoginRequest() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
