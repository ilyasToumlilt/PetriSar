/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import static parser.Parser.loadXML;
import petrisar.IModel;
import petrisar.IQueue;
import petrisar.IState;
import petrisar.IStateManager;
import petrisar.Modele;
import petrisar.Queue;
import petrisar.StateManager;

/**
 *
 * @author 3005993
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        IQueue queue = new Queue();
        IStateManager stateMgr = new StateManager(queue);
        NetIF n = null;
        FileInputStream fis = new FileInputStream("/users/Etu3/3005993/PetriSar/PetriSar/src/fileTest/IOTP_c12m10p15d17.pnml");
         n = loadXML(fis);
        IModel model = new Modele(n);
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
