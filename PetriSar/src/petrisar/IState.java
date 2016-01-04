package petrisar;

import java.util.HashMap;


public interface IState {
    HashMap<Integer, Integer> getPlaceMark();
    void setPlaceMark(int idPlace, int val);
}
