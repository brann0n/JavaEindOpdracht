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

    public Ronde(int Afstand) {
        this.Afstand = Afstand;
        this.Tijd = ""; //init
    }

    /**
     * Stel de tijd in van de huidige ronde
     *
     * @param tijd Een string in het formaat "mmsshh" (minuten, seconden,
     * honderden)
     * @return true: als het gelukt is, false: bij verkeerd format.
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
                    } else {
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

    /**
     * stelt de afstand in van de ronde
     *
     * @param Afstand afstand in Meter
     */
    public void setAfstand(int Afstand) {
        this.Afstand = Afstand;
    }

    /**
     * Haalt de afstand van de ronde op
     *
     * @return Afstand in Meter
     */
    public double getAfstand() {
        return this.Afstand;
    }

    /**
     * Haalt de tijd van de ronde op
     *
     * @return tijd in string format "mmsshh"
     */
    public String getTijd() {
        return this.Tijd;
    }

    /**
     * Haalt het aantal punten op wat de huidige ronde waard is
     *
     * @param factor Hiermee wordt het punten aantal vermenigvuldigd zodat het
     * voor iedere ronde gelijk is.
     * @return een float met het punten aantal.
     */
    public double getPunten(double factor) {
        if (this.Tijd.length() == 6) {

            String minuten1 = this.Tijd.substring(0, 2);
            String seconden1 = this.Tijd.substring(2, 4);
            String honderden1 = this.Tijd.substring(4, 6);

            int minuten = Integer.valueOf(this.Tijd.substring(0, 2));
            int seconden = Integer.valueOf(this.Tijd.substring(2, 4));
            int honderden = Integer.valueOf(this.Tijd.substring(4, 6));

            double punten_seconden = ((minuten * 60) + seconden) * factor;
            double punten_100en = honderden * factor;

            return punten_seconden + (punten_100en / 100);
        } else {
            return 0;
        }
    }

}
