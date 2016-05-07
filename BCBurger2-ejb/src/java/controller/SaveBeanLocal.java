package controller;

import javax.ejb.Local;

/**
 * @desc Lokales Interface zur Klasse SaveBean
 * @author Florian
 */
@Local
public interface SaveBeanLocal {
    
    public void performSave(String b1, String b2, String b3, String b4, String b5, String b6, String b7, String b8, String b9, String b10, String b11, String b12, String b13, String b14, String b15, String b16, String b17, String b18, String username, String burgername );

    public String[][] getSaveBurger(String username);

    public void deleteBurger(int bid);

    public void performOrder(String b1, String b2, String b3, String b4, String b5, String b6, String b7, String b8, String b9, String b10, String b11, String b12, String b13, String b14, String b15, String b16, String b17, String b18, String username, String burgername);

    public void deleteBurgerInWarenkorb(int bid);

    public void changeMenge(int bid, int menge);

    public double getGesPreis(int bestid);

    public void performOrder(int bid, String username, String burgername);

    public String[][] getBurgerInWarenkorb(String username);

    public int getBestellungIdByBenutzername(String username);
}
