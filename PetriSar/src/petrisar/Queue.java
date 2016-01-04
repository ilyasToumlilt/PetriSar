/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petrisar;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author Maxime Bittan, Redha Gouicem, Ilyas LaCamora Toumlilt
 */
public class Queue implements IQueue {
    private ConcurrentLinkedQueue<IState> queue;
    
    public Queue() {
        super();
        this.queue = new ConcurrentLinkedQueue<>();
    }
    
    @Override
    public IState pop() {
        return queue.poll();
    }

    @Override
    public void push(IState state) {
        queue.add(state);
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
