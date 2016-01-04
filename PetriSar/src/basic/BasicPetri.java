/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

import java.util.Iterator;
import petrisar.IModel;
import petrisar.IQueue;
import petrisar.IState;
import petrisar.IStateManager;
import petrisar.Queue;
import petrisar.StateManager;

/**
 *
 * @author 3100161
 */
public class BasicPetri {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IQueue queue = new Queue();
        IStateManager stateMgr = new StateManager(queue);
        IModel model = new BasicModel(4242);
        int cpt = 0;
        long start = System.currentTimeMillis();
        
        stateMgr.push(model.getInitial());
        
        while (!queue.isEmpty()) {
            cpt++;
            IState s = queue.pop();
            Iterator<IState> it = model.getSucc(s);
            while (it.hasNext()) {
                IState next = it.next();
                stateMgr.push(next);
            }
        }
        long totalTime = System.currentTimeMillis() - start;
        
        System.out.println("There are "+cpt+" states in this PetriNet.");
        System.out.println("Computed in "+(totalTime)+" ms.");
    }
    
}
