package model.facade;

import java.util.List;
import javax.ejb.Local;
import model.entity.Burger;

/**
 * @desc Lokales Interface zur BurgerFacade Klasse
 * @author Florian
 */
@Local
public interface BurgerFacadeLocal {

    void create(Burger burger);

    void edit(Burger burger);

    void remove(Burger burger);

    Burger find(Object id);

    List<Burger> findAll();

    List<Burger> findRange(int[] range);

    int count();
    
    public int saveBurger(int bzid, double burgerPreis, String burgerName, int benutzerId);

    public double getPreisByBurgerId(int burgerId);

    public String getNameByBurgerId(int burgerId);

    public int[] getBurgerIdByBenutzerId(int benutzerId);
    
}
