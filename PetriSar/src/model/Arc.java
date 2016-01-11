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
public class Arc implements ArcIF
{

  private int poids=1;
  private PlaceIF pl;

   @Override public int getPoids ()
  {
    return poids;
  }

   @Override public void setPoids (int i)
  {
    poids = i;
  }

  public PlaceIF getPlace ()
  {
    return pl;
  }

  public void setPlace (PlaceIF pi)
  {
    pl = pi;
  }



}
