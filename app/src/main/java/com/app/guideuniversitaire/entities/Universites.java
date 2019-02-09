package com.app.guideuniversitaire.entities;

/*
attributs :
    id : identifiant unique pour chaque université
    nom : le nom de l'université
    president : nom de son président
    adr : adresse ou ce trouve sa présidence
    ville : ville ou ce trouve sa présidence
    tel : telephone fixe de la présidence
    email : email de la présidance
 */

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.OrderBy;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

@Entity
public class Universites {

    @Id(autoincrement = true)
    private Long id;

    @Property
    private String nom;

    @Property
    private String president;

    @Property
    private String adresse;

    @Property
    private String ville;

    @Property
    private String email;

    @Property
    private String tel;

    @ToMany(referencedJoinProperty = "universiteId")
    @OrderBy("nom ASC")
    private List<Etablissement> etablissements;

    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /**
     * Used for active entity operations.
     */
    @Generated(hash = 1104989409)
    private transient UniversitesDao myDao;

    public Universites() {
    }


    @Generated(hash = 469429159)
    public Universites(Long id, String nom, String president, String adresse,
                       String ville, String email, String tel) {
        this.id = id;
        this.nom = nom;
        this.president = president;
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

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
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

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1940614849)
    public List<Etablissement> getEtablissements() {
        if (etablissements == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            EtablissementDao targetDao = daoSession.getEtablissementDao();
            List<Etablissement> etablissementsNew = targetDao
                    ._queryUniversites_Etablissements(id);
            synchronized (this) {
                if (etablissements == null) {
                    etablissements = etablissementsNew;
                }
            }
        }
        return etablissements;
    }

    /**
     * Resets a to-many relationship, making the next get call to query for a fresh result.
     */
    @Generated(hash = 1624353580)
    public synchronized void resetEtablissements() {
        etablissements = null;
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

    @Override
    public String toString() {
        return "Universites{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", president='" + president + '\'' +
                ", adresse='" + adresse + '\'' +
                ", ville='" + ville + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }


    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 65188381)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getUniversitesDao() : null;
    }
}
