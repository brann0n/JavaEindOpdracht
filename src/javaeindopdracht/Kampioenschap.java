/*
 * Brandon Abbenhuis
 * brandon.abbenhuis@student.nhlstenden.com
 * Date: 3-4-2019
 * Description: Kampioenschap class, bevat de functies voor een kampioenschap
 * @version: 1.0
 */
package javaeindopdracht;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Kampioenschap {

    private List<String> RondeTypes;
    private String Naam;
    private Date Datum;
    private List<Schaatser> Schaatsers;

    /**
     * Constructor method van de kampioenschap class
     *
     * @param Naam Naam van het kampioenschap
     * @param Datum Datum van het kampioenschap
     */
    public Kampioenschap(String Naam, Date Datum) {
        RondeTypes = new ArrayList<>();
        Schaatsers = new ArrayList<>();

        this.Datum = Datum;
        this.Naam = Naam;
    }

    /**
     * @param types Bevat een lijst van de ronde types
     */
    public void setRondeTypes(List<String> types) {
        this.RondeTypes = types;
    }

    /**
     * Haal de rondetypes op uit het huidige kampioenschap object
     *
     * @return Een lijst met alle ronde types
     */
    public List<String> getRondeTypes() {
        return this.RondeTypes;
    }

    /**
     * Stel de naam van het huidige kampioenschap in
     *
     * @param Naam Naam
     */
    public void setNaam(String Naam) {
        this.Naam = Naam;
    }

    /**
     * Get method
     *
     * @return Naam van huidige kampioenschap
     */
    public String getNaam() {
        return this.Naam;
    }

    /**
     * Datum van huidige kampioenschap
     *
     * @param Datum Datum in datum object
     */
    public void setDatum(Date Datum) {
        this.Datum = Datum;
    }

    /**
     * Datum voor huidige kampioenschap
     *
     * @return Datum object
     */
    public Date getDatum() {
        return this.Datum;
    }

    /**
     * Voeg een schaatser toe aan het huidige kampioenschap
     *
     * @param schaatser Een schaatser object
     */
    public void addSchaatser(Schaatser schaatser) {
        this.Schaatsers.add(schaatser);
    }

    /**
     * Voeg een nieuwe schaatser toe aan het kampioenschap
     *
     * @param Naam De naam van de schaatser
     */
    public void addSchaatser(String Naam) {
        Schaatser tempSchaatser = new Schaatser(Naam, RondeTypes);
        this.Schaatsers.add(tempSchaatser);
    }

    /**
     * Zoek een schaatser op in het huidige kampioenschap
     * @param naam De naam van de schaatser
     * @return Een schaatser object
     */
    public Schaatser getSchaatserByNaam(String naam) {
        for (Schaatser _schaatser : this.Schaatsers) {
            if (_schaatser.getNaam().equals(naam)) {
                return _schaatser;
            }
        }
        return null;
    }

    /**
     * Haalt de totaal punten op van iedere schaatser en berekent een winnaar
     * @return Een Schaatser object
     */
    public Schaatser getWinnaar() {
        HashMap<Double, Schaatser> schaatsersPunten = new HashMap<>();
        for (Schaatser _schaatser : this.Schaatsers) {
            schaatsersPunten.put(_schaatser.getTotaalPunten(), _schaatser);
        }

        double smallestFloat = 0;
        for (Double number : schaatsersPunten.keySet()) {
            if (smallestFloat == 0) {
                smallestFloat = number;
            } else if (number < smallestFloat) {
                smallestFloat = number;
            }
        }

        if (schaatsersPunten.containsKey(smallestFloat)) {
            return schaatsersPunten.get(smallestFloat);
        } else {
            return null;
        }
    }

    /**
     * Haalt alle gegevens op van alle schaatsers en geeft dit in een string terug
     * @return Een geformateerde string met het scoreboard
     */
    public String getScoreBoard() {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
        String scoreText = "Scoreboard voor kampioenschap " + this.Naam  + " op " + dateFormat.format(this.Datum)+ ":\r\n";
        for (Schaatser _schaatser : this.Schaatsers) {
            scoreText += "------------------------------------\r\n";
            scoreText += "Naam: " + _schaatser.getNaam() + "\r\n";
            scoreText += "Totaal punten: " + _schaatser.getTotaalPunten() + "\r\n";
            scoreText += "Tijden per ronde (in mmsshh): \r\n";
            for (Ronde ronde : _schaatser.getRondes()) {
                scoreText += "--- Ronde: " + ronde.getAfstand() + " meter, ";
                scoreText += "Tijd: " + ronde.getTijd() + "\r\n";
            }
            scoreText += "------------------------------------\r\n";
        }
        return scoreText;
    }
}
