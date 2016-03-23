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
@Table(name = "BENUTZERBURGER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Benutzerburger.findAll", query = "SELECT b FROM Benutzerburger b"),
    @NamedQuery(name = "Benutzerburger.findByBenutzerburgerId", query = "SELECT b FROM Benutzerburger b WHERE b.benutzerburgerId = :benutzerburgerId"),
    @NamedQuery(name = "Benutzerburger.findByBurgerId", query = "SELECT b FROM Benutzerburger b WHERE b.burgerId = :burgerId")})
public class Benutzerburger implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "BENUTZERBURGER_ID")
    private Integer benutzerburgerId;
    @Column(name = "BURGER_ID")
    private Integer burgerId;

    public Benutzerburger() {
        
    }
    
    public Benutzerburger(Integer burgerId) {
     this.burgerId = burgerId;
    }

    public Integer getBenutzerburgerId() {
        return benutzerburgerId;
    }

    public void setBenutzerburgerId(Integer benutzerburgerId) {
        this.benutzerburgerId = benutzerburgerId;
    }

    public Integer getBurgerId() {
        return burgerId;
    }

    public void setBurgerId(Integer burgerId) {
        this.burgerId = burgerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (benutzerburgerId != null ? benutzerburgerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Benutzerburger)) {
            return false;
        }
        Benutzerburger other = (Benutzerburger) object;
        if ((this.benutzerburgerId == null && other.benutzerburgerId != null) || (this.benutzerburgerId != null && !this.benutzerburgerId.equals(other.benutzerburgerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entity.Benutzerburger[ benutzerburgerId=" + benutzerburgerId + " ]";
    }
    
}
