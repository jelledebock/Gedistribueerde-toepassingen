/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.tiwi.woordenboek.impl;

import be.tiwi.woordenboek.data.Woordenboek;
import be.tiwi.woordenboek.data.WoordenboekDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author vongenae
 */
public class WoordenboekDAODummy implements WoordenboekDAO {

    List<Woordenboek> woordenboeken;
    Random random = new Random();

    public WoordenboekDAODummy() {
        this.woordenboeken = initWoordenboeken();
    }

    @Override
    public List<Woordenboek> getWoordenboeken() {
        return woordenboeken;
    }

    private List<Woordenboek> initWoordenboeken() {
        String[] ids = {"devils", "easton", "elements", "foldoc", "gazetteer",
            "gcide", "hitchcock", "jargon", "moby-thes", "vera", "wn", "world02"};
        String[] titels = {"THE DEVIL'S DICTIONARY ((C)1911 Released April 15 1993)",
            "Easton's 1897 Bible Dictionary",
            "Elements database 20001107",
            "The Free On-line Dictionary of Computing (27 SEP 03)",
            "U.S. Gazetteer (1990",
            "The Collaborative International Dictionary of English v.0.44",
            "Hitchcock's Bible Names Dictionary (late 1800's)",
            "Jargon File (4.3.1, 29 Jun 2001)",
            "Moby Thesaurus II by Grady Ward, 1.0",
            "Virtual Entity of Relevant Acronyms (Version 1.9, June 2002)",
            "WordNet (r) 2.0",
            "CIA World Factbook 2002"};
        List<Woordenboek> lijstWoordenboeken = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            lijstWoordenboeken.add(new Woordenboek(ids[i], titels[i]));
        }
        return lijstWoordenboeken;
    }

    @Override
    public List<String> zoekWoorden(String prefix, String woordenboekId) {
        List<String> woorden = new ArrayList<>();
        int aantal = random.nextInt(10);
        int startLetter = random.nextInt(26);
        for (int i = startLetter + 1 ; i < startLetter + aantal; i++) {
            woorden.add(prefix+woordenboekId+(char)i);
        }
        return woorden;
    }

    @Override
    public List<String> getDefinities(String woord, String woordenboekId) {
        List<String> definities = new ArrayList<>();
        int aantal = random.nextInt(10);
        for (int i = 1 ; i < aantal; i++) {
            definities.add("definitie"+i+woord+woordenboekId);
        }
        return definities;
    }
}
