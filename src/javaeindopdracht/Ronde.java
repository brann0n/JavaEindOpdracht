/*
 * Brandon Abbenhuis
 * brandon.abbenhuis@student.nhlstenden.com
 * Date: 3-4-2019
 * Description: Ronde class, bevat de fields en functies voor een ronde class
 * @version: 1.0
 */
package javaeindopdracht;

public class Ronde {

    private int Afstand;
    private String Tijd; //in format mmsshh

    public Ronde() {

    }

    /*
    * Stelt de tijd in van de ronde, geeft true of false terug als het formaat niet goed is.
    */
    public Boolean setTijd(String tijd) {
        //check if format is correct
        if (tijd.length() == 6) {
            String minuten = tijd.substring(0, 1);
            String seconden = tijd.substring(2, 3);
            String honderden = tijd.substring(4, 5);

            if (Integer.valueOf(minuten) < 60) {
                if (Integer.valueOf(seconden) < 60) {
                    if (Integer.valueOf(honderden) < 99) {
                        this.Tijd = tijd;
                        return true;
                    }
                    else{
                        //honderden verkeerd
                        return false;
                    }
                } else {
                    //seconden verkeerd
                    return false;
                }
            } else {
                //minuten verkeerd
                return false;
            }
        } else {
            //verkeerd formaat
            return false;
        }
    }
}
