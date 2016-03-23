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
 
    public Burger() {
    }

    public Burger(Integer burgerzutatenId) {
        this.burgerzutatenId = burgerzutatenId;
    }

    public Integer getBurgerId() {
        return burgerId;
    }

    public Double getBurgerPreis() {
        return burgerPreis;
    }

    public void setBurgerPreis(Double burgerPreis) {
        this.burgerPreis = burgerPreis;
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

    public Integer getBurgerzutatenId() {
        return burgerzutatenId;
    }

    public void setBurgerzutatenId(Integer burgerzutatenId) {
        this.burgerzutatenId = burgerzutatenId;
    }
    
}
