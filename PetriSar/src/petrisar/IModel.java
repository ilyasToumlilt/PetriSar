/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petrisar;

import java.util.Iterator;

/**
 *
 * @author 3100161
 */
public interface IModel {
    public IState getInitial();
    public Iterator<IState> getSucc(IState state);
}