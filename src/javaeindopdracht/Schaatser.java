/*
 * Brandon Abbenhuis
 * brandon.abbenhuis@student.nhlstenden.com
 * Date: 3-4-2019
 * Description: Schaatser class, bevat de fields en functies voor een schaatser
 * Opdracht: 5
 * @version: 1.0
 */
package javaeindopdracht;

import java.util.ArrayList;
import java.util.List;

public class Schaatser {

    private String Naam;
    private List<Ronde> Rondes;

    /**
     * Constructor method, maakt een nieuw schaatser object aan.
     *
     * @param Naam
     */
    public Schaatser(String Naam) {
        Rondes = new ArrayList<>();

        this.Naam = Naam;
    }

    /**
     * Constructor method, maakt een nieuw Schaatser Object aan
     *
     * @param Naam De naam van de Schaatser
     * @param RondeTypes Een List met de afstanden die voor het kampioenschap
     * gelden.
     */
    public Schaatser(String Naam, List<String> RondeTypes) {
        Rondes = new ArrayList<>();

        this.Naam = Naam;

        for (String type : RondeTypes) {
            Rondes.add(new Ronde(Integer.valueOf(type)));
        }
    }

    /**
     * Stelt de naam van de schaatser in
     *
     * @param Naam De naam als een string
     */
    public void setNaam(String Naam) {
        this.Naam = Naam;
    }

    /**
     * Stelt een ronde tijd in aan de hand van de afstand
     *
     * @param Afstand Een int met de afstand in meter
     * @param tijd De tijd in het mmsshh format
     * @return Geeft false als het formaat niet klopt, true als alles goed is.
     */
    public Boolean setRonde(int Afstand, String tijd) {
        for (Ronde ronde : Rondes) {
            if (ronde.getAfstand() == Afstand) {
                ronde.setTijd(tijd);
                return true;
            }
        }
        //als de code tot hier komt betekent dat de mee gegeven afstand niet bekend is.
        return false;
    }

    /**
     * Stel de rondes in via een List object
     *
     * @param Rondes Lijst met de verschillende rondes
     * @return True als alles goed gaat, False als het format niet klopt
     */
    public Boolean setRondes(List<Ronde> Rondes) {
        if (Rondes.size() == this.Rondes.size()) {
            //check of de afstanden gelijk zijn. 
            for (int i = 0; i < Rondes.size(); i++) {
                if (Rondes.get(i).getAfstand() == this.Rondes.get(i).getAfstand()) {
                    this.Rondes.get(i).setTijd(Rondes.get(i).getTijd());
                } else {
                    //Dit betekent dat er een andere soort ronde is gemeten dan in het toernament zit.
                    return false;
                }
            }
            return true;
        } else {
            //Dit betekent dat er meer of minder rondes zijn doorgegeven dan in het tournament zitten
            return false;
        }
    }

    /**
     * Haalt de List met rondes op.
     *
     * @return Ronde List
     */
    public List<Ronde> getRondes() {
        return this.Rondes;
    }

    /**
     * Haalt een specifieke ronde op
     *
     * @param afstand De afstand in meter van de ronde die je wilt hebben
     * @return Een Ronde Object
     */
    public Ronde getRonde(int afstand) {
        for (Ronde ronde : this.Rondes) {
            if (ronde.getAfstand() == afstand) {
                return ronde;
            }
        }
        return null;
    }

    /**
     * Haal de naam van de Schaatser op
     *
     * @return Naam als String
     */
    public String getNaam() {
        return this.Naam;
    }

    /**
     * Haal het totaal aantal punten van de Schaatser op
     *
     * @return een float met het totaal aantal punten
     */
    public double getTotaalPunten() {
        double punten = 0;
        double kortsteAfstand = 0;
        for (Ronde ronde : Rondes) {
            if (kortsteAfstand == 0) {
                kortsteAfstand = ronde.getAfstand();
            } else if (ronde.getAfstand() < kortsteAfstand) {
                kortsteAfstand = ronde.getAfstand();
            }
        }

        for (Ronde ronde : Rondes) {
            //bereken de factor, gebruik de kortste ronde als basis
            double factor = kortsteAfstand / ronde.getAfstand(); //kleinste afstand gedeelt door grote afstand.
            punten = JavaEindOpdracht.round(punten + ronde.getPunten(factor), 2);
        }
        return punten;
    }
}
