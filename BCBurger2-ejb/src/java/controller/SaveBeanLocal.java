/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.ejb.Local;

/**
 *
 * @author Florian
 */
@Local
public interface SaveBeanLocal {
    public void performSave(String b1, String b2, String b3, String b4, String b5, String b6, String b7, String b8, String b9, String b10, String b11, String b12, String b13, String b14, String b15, String b16, String b17, String b18, String username );
}