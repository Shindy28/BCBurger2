package model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @desc(Für spätere Erweiterung) Entity Klasse analog zur Tabelle PLZ, zu einer Postleitzahl wird der zugehörige Ort gespeichert.
 * Die PLZ dient zur eindeutigen Identifikation von Orten.
 * @author Florian
 */
@Entity
@Table(name = "PLZ")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plz.findAll", query = "SELECT p FROM Plz p"),
    @NamedQuery(name = "Plz.findByPlz", query = "SELECT p FROM Plz p WHERE p.plz = :plz"),
    @NamedQuery(name = "Plz.findByOrt", query = "SELECT p FROM Plz p WHERE p.ort = :ort")})

public class Plz implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PLZ")
    private Integer plz;
    @Size(max = 50)
    @Column(name = "ORT")
    private String ort;

    public Plz() {
    }
//Konstruktor
    public Plz(String ort) {
        this.ort = ort;
    }
//Set und Get Methoden
    public Integer getPlz() {
        return plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (plz != null ? plz.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plz)) {
            return false;
        }
        Plz other = (Plz) object;
        if ((this.plz == null && other.plz != null) || (this.plz != null && !this.plz.equals(other.plz))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Plz[ plz=" + plz + " ]";
    }
    
}
