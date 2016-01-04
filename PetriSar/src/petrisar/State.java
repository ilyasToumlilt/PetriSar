/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petrisar;

import java.util.HashMap;

/**
 *
 * @author 3005993
 */
public class State implements IState {
    private HashMap<Integer, Integer> places;
    
    @Override
    public int getPlaceMark(int id_place) {
        return this.places.get(id_place);
    }

    @Override
    public void setPlaceMark(int id_place, int val) {
        this.places.put(id_place, val);
    }

}
