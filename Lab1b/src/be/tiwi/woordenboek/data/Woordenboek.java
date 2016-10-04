/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package be.tiwi.woordenboek.data;

/**
 *
 * @author vongenae
 */
public class Woordenboek {
    
    public Woordenboek(String ID, String naam) {
        this.ID = ID;
        this.naam = naam;
    }

    protected String ID;

    /**
     * Get the value of ID
     *
     * @return the value of ID
     */
    public String getID() {
        return ID;
    }

    /**
     * Set the value of ID
     *
     * @param ID new value of ID
     */
    public void setID(String ID) {
        this.ID = ID;
    }
    protected String naam;

    /**
     * Get the value of naam
     *
     * @return the value of naam
     */
    public String getNaam() {
        return naam;
    }

    /**
     * Set the value of naam
     *
     * @param naam new value of naam
     */
    public void setNaam(String naam) {
        this.naam = naam;
    }

    @Override
    public String toString() {
        return naam;
    }

}
