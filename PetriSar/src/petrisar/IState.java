/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petrisar;

import java.util.HashMap;
/**
 *
 * @author Maxime Bittan, Redha Gouicem, Ilyas Toumlilt
 */

public interface IState {
    HashMap<Integer, Integer> getPlaceMark();
    void setPlaceMark(int idPlace, int val);
}
