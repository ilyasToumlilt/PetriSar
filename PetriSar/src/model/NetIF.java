/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author 3260058
 */
public interface NetIF
{

  public List < TransitionIF > getTransition ();

  public List < PlaceIF > getListPlaces ();

}
