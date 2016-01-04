/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

import java.util.Iterator;
import petrisar.IModel;
import petrisar.IState;

/**
 *
 * @author 3100161
 */
class BasicModel implements IModel {
    private int K;
    
    public BasicModel(int k) {
        this.K = k;
    }

    @Override
    public IState getInitial() {
        return new BasicState(0);
    }

    @Override
    public Iterator<IState> getSucc(IState state) {
        BasicState bState = (BasicState) state;
        Iterator<IState> it;
        int v = bState.getValue();
        it = new StateIterator(v, K);
        return it;
    }
}
