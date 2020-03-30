package functionalities;

import data.Dictionary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AddContact extends JDialog{
private JPanel panel;
private Dictionary dictionary;
private JButton button;
private JFrame parentframe;
private JLabel numberLabel;
private JLabel ownerLabel;
private JTextField wordTextField;
private JTextField definitionTextField;
private JScrollPane scroll;

    public AddContact(JFrame frame, Dictionary dictionary){
        this.dictionary = dictionary;
        this.parentframe = frame;
        JPanel panel = new JPanel();
        numberLabel = new JLabel("Wpisz numer telefonu:");
        ownerLabel = new JLabel("Wpisz nazwę posiadacza");
        wordTextField = new JTextField();
        //scroll = new JScrollPane(wordTextField);

        definitionTextField = new JTextField();
        wordTextField.setPreferredSize(new Dimension(150,30));
        definitionTextField.setPreferredSize(new Dimension(150,30));



        JButton button = new JButton("Dodaj do słownika");
        button.addActionListener((ActionEvent e) ->{
            String word = wordTextField.getText();
            String definition = definitionTextField.getText();
            dictionary.add(word, definition);

            dispose();
        });


        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(numberLabel);
        panel.add(wordTextField);
        panel.add(ownerLabel);
        panel.add(definitionTextField);
        panel.add(button);
        panel.add(scroll);
        panel.setPreferredSize(new Dimension(400, 120));

        getContentPane().add(panel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }
}
