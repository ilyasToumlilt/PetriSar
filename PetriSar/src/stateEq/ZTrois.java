/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateEq;

import java.io.FileInputStream;
import java.io.IOException;
import model.ArcIF;
import model.NetIF;
import model.PlaceIF;
import model.Transition;
import model.TransitionIF;
import parser.Parser;
import static parser.Parser.loadXML;

/**
 *
 * @author 2900600
 */
public class ZTrois {

    private NetIF n;

    public ZTrois(NetIF n) {
        super();

        this.n = n;

        declarePlaces();
        declareTrans();
        declareAsserts();
        putTheFinishingTouch();
    }

    public void declarePlaces() {

        for (PlaceIF p : n.getListPlaces()) {
            System.out.println("(declare-fun "
                    + p.getID()
                    + " () Int )");
        }

    }
    public void declareTrans() {

        for (TransitionIF  p : n.getTransition()) {
            System.out.println("(declare-fun "
                    + " t" + ( (Transition)p).getIndex()
                    + " () Int )");
        }

    }

    /*
     (assert (= a (+ a0 (- (* t0 pre(a,t0)))
     (* t0 post(a,t0))
     ))
     */
    public void declareAsserts() {

        for (PlaceIF p : n.getListPlaces()) 
        {
            String transitionStr = "";
            for (TransitionIF trans : n.getTransition()) {

                for (ArcIF a : trans.getPre()) {
                    
                    if (a.getPlace() == p) {
                        transitionStr += " (* " + " t" + ( (Transition)trans).getIndex() +" "+ a.getPoids() + " )";
                    }
                }

                for (ArcIF a : trans.getPost()) {
                    if (a.getPlace() == p) {
                        transitionStr += " (* " + " t" + ( (Transition)trans).getIndex() +" "+ a.getPoids() + " )";
                    }
                }
            }
            System.out.println("(assert (= "
                    + p.getID() // a
                    + " (+ "
                    + p.getInit() // a0
                    + " (- "
                    + transitionStr
                    + ")" 
                    + ")))"
            );
        }
    }

    public void putTheFinishingTouch() {
        System.out.println("(check-sat)\n(check-model)");
    }

    public static void main(String[] args) {

        NetIF net;
        try {
            FileInputStream fis = new FileInputStream("/users/Etu5/2900825/Téléchargements/Philosophers/PT/Philosophers-5.pnml");
            net = Parser.loadXML(fis);
            new ZTrois(net);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
