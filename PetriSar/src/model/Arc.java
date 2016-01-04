/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author 3260058
 */
public class Arc implements ArcIF {

    private int poids;
    private PlaceIF place;

    @Override
    public int getPoids() {
        return poids;
    }

    @Override
    public void setPoids(int i) {
        poids = i;
    }

    public PlaceIF getDest() {
        return place;
    }

    public void setDest(PlaceIF pi) {
        place = pi;
    }

    public PlaceIF getSource() {
        return place;
    }

    public void setSource(PlaceIF pi) {
        place = pi;
    }

    @Override
    public PlaceIF getPlace() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPlace(PlaceIF pi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
