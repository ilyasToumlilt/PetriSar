/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petrisar;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author 3005993
 */
class PTStateIterator implements Iterator<State> {

    public PTStateIterator(State s) {
        ArrayList<State> succs = new ArrayList<State> ();
        
        
        for (Trans t: net ) {
            if (enabled (t,s)) {
                succs.add( fire(t,s) );
            }
        }
        
        
    }

    @Override
    public boolean hasNext() {
        
    }

    @Override
    public State next() {
        
    }
    
}
