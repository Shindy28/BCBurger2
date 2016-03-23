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
@Table(name = "BURGERZUTATEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Burgerzutaten.findAll", query = "SELECT b FROM Burgerzutaten b"),
    @NamedQuery(name = "Burgerzutaten.findByBurgerzutatenId", query = "SELECT b FROM Burgerzutaten b WHERE b.burgerzutatenId = :burgerzutatenId"),
    @NamedQuery(name = "Burgerzutaten.findByZutatenId", query = "SELECT b FROM Burgerzutaten b WHERE b.zutatenId = :zutatenId"),
    @NamedQuery(name = "Burgerzutaten.findByMenge", query = "SELECT b FROM Burgerzutaten b WHERE b.menge = :menge")})
public class Burgerzutaten implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "BURGERZUTATEN_ID")
    private Integer burgerzutatenId;
    @Column(name = "ZUTATEN_ID")
    private Integer zutatenId;
    @Column(name = "MENGE")
    private Integer menge;

    public Burgerzutaten() {
    }

    public Integer getBurgerzutatenId() {
        return burgerzutatenId;
    }

    public void setBurgerzutatenId(Integer burgerzutatenId) {
        this.burgerzutatenId = burgerzutatenId;
    }

    public Integer getZutatenId() {
        return zutatenId;
    }

    public void setZutatenId(Integer zutatenId) {
        this.zutatenId = zutatenId;
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
        hash += (burgerzutatenId != null ? burgerzutatenId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Burgerzutaten)) {
            return false;
        }
        Burgerzutaten other = (Burgerzutaten) object;
        if ((this.burgerzutatenId == null && other.burgerzutatenId != null) || (this.burgerzutatenId != null && !this.burgerzutatenId.equals(other.burgerzutatenId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entity.Burgerzutaten[ burgerzutatenId=" + burgerzutatenId + " ]";
    }
    
}
