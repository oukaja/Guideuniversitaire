package com.app.guideuniversitaire.entities;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.NotNull;

@Entity
public class Etablissement {

    @Id(autoincrement = true)
    private Long id;

    private long universiteId;

    @ToOne(joinProperty = "universiteId")
    private Universites universites;

    @Property
    private String nom;

    @Property
    private String type;

    @Property
    private String respo;

    @Property
    private String adresse;

    @Property
    private String ville;

    @Property
    private String email;

    @Property
    private String tel;

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 2067107635)
    private transient EtablissementDao myDao;

    @Generated(hash = 150471663)
    private transient Long universites__resolvedKey;

    public Etablissement() {
    }

    @Generated(hash = 1186618658)
    public Etablissement(Long id, long universiteId, String nom, String type,
            String respo, String adresse, String ville, String email, String tel) {
        this.id = id;
        this.universiteId = universiteId;
        this.nom = nom;
        this.type = type;
        this.respo = respo;
        this.adresse = adresse;
        this.ville = ville;
        this.email = email;
        this.tel = tel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRespo() {
        return respo;
    }

    public void setRespo(String respo) {
        this.respo = respo;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public long getUniversiteId() {
        return this.universiteId;
    }

    public void setUniversiteId(long universiteId) {
        this.universiteId = universiteId;
    }

    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1852860101)
    public Universites getUniversites() {
        long __key = this.universiteId;
        if (universites__resolvedKey == null
                || !universites__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            UniversitesDao targetDao = daoSession.getUniversitesDao();
            Universites universitesNew = targetDao.load(__key);
            synchronized (this) {
                universites = universitesNew;
                universites__resolvedKey = __key;
            }
        }
        return universites;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1992964848)
    public void setUniversites(@NotNull Universites universites) {
        if (universites == null) {
            throw new DaoException(
                    "To-one property 'universiteId' has not-null constraint; cannot set to-one to null");
        }
        synchronized (this) {
            this.universites = universites;
            universiteId = universites.getId();
            universites__resolvedKey = universiteId;
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
    @Generated(hash = 138827958)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getEtablissementDao() : null;
    }
}
