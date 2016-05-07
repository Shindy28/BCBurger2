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
 * @desc Entity Klasse analog zur Tabelle Bestellung, zu einer Bestellung werden die BenutzerId zur Zuordnung zum Benutzer 
 * und der Preis für die gesamte Bestellung (FilialenId für spätere Erweiterung) gespeichert.
 * Die BestellungId dient zur eindeutigen Identifikation von BEstellungen und wird automatisch generiert.
 * @author Florian
 */
@Entity
@Table(name = "BESTELLUNG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bestellung.findAll", query = "SELECT b FROM Bestellung b"),
    @NamedQuery(name = "Bestellung.findByBestellungId", query = "SELECT b FROM Bestellung b WHERE b.bestellungId = :bestellungId"),
    @NamedQuery(name = "Bestellung.findByBestellungPreis", query = "SELECT b FROM Bestellung b WHERE b.bestellungPreis = :bestellungPreis"),
    @NamedQuery(name = "Bestellung.findByFilialenId", query = "SELECT b FROM Bestellung b WHERE b.filialenId = :filialenId")})
public class Bestellung implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "BESTELLUNG_ID")
    private Integer bestellungId;
    @Column(name = "BESTELLUNG_PREIS")
    private Double bestellungPreis;
    @Column(name = "FILIALEN_ID")
    private Integer filialenId;  
    @Column(name = "BENUTZER_ID")
    private Integer benutzerId;

    public Bestellung() {
  
    }
//Konstruktor
    public Bestellung(int benutzerId){
        this.benutzerId = benutzerId;
    }
//Set und Get Methoden
    public Integer getBestellungId() {
        return bestellungId;
    }

    public Double getBestellungPreis() {
        return bestellungPreis;
    }

    public void setBestellungPreis(Double berstellungPreis) {
        this.bestellungPreis = berstellungPreis;
    }

    public Integer getFilialenId() {
        return filialenId;
    }

    public void setFilialenId(Integer filialenId) {
        this.filialenId = filialenId;
    }
    
    
    public Integer getBenutzerId() {
        return benutzerId;
    }

    public void setBenutzerId(Integer benutzerId) {
        this.benutzerId = benutzerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bestellungId != null ? bestellungId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bestellung)) {
            return false;
        }
        Bestellung other = (Bestellung) object;
        if ((this.bestellungId == null && other.bestellungId != null) || (this.bestellungId != null && !this.bestellungId.equals(other.bestellungId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Bestellung[ bestellungId=" + bestellungId + " ]";
    }  
}
