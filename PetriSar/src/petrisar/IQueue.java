/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petrisar;

/**
 *
 * @author Maxime Bittan, Redha Gouicem, Ilyas Toumlilt
 */
public interface IQueue {
    public IState pop() throws InterruptedException;
    public void push(IState state);
    public boolean isEmpty();

    public void waitOver();
}
