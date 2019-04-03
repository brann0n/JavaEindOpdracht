/*
 * Brandon Abbenhuis
 * brandon.abbenhuis@student.nhlstenden.com
 * Date: 3-4-2019
 * Description: Schaatser class, bevat de fields en functies voor een schaatser
 * @version: 1.0
 */
package javaeindopdracht;

import java.util.ArrayList;
import java.util.List;

public class Schaatser {

    private String Naam;
    private List<Ronde> Rondes;

    public Schaatser(String Naam) {
        Rondes = new ArrayList<>();

        this.Naam = Naam;
    }

    public Schaatser(String Naam, List<String> RondeTypes) {
        Rondes = new ArrayList<>();

        this.Naam = Naam;
        
        for(String type: RondeTypes){
            Rondes.add(new Ronde(Integer.valueOf(type)));
        }
    }

    public void setNaam(String Naam) {
        this.Naam = Naam;
    }

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

    public Boolean setRonde(List<Ronde> Rondes) {
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

    public List<Ronde> getRondes() {
        return this.Rondes;
    }

    public String getNaam() {
        return this.Naam;
    }

    public float getTotaalPunten() {
        float punten = 0;
        int kortsteAfstand = 0;
        for(Ronde ronde: Rondes){
            if(kortsteAfstand ==0){
                kortsteAfstand = ronde.getAfstand();
            }
            else if(ronde.getAfstand() < kortsteAfstand){
                kortsteAfstand = ronde.getAfstand();
            }
        }
        
        for(Ronde ronde: Rondes){
            //bereken de factor, gebruik de kortste ronde als basis
            float factor = 1;
            punten += ronde.getPunten(factor);
        }
        return punten;
    }
}
