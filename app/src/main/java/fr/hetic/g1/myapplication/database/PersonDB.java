package fr.hetic.g1.myapplication.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Florian ALONSO on 11/20/17.
 * For Neopixl
 */

@Entity
public class PersonDB {

    @Id(autoincrement = true)
    private long id;

    @Property
    @NotNull
    private String email;





    @Generated(hash = 1305202059)
    public PersonDB(long id, @NotNull String email) {
        this.id = id;
        this.email = email;
    }

    @Generated(hash = 59343024)
    public PersonDB() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
