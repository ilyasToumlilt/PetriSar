/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.NetworkInterface;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import model.Net;
import model.NetIF;
import model.TransitionIF;

/**
 *
 * @author 2900825
 */
public class Parser {

    //private static final Logger LOGGER = Logger.getLogger("fr.lip6.move.gal"); //$NON-NLS-1$
    private static Net net = null;

    public static NetIF loadXML(InputStream in) {
        PTNetHandler modelHandler = new PTNetHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser();
            long debut = System.currentTimeMillis();
            saxParser.parse(in, modelHandler);
            //LOGGER.info("Load time of PNML (sax parser for PT used): " + (System.currentTimeMillis() - debut) + " ms"); //$NON-NLS-1$ //$NON-NLS-2$
        } catch (org.xml.sax.SAXException e) {
            //LOGGER.warning("Parse error while parsing toolspecific elements in pnml.\n details:" + e.getMessage()); //$NON-NLS-1$
            e.printStackTrace();
        } catch (IOException e) {
            //LOGGER.warning("IO exception : " + e.getMessage()); //$NON-NLS-1$
        } catch (ParserConfigurationException e) {
            //LOGGER.warning("Error at ToolSpecific Nupn parser creation. " + e.getMessage()); //$NON-NLS-1$
        }
        //net = modelHandler.getParseResult();
        //order = nupnHandler.getOrder();
        return modelHandler.getParseResult();
    }

    public NetIF getNet() {
        return net;
    }

    public static void main(String[] args) {
        NetIF n = null;
        int cpt = 0;
        try {
            FileInputStream fis = new FileInputStream(args[0]);

           /* PTNetReader ptreader = new PTNetReader();
            PetriNet order = ptreader.loadFromXML(fis);
            System.out.println("Read :" + order);
            System.out.println("with order :" + ptreader.getOrder());*/
            System.out.println("Parsing "+args[0]+"...");
            n = loadXML(fis);
            System.out.println("Places : "+ n.getListPlaces().size());
            System.out.println("Transitions : "+ n.getTransition().size());
            for(TransitionIF t : n.getTransition()){
                cpt += t.getPost().size();
                cpt += t.getPre().size();
            }
            System.out.println("Arcs : "+ cpt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
