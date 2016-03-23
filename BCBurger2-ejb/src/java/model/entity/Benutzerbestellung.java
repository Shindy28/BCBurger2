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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Florian
 */
@Entity
@Table(name = "BENUTZERBESTELLUNG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Benutzerbestellung.findAll", query = "SELECT b FROM Benutzerbestellung b"),
    @NamedQuery(name = "Benutzerbestellung.findByBenutzerbestellungId", query = "SELECT b FROM Benutzerbestellung b WHERE b.benutzerbestellungId = :benutzerbestellungId"),
    @NamedQuery(name = "Benutzerbestellung.findByBestellungId", query = "SELECT b FROM Benutzerbestellung b WHERE b.bestellungId = :bestellungId")})
public class Benutzerbestellung implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "BENUTZERBESTELLUNG_ID")
    private Integer benutzerbestellungId;
    @Column(name = "BESTELLUNG_ID")
    private Integer bestellungId;

    public Benutzerbestellung() {
    
    }
    
     public Benutzerbestellung(Integer bestellungId) {
            this.bestellungId=bestellungId;
    }

    public Integer getBenutzerbestellungId() {
        return benutzerbestellungId;
    }

    public void setBenutzerbestellungId(Integer benutzerbestellungId) {
        this.benutzerbestellungId = benutzerbestellungId;
    }

    public Integer getBestellungId() {
        return bestellungId;
    }

    public void setBestellungId(Integer bestellungId) {
        this.bestellungId = bestellungId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (benutzerbestellungId != null ? benutzerbestellungId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Benutzerbestellung)) {
            return false;
        }
        Benutzerbestellung other = (Benutzerbestellung) object;
        if ((this.benutzerbestellungId == null && other.benutzerbestellungId != null) || (this.benutzerbestellungId != null && !this.benutzerbestellungId.equals(other.benutzerbestellungId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entity.Benutzerbestellung[ benutzerbestellungId=" + benutzerbestellungId + " ]";
    }
    
}
