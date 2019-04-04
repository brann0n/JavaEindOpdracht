/*
 * Brandon Abbenhuis
 * brandon.abbenhuis@student.nhlstenden.com
 * Date: 3-4-2019
 * Description: User interface class, contains everything needed for visual part of the program
 * Opdracht: 5
 * @version: 1.0
 */
package javaeindopdracht;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SchaatsKampioenschappen extends JFrame {

    public List<Kampioenschap> kampioenschappen;

    public SchaatsKampioenschappen(String title) {
        super(title);
        setLayout(new BorderLayout());
        Container c = getContentPane();

        //define left panel  
        JPanel panelKampioenSchappen = new JPanel();
        panelKampioenSchappen.setBorder(BorderFactory.createTitledBorder("Kampioenschappen"));
        Dimension sizeK = panelKampioenSchappen.getPreferredSize();
        sizeK.width = 250;
        panelKampioenSchappen.setPreferredSize(sizeK);

        //define middle panel
        JPanel panelSchaatsers = new JPanel();
        panelSchaatsers.setBorder(BorderFactory.createTitledBorder("Schaatsers"));
        Dimension sizeS = panelSchaatsers.getPreferredSize();
        sizeS.width = 250;
        panelSchaatsers.setPreferredSize(sizeS);

        //define right panel
        JPanel panelRonde = new JPanel();
        panelRonde.setBorder(BorderFactory.createTitledBorder("Rondes"));
        Dimension sizeR = panelRonde.getPreferredSize();
        sizeR.width = 250;
        panelRonde.setPreferredSize(sizeR);

        //define buttons
        JButton buttonAddK = new JButton("Nieuw Kampioenschap");
        JButton buttonAddS = new JButton("Nieuwe Schaatser");
        JButton buttonAddR = new JButton("Nieuwe Ronde");

        //define List components for displaying data      
        final JList list = new JList();
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setPreferredSize(new Dimension(200, 200));
        scrollPane.setAlignmentX(LEFT_ALIGNMENT);

        //event listeners
        buttonAddK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                list.addListSelectionListener(null);
                list.setListData(new String[] {"YEET"});
            }
        });

        //add components
        panelKampioenSchappen.add(scrollPane);
        panelKampioenSchappen.add(buttonAddK);

        panelSchaatsers.add(buttonAddS);

        panelRonde.add(buttonAddR);

        c.add(panelKampioenSchappen, BorderLayout.WEST);
        c.add(panelSchaatsers, BorderLayout.CENTER);
        c.add(panelRonde, BorderLayout.EAST);

        kampioenschappen = new ArrayList<>();
    }

}
