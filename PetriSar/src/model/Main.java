/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

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
        final IStateManager stateMgr = new StateManager(queue);
        NetIF n = null;
        // FileInputStream fis = new FileInputStream("src/fileTest/IOTP_c12m10p15d17.pnml");
       //  FileInputStream fis = new FileInputStream("src/fileTest/Philosophers-5.pnml");
        // FileInputStream fis = new FileInputStream("src/fileTest/IOTP_c1m1p1d1.pnml");
        // FileInputStream fis = new FileInputStream("src/fileTest/IOTP_c5m4p3d2.pnml");
        FileInputStream fis = new FileInputStream("src/fileTest/IOTP_c3m3p3d3.pnml");
        
        n = loadXML(fis);
        IModel model = new Modele(n);
        int cpt = 0;
        final long start = System.currentTimeMillis();
        
        stateMgr.push(model.getInitial());
        
        TimerTask tt = new TimerTask() {
			@Override
			public void run() {
				System.out.println("Explored : " + stateMgr.size() + " time :"+ ( (System.currentTimeMillis() - start) /1000 ) +" s" );
			}
		};
		Timer t = new Timer();
		t.schedule(tt, 0, 1000);
        
        while (!queue.isEmpty()) {
            cpt++;
            IState s;
			try {
				s = queue.pop();
				Iterator<IState> it = model.getSucc(s);
	            while (it.hasNext()) {
	                IState next = it.next();
	                stateMgr.push(next);
	            }
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
        }
        long totalTime = System.currentTimeMillis() - start;
        
        
       
        t.cancel();
        System.out.println("There are "+cpt+" states in this PetriNet.");
        System.out.println("Computed in "+(totalTime)+" ms.");
        
    }
}
