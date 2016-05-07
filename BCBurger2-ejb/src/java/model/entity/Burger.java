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
 * @desc  Entity Klasse analog zur Tabelle Burger, zu einem Burger werden der Name des Burgers, der Preis, 
 * die BenutzerId für die Zuordnung zum Benutzer und die BurgerzutatenId für die Zuordnung der Zutaten gespeichert.
 * Die BurgerId dient zur eindeutigen Identifikation von Burgern und wird automatisch generiert.
 * @author Florian
 */
@Entity
@Table(name = "BURGER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Burger.findAll", query = "SELECT b FROM Burger b"),
    @NamedQuery(name = "Burger.findByBurgerId", query = "SELECT b FROM Burger b WHERE b.burgerId = :burgerId"),
    @NamedQuery(name = "Burger.findByBurgerPreis", query = "SELECT b FROM Burger b WHERE b.burgerPreis = :burgerPreis")})
public class Burger implements Serializable {
   
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "BURGER_ID")
    private Integer burgerId;
    @Column(name = "BURGER_PREIS")
    private Double burgerPreis;
    @Column(name = "BURGERZUTATEN_ID")
    private Integer burgerzutatenId;
    @Size(max = 50)
    @Column(name = "BURGER_NAME")
    private String burgerName;
     @Column(name = "BENUTZER_ID")
    private Integer benutzerId;
     
    public Burger() {
    }
//Konstruktor
    public Burger(int burgerzutatenId, double burgerPreis, String burgerName, int benutzerId) {
        this.burgerzutatenId = burgerzutatenId;
        this.burgerPreis = burgerPreis;
        this.burgerName = burgerName;
        this.benutzerId = benutzerId;
    }
//Set und Get Methoden
    public Integer getBurgerId() {
        return burgerId;
    }

    public Double getBurgerPreis() {
        return burgerPreis;
    }

    public void setBurgerPreis(Double burgerPreis) {
        this.burgerPreis = burgerPreis;
    }

    public Integer getBurgerzutatenId() {
        return burgerzutatenId;
    }

    public void setBurgerzutatenId(Integer burgerzutatenId) {
        this.burgerzutatenId = burgerzutatenId;
    }

    public String getBurgerName() {
        return burgerName;
    }

    public void setBurgerName(String burgerName) {
        this.burgerName = burgerName;
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
        hash += (burgerId != null ? burgerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Burger)) {
            return false;
        }
        Burger other = (Burger) object;
        if ((this.burgerId == null && other.burgerId != null) || (this.burgerId != null && !this.burgerId.equals(other.burgerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Burger[ burgerId=" + burgerId + " ]";
    } 
}
