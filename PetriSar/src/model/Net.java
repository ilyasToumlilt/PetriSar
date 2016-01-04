/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 3260058
 */
public class Net implements NetIF
{

  private List < TransitionIF > l = new ArrayList <> ();
  private List < PlaceIF > lp = new ArrayList <> ();

   @Override public List < TransitionIF > getTransition ()
  {
    return l;
  }

  public List < PlaceIF > getListPlace ()
  {
    return lp;
  }
}
