/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petrisar;

import java.util.Arrays;
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
    	places = Arrays.copyOf(s.places, s.places.length);
    }
    
    @Override
    public int getPlaceMark(int id_place) {
        return this.places[id_place];
    }

    @Override
    public void setPlaceMark(int id_place, int val) {
        this.places[id_place] = val;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(places);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		State other = (State) obj;
		if (!Arrays.equals(places, other.places))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(places);
	}
    
    
}
