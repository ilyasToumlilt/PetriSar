public interface IModele {
    public State getInitState();
    public Iterator<State> getSucc(State s);
}
