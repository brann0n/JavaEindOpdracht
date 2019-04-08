/*
 * Brandon Abbenhuis
 * brandon.abbenhuis@student.nhlstenden.com
 * Date: 
 */
package javaeindopdracht;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Brandon
 */
public class NewObjectCreationScreen extends JFrame {

    public static enum ScreenTypes {
        CREATE_KAMPIOENSCHAP,
        CREATE_SCHAATSER,
        CREATE_RONDE
    }

    public NewObjectCreationScreen(ScreenTypes type, String title) {
        super(title);
        setLayout(new BorderLayout());
        Container c = getContentPane();
        switch (type) {
            case CREATE_KAMPIOENSCHAP:
                CreateKampioenSchap();
                break;
            case CREATE_SCHAATSER:
                break;
            case CREATE_RONDE:
                break;
        }
    }
    
    public void CreateKampioenSchap(){
        JButton button = new JButton("Click me!");
        button.addActionListener((ActionEvent e) -> {SchaatsKampioenschappen.kampioenschappen.add(new Kampioenschap("Test", new Date()));});
        getContentPane().add(button);
    }
}
