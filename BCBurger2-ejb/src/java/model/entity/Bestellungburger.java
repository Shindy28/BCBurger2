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
@Table(name = "BESTELLUNGBURGER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bestellungburger.findAll", query = "SELECT b FROM Bestellungburger b"),
    @NamedQuery(name = "Bestellungburger.findByBestellungburgerId", query = "SELECT b FROM Bestellungburger b WHERE b.bestellungburgerId = :bestellungburgerId"),
    @NamedQuery(name = "Bestellungburger.findByBurgerId", query = "SELECT b FROM Bestellungburger b WHERE b.burgerId = :burgerId"),
    @NamedQuery(name = "Bestellungburger.findByMenge", query = "SELECT b FROM Bestellungburger b WHERE b.menge = :menge")})
public class Bestellungburger implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "BESTELLUNGBURGER_ID")
    private Integer bestellungburgerId;
    @Column(name = "BURGER_ID")
    private Integer burgerId;
    @Column(name = "MENGE")
    private Integer menge;

    public Bestellungburger() {
   
    }
    
    public Bestellungburger(Integer burgerId) {
        this.burgerId = burgerId;
    }

    public Integer getBestellungburgerId() {
        return bestellungburgerId;
    }

    public void setBestellungburgerId(Integer bestellungburgerId) {
        this.bestellungburgerId = bestellungburgerId;
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
        hash += (bestellungburgerId != null ? bestellungburgerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bestellungburger)) {
            return false;
        }
        Bestellungburger other = (Bestellungburger) object;
        if ((this.bestellungburgerId == null && other.bestellungburgerId != null) || (this.bestellungburgerId != null && !this.bestellungburgerId.equals(other.bestellungburgerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entity.Bestellungburger[ bestellungburgerId=" + bestellungburgerId + " ]";
    }
    
}
