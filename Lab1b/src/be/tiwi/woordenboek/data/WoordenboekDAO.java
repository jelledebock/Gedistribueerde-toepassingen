/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.tiwi.woordenboek.data;

import java.util.List;

/**
 *
 * @author vongenae
 */
public interface WoordenboekDAO {
    public List<Woordenboek> getWoordenboeken();
    public List<String> zoekWoorden(String prefix, String woordenboekId);
    public List<String> getDefinities(String woord, String woordenboekId);
}
