package fr.hetic.g2.myapplication.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.NotNull;

/**
 * Created by Florian ALONSO on 11/20/17.
 * For Neopixl
 */

@Entity
public class PhoneDB {

    @Id
    private long id;

    @Property
    private String number;

    private long personId;
    @ToOne(joinProperty = "personId")
    private PersonDB person;











    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 604526982)
    private transient PhoneDBDao myDao;
    @Generated(hash = 353341182)
    public PhoneDB(long id, String number, long personId) {
        this.id = id;
        this.number = number;
        this.personId = personId;
    }
    @Generated(hash = 364978183)
    public PhoneDB() {
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNumber() {
        return this.number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public long getPersonId() {
        return this.personId;
    }
    public void setPersonId(long personId) {
        this.personId = personId;
    }
    @Generated(hash = 1154009267)
    private transient Long person__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 375099121)
    public PersonDB getPerson() {
        long __key = this.personId;
        if (person__resolvedKey == null || !person__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            PersonDBDao targetDao = daoSession.getPersonDBDao();
            PersonDB personNew = targetDao.load(__key);
            synchronized (this) {
                person = personNew;
                person__resolvedKey = __key;
            }
        }
        return person;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1376961616)
    public void setPerson(@NotNull PersonDB person) {
        if (person == null) {
            throw new DaoException(
                    "To-one property 'personId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.person = person;
            personId = person.getId();
            person__resolvedKey = personId;
        }
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1863574557)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getPhoneDBDao() : null;
    }
}
