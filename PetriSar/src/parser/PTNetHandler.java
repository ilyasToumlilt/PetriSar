/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

import model.Arc;
import model.ArcIF;
import model.Net;
import model.NetIF;
import model.Place;
import model.PlaceIF;
import model.Transition;
import model.TransitionIF;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author 2900825
 */
class PTNetHandler extends DefaultHandler {

    private NetIF net = new Net();

    private Stack<Object> stack = new Stack<Object>();
    private Map<String, Object> index = new LinkedHashMap<String, Object>();

    //private Name lastseen = null;
    private boolean readtext = false;
    private Integer lastint = null;
    private boolean readint = false;

    private boolean doNupn = false;
    private boolean doIt = false;

    public PTNetHandler() {
    }

    @Override
    public void characters(char[] chars, int beg, int length) throws SAXException {
        if (doIt) {
            if (readtext) {
                String laststr = new String(Arrays.copyOfRange(chars, beg, beg + length));
                //lastseen = PtnetFactory.eINSTANCE.createName();
                //lastseen.setText(laststr);
            } else if (readint) {
                String laststr = new String(Arrays.copyOfRange(chars, beg, beg + length));
                lastint = new Integer(laststr);
            }
        }
    }

    @Override
    public final void startElement(String uri, String localName, String baliseName, Attributes attributes) throws SAXException {
        if ("net".equals(baliseName)) { //$NON-NLS-1$         
            stack.push(net);
        } else if ("name".equals(baliseName)) {
            readtext = true;

        } else if ("place".equals(baliseName)) {
            String id = attributes.getValue("id");
            PlaceIF place = new Place(id);
            net.getListPlaces().add(place);
            index.put(id, place);
            stack.push(place);
        } else if ("initialMarking".equals(baliseName)) {
            readint = true;
        } else if ("inscription".equals(baliseName)) {
            readint = true;

        } else if ("transition".equals(baliseName)) {
            TransitionIF tr = new Transition();
            String id = attributes.getValue("id");
            //tr.setId(id);
            index.put(id, tr);
            stack.push(tr);
            net.getTransition().add(tr);
        } else if ("arc".equals(baliseName)) {
            TransitionIF tPre = null, tPost = null;
            PlaceIF p = null;
            ArcIF arc = new Arc();
            String id = attributes.getValue("id");
            //arc.setId(id);
            Object src = index.get(attributes.getValue("source"));
            if (src instanceof TransitionIF) {
                tPre = (TransitionIF) src;
                tPre.getPost().add(arc);
                arc.setPlace((PlaceIF) index.get(attributes.getValue("target")));
            } else {
                tPre = (TransitionIF) index.get(attributes.getValue("target"));
                arc.setPlace((PlaceIF) src);
                tPre.getPre().add(arc);
            }

            stack.push(arc);
        } else if ("text".equals(baliseName)) {
            doIt = true;
        } else if ("graphics".equals(baliseName) || "offset".equals(baliseName) || "position".equals(baliseName) || "fill".equals(baliseName) || "line".equals(baliseName) || "dimension".equals(baliseName)) {
            //skip
        } else if ("pnml".equals(baliseName)) {
            // skip
        } else {
            //logger.warning("Unknown XML tag in source file: " + baliseName); //$NON-NLS-1$
            //System.out.println("passage d'element");
        }
    }

    @Override
    public final void endElement(String uri, String localName, String baliseName) throws SAXException {
        // Balise MODEL
        if ("net".equals(baliseName)) { //$NON-NLS-1$
            stack.pop();
            assert (stack.isEmpty());
        } else if ("name".equals(baliseName)) { //$NON-NLS-1$
           /* Object context = stack.peek();
             if (context instanceof PetriNet) {
             PetriNet pnet = (PetriNet) context;
             pnet.setName(lastseen);
             } else if (context instanceof PnObject) {
             PnObject pno = (PnObject) context;
             pno.setName(lastseen);
             } else {
             logger.warning("Unexpected name tag in source file: " + baliseName + " context =" + context.getClass().getName()); //$NON-NLS-1$
             }*/
            readtext = false;
            // lastseen = null;
        } else if ("place".equals(baliseName)) {
            stack.pop();
        } else if ("transition".equals(baliseName)) {
            stack.pop();
        } else if ("arc".equals(baliseName)) {
            stack.pop();
        } else if ("text".equals(baliseName)) {
            doIt = false;
        } else if ("initialMarking".equals(baliseName)) {
            PlaceIF p = (PlaceIF) stack.peek();
           // PTMarking mark = PtnetFactory.eINSTANCE.createPTMarking();
            // mark.setText(lastint);
            p.setInit(lastint);
            readint = false;
            lastint = null;
            
        } else if ("inscription".equals(baliseName)) {
            ArcIF p = (ArcIF) stack.peek();
            /* PTArcAnnotation arcval = PtnetFactory.eINSTANCE.createPTArcAnnotation();
             arcval.setText(lastint);
             p.setInscription(arcval);
            
             lastint = null;*/
            p.setPoids(lastint);
            readint = false;
            //              } else if ("subunits".equals(baliseName)) { //$NON-NLS-1$
            //                      dosubs = false;
            ////            } else if ("graphics".equals(baliseName)) { //$NON-NLS-1$
            ////                    // NOP
            ////           
        } else if ("pnml".equals(baliseName)) {
            // patch missing arc targets
           /* for (Entry<Arc, String> elt : topatcht.entrySet()) {
             Node target = index.get(elt.getValue());
             if (target == null) {
             throw new RuntimeException("Problem when linking arc " + elt.getValue());
             }
             elt.getKey().setTarget(target);
             }
             topatcht.clear();
             for (Entry<Arc, String> elt : topatchs.entrySet()) {
             Node source = index.get(elt.getValue());
             if (source == null) {
             throw new RuntimeException("Problem when linking arc " + elt.getValue());
             }
             elt.getKey().setSource(source);
             }
             topatchs.clear();*/

        } else {
            //logger.warning("Unknown XML tag in source file: " + baliseName); //$NON-NLS-1$
            //System.out.println("passage d'element");
        }
    }

    public NetIF getParseResult() {
        return net;
    }
}
