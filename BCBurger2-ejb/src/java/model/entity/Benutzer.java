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
 * @desc Entity Klasse analog zur Tabelle Benutzer, zu einem Benutzer werden Name und Passwort 
 * (E-Mail für spätere Erweiterungen) gespeichert.
 * Die BenutzerId dient zur eindeutigen Identifikation von Benutzern und wird automatisch generiert.
 * @author Florian
 */
@Entity
@Table(name = "BENUTZER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Benutzer.findAll", query = "SELECT b FROM Benutzer b"),
    @NamedQuery(name = "Benutzer.findByBenutzerId", query = "SELECT b FROM Benutzer b WHERE b.benutzerId = :benutzerId"),
    @NamedQuery(name = "Benutzer.findByBenutzerName", query = "SELECT b FROM Benutzer b WHERE b.benutzerName = :benutzerName"),
    @NamedQuery(name = "Benutzer.findByBenutzerEmail", query = "SELECT b FROM Benutzer b WHERE b.benutzerEmail = :benutzerEmail"),
    @NamedQuery(name = "Benutzer.findByBenutzerPasswort", query = "SELECT b FROM Benutzer b WHERE b.benutzerPasswort = :benutzerPasswort")})
    
public class Benutzer implements Serializable {
   
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "BENUTZER_ID")
    private Integer benutzerId;
    @Size(max = 50)
    @Column(name = "BENUTZER_NAME")
    private String benutzerName;
    @Size(max = 50)
    @Column(name = "BENUTZER_EMAIL")
    private String benutzerEmail;
    @Size(max = 50)
    @Column(name = "BENUTZER_PASSWORT")
    private String benutzerPasswort;

    public Benutzer() {
    }
//Konstruktor
    public Benutzer(String benutzerName,String benutzerPasswort) {
        this.benutzerName = benutzerName;
        this.benutzerPasswort = benutzerPasswort;
    }
//Set und Get Methoden
    public Integer getBenutzerId() {
        return benutzerId;
    }

    public String getBenutzerName() {
        return benutzerName;
    }

    public void setBenutzerName(String benutzerName) {
        this.benutzerName = benutzerName;
    }

    public String getBenutzerEmail() {
        return benutzerEmail;
    }

    public void setBenutzerEmail(String benutzerEmail) {
        this.benutzerEmail = benutzerEmail;
    }

    public String getBenutzerPasswort() {
        return benutzerPasswort;
    }

    public void setBenutzerPasswort(String benutzerPasswort) {
        this.benutzerPasswort = benutzerPasswort;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (benutzerId != null ? benutzerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Benutzer)) {
            return false;
        }
        Benutzer other = (Benutzer) object;
        if ((this.benutzerId == null && other.benutzerId != null) || (this.benutzerId != null && !this.benutzerId.equals(other.benutzerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Benutzer[ benutzerId=" + benutzerId + " ]";
    }
    
}
