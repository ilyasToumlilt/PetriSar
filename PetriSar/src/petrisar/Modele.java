package petrisar;

import java.util.ArrayList;
import java.util.Iterator;
import model.ArcIF;
import model.NetIF;
import model.Place;
import model.PlaceIF;
import model.Transition;
import model.TransitionIF;

public class Modele {
    private NetIF reseau;
    
    public Modele(NetIF reseau)
    {
	this.reseau = reseau;
    }
    
    public State getInitState()
    {
	State s = new State(reseau);
        int i = 0 ;
        
        for (PlaceIF p : reseau.getListPlaces()) {
            s.setPlaceMark(i, p.getInit());
            p.setIndex(i);
            i++;
        }
        
        return s;
    }
    
    private boolean isEnable (TransitionIF t, IState s)
    {
        for (ArcIF a : t.getPre()) {
            if (s.getPlaceMark(a.getPlace().getIndex()) < a.getPoids())
                return false;
        }
        return true;
    }
    
    public Iterator<State> getSucc(State s)
    {
        ArrayList<State> succs = new ArrayList<State> ();
        int index;
        
        for (TransitionIF t: reseau.getTransition()) {
            if (this.isEnable (t, s)) {
                State etat = new State(s);
                
                for (ArcIF a : t.getPre()) {
                    index = a.getPlace().getIndex();
                    etat.setPlaceMark(index, s.getPlaceMark(index) - 1);
                }
                
                for (ArcIF a : t.getPost()) {
                    index = a.getPlace().getIndex();
                    etat.setPlaceMark(index, s.getPlaceMark(index) + 1);
                }
                
                succs.add(etat);
            }
        }
        
        return succs.iterator();
    }
}
