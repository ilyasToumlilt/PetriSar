/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

import java.util.Iterator;
import petrisar.*;

/**
 *
 * @author 3100161
 */
class StateIterator implements Iterator<IState> {
    private int v;
    private int cur;
    private final int K;
    
    public StateIterator(int v, int K) {
        this.v = v;
        this.K = K;
        this.cur = 0;
    }

    @Override
    public boolean hasNext() {
        return(this.cur < 3);
    }

    @Override
    public IState next() {
        BasicState bs = new BasicState((this.v + this.cur) % this.K);
        this.cur++;
        return bs;
    }

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
    
}
