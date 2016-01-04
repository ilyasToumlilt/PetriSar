/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petrisar;

import java.util.HashMap;
import model.NetIF;

/**
 *
 * @author 3005993
 */
public class State implements IState {
    private int[] places;
    
    public State(NetIF reseau)
    {
        this.places = new int [reseau.getListPlaces().size()];
    }
    
    public State(State s)
    {
        this.places = s.places.clone();
    }
    
    @Override
    public int getPlaceMark(int id_place) {
        return this.places[id_place];
    }

    @Override
    public void setPlaceMark(int id_place, int val) {
        this.places[id_place] = val;
    }
}
