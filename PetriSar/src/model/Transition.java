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
public class Transition implements TransitionIF
{
//ens pré et ens POSt

  private List < ArcIF > pre = new ArrayList <> ();
  private List < ArcIF > post = new ArrayList <> ();

   @Override public boolean isEnabled ()
  {
    return false;
  }

   @Override public List < ArcIF > getPre ()
  {
    return pre;
  }

  @Override public List < ArcIF > getPost ()
  {
    return post;
  }

}
