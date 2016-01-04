/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import petrisar.CountStatesFiring;
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
public class BasicPetri2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int nthreads = 3;
        IQueue queue = new Queue(nthreads);
        IStateManager stateMgr = new StateManager(queue);
        IModel model = new BasicModel(42420000);
        CountStatesFiring fire = new CountStatesFiring(model, queue, stateMgr);
        long start = System.currentTimeMillis();
        
        stateMgr.push(model.getInitial());
        Thread t[] = new Thread[nthreads];
        for (int i = 0; i < nthreads; i++) {
            t[i] = new Thread(fire);
            t[i].start();
        }
        queue.waitOver();
        for (int i = 0; i < nthreads; i++) {
            t[i].interrupt();
        }
        long totalTime = System.currentTimeMillis() - start;
        
        System.out.println("<main> There are "+stateMgr.size()+" states in this PetriNet.");
        System.out.println("Computed in "+totalTime+" ms.");
    }
    
}
