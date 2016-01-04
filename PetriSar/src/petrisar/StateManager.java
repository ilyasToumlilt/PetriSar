/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petrisar;

import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author 3100161
 */
public class StateManager implements IStateManager {
    private ConcurrentHashMap set;
    private IQueue queue;
    
    public StateManager(IQueue queue) {
        super();
        this.queue = queue;
        this.set = new ConcurrentHashMap();
    }
    
    @Override
    public void push(IState state) {
        if(set.putIfAbsent(state, state) == null)
            queue.push(state);
    }

    @Override
    public int size() {
        return set.size();
    }
}
