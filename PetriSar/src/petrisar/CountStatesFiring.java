/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petrisar;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 3100161
 */
public class CountStatesFiring implements IFiring {
    private IModel model;
    private IQueue queue;
    private IStateManager stateMgr;
    
    public CountStatesFiring(IModel model, IQueue queue, IStateManager stateMgr) {
        super();
        this.model = model;
        this.queue = queue;
        this.stateMgr = stateMgr;
    }
    
    @Override
    public void run() {
        int cpt = 0;
        while (true) {
            cpt++;
            IState s;
            try {
                s = queue.pop();
            } catch (InterruptedException ex) {
                System.out.println("There are "+cpt+" states in this PetriNet.");
                return;
            }
            Iterator<IState> it = model.getSucc(s);
            while (it.hasNext()) {
                IState next = it.next();
                stateMgr.push(next);
            }
        }
    }
}
