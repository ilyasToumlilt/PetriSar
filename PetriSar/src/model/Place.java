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
public class Place implements PlaceIF
{

  private int init;
  private String id;
  private int index;

   @Override public int getInit ()
  {
    return init;
  }

   @Override public String getID ()
  {
    return id;
  }
   
   @Override public void setID(String i)
   {
       this.id = id;
   }
   
  public void setIndex(int index)
  {
      this.index = index;
  }

  public Place (String id)
  {
    this.init = 0;
    this.id = id;
  }

    @Override
    public int getIndex() {
        return this.index;
    }

}
