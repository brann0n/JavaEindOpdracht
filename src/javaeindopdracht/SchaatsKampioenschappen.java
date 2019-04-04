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
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.BadLocationException;

public class SchaatsKampioenschappen extends JFrame {

    //Kampioenschappen objects
    public List<Kampioenschap> kampioenschappen;

    //UI Listmodel objects, these contain the data that is shown in the list
    private DefaultListModel lmKampioenschappen = new DefaultListModel();
    private DefaultListModel lmSchaatsers = new DefaultListModel();
    private DefaultListModel lmRondes = new DefaultListModel();

    //UI list objects, only for viewing purpose
    private JList listKampioenschappen = new JList(lmKampioenschappen);
    private JList listSchaatsers = new JList(lmSchaatsers);
    private JList listRondes = new JList(lmRondes);

    //UI TextBoxes
    private JTextField tbKampioenschappen = new JTextField();
    private String tbKampioenschappenText;
    
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
        buttonAddK.setEnabled(false);
        JButton buttonAddS = new JButton("Nieuwe Schaatser");
        buttonAddS.setEnabled(false);
        JButton buttonAddR = new JButton("Nieuwe Ronde");
        buttonAddR.setEnabled(false);

        //defin Scrollpanes
        JScrollPane spKampioenschappen = new JScrollPane(listKampioenschappen);
        spKampioenschappen.setPreferredSize(new Dimension(200, 250));
        spKampioenschappen.setAlignmentX(LEFT_ALIGNMENT);

        JScrollPane spSchaatsers = new JScrollPane(listSchaatsers);
        spSchaatsers.setPreferredSize(new Dimension(200, 250));
        spSchaatsers.setAlignmentX(LEFT_ALIGNMENT);

        JScrollPane spRondes = new JScrollPane(listRondes);
        spRondes.setPreferredSize(new Dimension(200, 250));
        spRondes.setAlignmentX(LEFT_ALIGNMENT);

        //Setup list components      
        listKampioenschappen.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listSchaatsers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listRondes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //setup textfields
        tbKampioenschappen.setPreferredSize(new Dimension(200, 30));
        tbKampioenschappen.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changedUpdate(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {               
                try {
                    tbKampioenschappenText = e.getDocument().getText(0, e.getDocument().getLength());
                    if(tbKampioenschappenText.length() == 0){
                        buttonAddK.setEnabled(false);
                    }
                    else{
                        buttonAddK.setEnabled(true);
                    }                   
                } catch (BadLocationException ex) {
                    System.out.println("error getting text: " + ex.getMessage());
                }
            }           
        });
        
        //event listeners
        buttonAddK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                kampioenschappen.add(new Kampioenschap(tbKampioenschappenText, new Date()));
                tbKampioenschappen.setText("");
                lmKampioenschappen.clear();
                for (Kampioenschap ks : kampioenschappen) {
                    lmKampioenschappen.addElement(ks.getNaam());
                }
            }
        });

        buttonAddS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //TODO: get the selected kampioenschap and add the schaatser to it
            }
        });
        
        buttonAddR.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //TODO: get the selected Schaatser and update/add the ronde to it.
            }
        });

        listKampioenschappen.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedIndex = listKampioenschappen.getSelectedIndex();
                    if (selectedIndex != -1) {
                        System.out.println("Selection changed, now selected: " + kampioenschappen.get(selectedIndex).getNaam());
                        //TODO: add and enable buttons: "show scoreboard" en "get winnaar"
                    }
                }
            }
        });

        listSchaatsers.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                System.out.println("Selection changed!");
            }

        });

        listRondes.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                System.out.println("Selection changed!");
            }

        });

        //add components
        panelKampioenSchappen.add(spKampioenschappen);
        panelKampioenSchappen.add(tbKampioenschappen);
        panelKampioenSchappen.add(buttonAddK);

        panelSchaatsers.add(spSchaatsers);
        panelSchaatsers.add(buttonAddS);

        panelRonde.add(spRondes);
        panelRonde.add(buttonAddR);

        c.add(panelKampioenSchappen, BorderLayout.WEST);
        c.add(panelSchaatsers, BorderLayout.CENTER);
        c.add(panelRonde, BorderLayout.EAST);

        kampioenschappen = new ArrayList<>();
    }

}
