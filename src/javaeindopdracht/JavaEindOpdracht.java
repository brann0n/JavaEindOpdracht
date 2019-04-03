/*
 * Brandon Abbenhuis
 * brandon.abbenhuis@student.nhlstenden.com
 * Date: 3-4-2019
 * Description: Main class
 * @version: 1.0
 */
package javaeindopdracht;

import java.util.Arrays;
import java.util.Date;

public class JavaEindOpdracht {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Kampioenschap wedstrijd1 = new Kampioenschap("Wedstrijd 1", new Date());
        wedstrijd1.setRondeTypes(Arrays.asList("500", "1500", "5000","10000"));
        
        //Add Sven Kramer
        wedstrijd1.addSchaatser("Sven Kramer");
        wedstrijd1.getSchaatserByNaam("Sven Kramer").setRonde(500, "012066");
        wedstrijd1.getSchaatserByNaam("Sven Kramer").setRonde(1500, "025952");
        
        //Add Test2
        wedstrijd1.addSchaatser("Test2");
        wedstrijd1.getSchaatserByNaam("Test2").setRonde(500, "015666");
        wedstrijd1.getSchaatserByNaam("Test2").setRonde(1500, "032052");
        
        Schaatser winnaar = wedstrijd1.getWinnaar();
        System.out.println("Winnaar: " + winnaar.getNaam());
        System.out.println(wedstrijd1.getScoreBoard());
    }
    
}
