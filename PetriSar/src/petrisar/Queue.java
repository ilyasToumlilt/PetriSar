/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petrisar;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maxime Bittan, Redha Gouicem, Ilyas LaCamora Toumlilt
 */
public class Queue implements IQueue {
    private ConcurrentLinkedQueue<IState> queue;
    private AtomicInteger activeThreads;
    
    public Queue() {
        this(1);
    }
    
    public Queue(int nbThreads) {
        super();
        this.queue = new ConcurrentLinkedQueue<>();
        this.activeThreads = new AtomicInteger(nbThreads);
    }
    
    @Override
    public IState pop() throws InterruptedException {
        IState s = null;
        int val;
        while ((s = queue.poll()) == null) {
            val = this.activeThreads.decrementAndGet();
            synchronized(this) {
                try {
                    this.wait();
                } catch (InterruptedException ex) {
                    throw ex;
                }
            }
            this.activeThreads.incrementAndGet();
        }
        return s;
    }

    @Override
    public synchronized void push(IState state) {
        queue.add(state);
        this.notifyAll();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void waitOver() {
        while (this.activeThreads.get() != 0) {}
    }
}
