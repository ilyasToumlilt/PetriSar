/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Alexis
 */
public interface PlaceIF
{
  public int getInit ();
  public String getID ();
  public void setID(String i);
    public int getIndex();
    public void setIndex(int index);
    public void setInit(int i);
}
