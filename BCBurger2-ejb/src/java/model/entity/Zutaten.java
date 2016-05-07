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
 * @desc Entity Klasse analog zur Tabelle Zutaten, zu einer Zutat werden die Bezeichnung der Zutat
 * und der Preis für die einzelne Zutat gespeicher.
 * Die ZutatenId dient zur eindeutigen Identifikation von Zutaten und wird automatisch generiert.
 * @author Florian
 */
@Entity
@Table(name = "ZUTATEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zutaten.findAll", query = "SELECT z FROM Zutaten z"),
    @NamedQuery(name = "Zutaten.findByZutatenId", query = "SELECT z FROM Zutaten z WHERE z.zutatenId = :zutatenId"),
    @NamedQuery(name = "Zutaten.findByZutatenBezeichnung", query = "SELECT z FROM Zutaten z WHERE z.zutatenBezeichnung = :zutatenBezeichnung"),
    @NamedQuery(name = "Zutaten.findByZutatenPreis", query = "SELECT z FROM Zutaten z WHERE z.zutatenPreis = :zutatenPreis")})
public class Zutaten implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ZUTATEN_ID")
    private Integer zutatenId;
    @Size(max = 50)
    @Column(name = "ZUTATEN_BEZEICHNUNG")
    private String zutatenBezeichnung;
    @Column(name = "ZUTATEN_PREIS")
    private Double zutatenPreis;
  
    public Zutaten() {
    }
//Konstruktor
    public Zutaten(String zutatenBezeichnung, Double zutatenPreis ) {
        this.zutatenBezeichnung = zutatenBezeichnung;
        this.zutatenPreis = zutatenPreis;
    }
//Set und Get Methoden
    public Integer getZutatenId() {
        return zutatenId;
    }

    public String getZutatenBezeichnung() {
        return zutatenBezeichnung;
    }

    public void setZutatenBezeichnung(String zutatenBezeichnung) {
        this.zutatenBezeichnung = zutatenBezeichnung;
    }

    public Double getZutatenPreis() {
        return zutatenPreis;
    }

    public void setZutatenPreis(Double zutatenPreis) {
        this.zutatenPreis = zutatenPreis;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zutatenId != null ? zutatenId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zutaten)) {
            return false;
        }
        Zutaten other = (Zutaten) object;
        if ((this.zutatenId == null && other.zutatenId != null) || (this.zutatenId != null && !this.zutatenId.equals(other.zutatenId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Zutaten[ zutatenId=" + zutatenId + " ]";
    }
}
