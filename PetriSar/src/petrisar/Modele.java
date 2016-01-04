package petrisar;

import java.util.Iterator;
import model.NetIF;

public class Modele {
    private NetIF reseau;
    
    public Modele(NetIF reseau)
    {
	this.reseau = reseau;
    }
    
    public State getInitState()
    {
	return null;
    }
    
    public Iterator<State> getSucc(State s)
    {
	return null;
    }
}
