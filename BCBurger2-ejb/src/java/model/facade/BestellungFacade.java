/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.entity.Bestellung;

/**
 * @desc Klasse enthält alle Methoden um Bestellung zu erstellen
 * @author Florian
 */
@Stateless

public class BestellungFacade extends AbstractFacade<Bestellung> implements BestellungFacadeLocal {
    @PersistenceContext(unitName = "BCBurger2-ejbPU")
    private EntityManager em;
    private Object benutzerFacade;
    private Object bestellungFacade;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BestellungFacade() {
        super(Bestellung.class);
    }
}
