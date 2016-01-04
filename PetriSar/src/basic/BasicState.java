/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

import petrisar.IState;

/**
 *
 * @author 3100161
 */
class BasicState implements IState {
    private final int i;

    public BasicState(int i) {
        this.i = i;
    }

    @Override
    public int getValue() {
        return i;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.i;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BasicState other = (BasicState) obj;
        if (this.i != other.i) {
            return false;
        }
        return true;
    }
    
}
