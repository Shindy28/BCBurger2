/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import java.io.Serializable;
import java.util.List;
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
    @NamedQuery(name = "Burgerzutaten.findByBurgerzutatenId", query = "SELECT b FROM Burgerzutaten b WHERE b.burgerzutatenId = :burgerzutatenId")})
        
public class Burgerzutaten implements Serializable {
    @Column(name = "ZID1")
    private Integer zid1;
    @Column(name = "ZID2")
    private Integer zid2;
    @Column(name = "ZID3")
    private Integer zid3;
    @Column(name = "ZID4")
    private Integer zid4;
    @Column(name = "ZID5")
    private Integer zid5;
    @Column(name = "ZID6")
    private Integer zid6;
    @Column(name = "ZID7")
    private Integer zid7;
    @Column(name = "ZID8")
    private Integer zid8;
    @Column(name = "ZID9")
    private Integer zid9;
    @Column(name = "ZID10")
    private Integer zid10;
    @Column(name = "ZID11")
    private Integer zid11;
    @Column(name = "ZID12")
    private Integer zid12;
    @Column(name = "ZID13")
    private Integer zid13;
    @Column(name = "ZID14")
    private Integer zid14;
    @Column(name = "ZID15")
    private Integer zid15;
    @Column(name = "ZID16")
    private Integer zid16;
    @Column(name = "ZID17")
    private Integer zid17;
    @Column(name = "ZID18")
    private Integer zid18;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "BURGERZUTATEN_ID")
    private Integer burgerzutatenId;

    public Burgerzutaten() {
    }
    public Burgerzutaten(int b1, int b2, int b3, int b4, int b5, int b6, int b7, int b8, int b9, int b10, int b11, int b12, int b13, int b14, int b15, int b16, int b17, int b18) {
        this.zid1 = b1;
        this.zid2 = b2;
        this.zid3 = b3;
        this.zid4 = b4;
        this.zid5 = b5;
        this.zid6 = b6;
        this.zid7 = b7;
        this.zid8 = b8;
        this.zid9 = b9;
        this.zid10 = b10;
        this.zid11 = b11;
        this.zid12 = b12;
        this.zid13 = b13;
        this.zid14 = b14;
        this.zid15 = b15;
        this.zid16 = b16;
        this.zid17 = b17;
        this.zid18 = b18;
      
    }
    
    public Integer getBurgerzutatenId() {
        return burgerzutatenId;
    }

    public void setBurgerzutatenId(Integer burgerzutatenId) {
        this.burgerzutatenId = burgerzutatenId;
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

    public Integer getZid1() {
        return zid1;
    }

    public void setZid1(Integer zid1) {
        this.zid1 = zid1;
    }

    public Integer getZid2() {
        return zid2;
    }

    public void setZid2(Integer zid2) {
        this.zid2 = zid2;
    }

    public Integer getZid3() {
        return zid3;
    }

    public void setZid3(Integer zid3) {
        this.zid3 = zid3;
    }

    public Integer getZid4() {
        return zid4;
    }

    public void setZid4(Integer zid4) {
        this.zid4 = zid4;
    }

    public Integer getZid5() {
        return zid5;
    }

    public void setZid5(Integer zid5) {
        this.zid5 = zid5;
    }

    public Integer getZid6() {
        return zid6;
    }

    public void setZid6(Integer zid6) {
        this.zid6 = zid6;
    }

    public Integer getZid7() {
        return zid7;
    }

    public void setZid7(Integer zid7) {
        this.zid7 = zid7;
    }

    public Integer getZid8() {
        return zid8;
    }

    public void setZid8(Integer zid8) {
        this.zid8 = zid8;
    }

    public Integer getZid9() {
        return zid9;
    }

    public void setZid9(Integer zid9) {
        this.zid9 = zid9;
    }

    public Integer getZid10() {
        return zid10;
    }

    public void setZid10(Integer zid10) {
        this.zid10 = zid10;
    }

    public Integer getZid11() {
        return zid11;
    }

    public void setZid11(Integer zid11) {
        this.zid11 = zid11;
    }

    public Integer getZid12() {
        return zid12;
    }

    public void setZid12(Integer zid12) {
        this.zid12 = zid12;
    }

    public Integer getZid13() {
        return zid13;
    }

    public void setZid13(Integer zid13) {
        this.zid13 = zid13;
    }

    public Integer getZid14() {
        return zid14;
    }

    public void setZid14(Integer zid14) {
        this.zid14 = zid14;
    }

    public Integer getZid15() {
        return zid15;
    }

    public void setZid15(Integer zid15) {
        this.zid15 = zid15;
    }

    public Integer getZid16() {
        return zid16;
    }

    public void setZid16(Integer zid16) {
        this.zid16 = zid16;
    }

    public Integer getZid17() {
        return zid17;
    }

    public void setZid17(Integer zid17) {
        this.zid17 = zid17;
    }

    public Integer getZid18() {
        return zid18;
    }

    public void setZid18(Integer zid18) {
        this.zid18 = zid18;
    }
}
