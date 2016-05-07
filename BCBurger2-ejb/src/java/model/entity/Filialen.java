package model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @desc(Für spätere Erweiterung) Entity Klasse analog zur Tabelle Filialen, zu einer Filiale werden Der Name der Filiale, 
 * die Straße, die Hausnummer und die PLZ zur Zuordnung zum Ort gespeichert.
 * Die FilialenId dient zur eindeutigen Identifikation von Filialen und wird automatisch generiert.
 * @author Florian
 */
@Entity
@Table(name = "FILIALEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Filialen.findAll", query = "SELECT f FROM Filialen f"),
    @NamedQuery(name = "Filialen.findByFilialenId", query = "SELECT f FROM Filialen f WHERE f.filialenId = :filialenId"),
    @NamedQuery(name = "Filialen.findByFilialenName", query = "SELECT f FROM Filialen f WHERE f.filialenName = :filialenName"),
    @NamedQuery(name = "Filialen.findByPlz", query = "SELECT f FROM Filialen f WHERE f.plz = :plz"),
    @NamedQuery(name = "Filialen.findByFilialenStrasse", query = "SELECT f FROM Filialen f WHERE f.filialenStrasse = :filialenStrasse"),
    @NamedQuery(name = "Filialen.findByFilialenHausnummer", query = "SELECT f FROM Filialen f WHERE f.filialenHausnummer = :filialenHausnummer")})

public class Filialen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "FILIALEN_ID")
    private Integer filialenId;
    @Size(max = 50)
    @Column(name = "FILIALEN_NAME")
    private String filialenName;
    @Column(name = "PLZ")
    private Integer plz;
    @Size(max = 50)
    @Column(name = "FILIALEN_STRASSE")
    private String filialenStrasse;
    @Column(name = "FILIALEN_HAUSNUMMER")
    private Integer filialenHausnummer;

    public Filialen() {
    }
//Konstruktor
    public Filialen(String filialenName, int plz, String filialenStrasse, int filialenHausnummer) {
        this.filialenName = filialenName;
        this.plz = plz;
        this.filialenStrasse = filialenStrasse;
        this.filialenHausnummer = filialenHausnummer;
    }
//Set und Get Methoden
    public Integer getFilialenId() {
        return filialenId;
    }

    public String getFilialenName() {
        return filialenName;
    }

    public void setFilialenName(String filialenName) {
        this.filialenName = filialenName;
    }

    public Integer getPlz() {
        return plz;
    }

    public void setPlz(Integer plz) {
        this.plz = plz;
    }

    public String getFilialenStrasse() {
        return filialenStrasse;
    }

    public void setFilialenStrasse(String filialenStrasse) {
        this.filialenStrasse = filialenStrasse;
    }

    public Integer getFilialenHausnummer() {
        return filialenHausnummer;
    }

    public void setFilialenHausnummer(Integer filialenHausnummer) {
        this.filialenHausnummer = filialenHausnummer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (filialenId != null ? filialenId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Filialen)) {
            return false;
        }
        Filialen other = (Filialen) object;
        if ((this.filialenId == null && other.filialenId != null) || (this.filialenId != null && !this.filialenId.equals(other.filialenId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Filialen[ filialenId=" + filialenId + " ]";
    }
    
}
