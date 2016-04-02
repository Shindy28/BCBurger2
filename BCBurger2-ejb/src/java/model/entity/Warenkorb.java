/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Table(name = "WARENKORB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Warenkorb.findAll", query = "SELECT w FROM Warenkorb w"),
    @NamedQuery(name = "Warenkorb.findByWarenkorbId", query = "SELECT w FROM Warenkorb w WHERE w.warenkorbId = :warenkorbId"),
    @NamedQuery(name = "Warenkorb.findByBurgerId", query = "SELECT w FROM Warenkorb w WHERE w.burgerId = :burgerId"),
    @NamedQuery(name = "Warenkorb.findByMenge", query = "SELECT w FROM Warenkorb w WHERE w.menge = :menge")})
public class Warenkorb implements Serializable {
    @Column(name = "BESTELLUNG_ID")
    private Integer bestellungId;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "WARENKORB_ID")
    private Integer warenkorbId;
    @Column(name = "BURGER_ID")
    private Integer burgerId;
    @Column(name = "MENGE")
    private Integer menge;

    public Warenkorb() {
    }

    public Warenkorb(int bestellungId,int burgerId, int menge ) {
        this.burgerId = burgerId;
        this.bestellungId = bestellungId;
        this.menge = menge;
    }

    public Integer getWarenkorbId() {
        return warenkorbId;
    }

    public void setWarenkorbId(Integer warenkorbId) {
        this.warenkorbId = warenkorbId;
    }

    public Integer getBurgerId() {
        return burgerId;
    }

    public void setBurgerId(Integer burgerId) {
        this.burgerId = burgerId;
    }

    public Integer getMenge() {
        return menge;
    }

    public void setMenge(Integer menge) {
        this.menge = menge;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (warenkorbId != null ? warenkorbId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Warenkorb)) {
            return false;
        }
        Warenkorb other = (Warenkorb) object;
        if ((this.warenkorbId == null && other.warenkorbId != null) || (this.warenkorbId != null && !this.warenkorbId.equals(other.warenkorbId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entity.Warenkorb[ warenkorbId=" + warenkorbId + " ]";
    }

    public Integer getBestellungId() {
        return bestellungId;
    }

    public void setBestellungId(Integer bestellungId) {
        this.bestellungId = bestellungId;
    }

    public Object getBenutzerId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
