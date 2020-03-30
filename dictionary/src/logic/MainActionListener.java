package logic;

import data.Dictionary;
import data.Option;
import functionalities.*;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainActionListener implements ActionListener {
    private Dictionary dictionary;
    private JFrame frame;

    public MainActionListener(Dictionary dictionary, JFrame frame){
        this.dictionary = dictionary;
        this.frame = frame;

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String command = actionEvent.getActionCommand();
        Option option = Option.getByDescription(command);

        switch(option){
            case ADD:
                new AddContact(frame,dictionary);
                break;
            case IMPORT:
                new ImportFromFile(frame,dictionary);
                break;
            case EXPORT:
                new ExportToFile(frame,dictionary);
                break;
            case REMOVE:
                new RemoveContact(frame, dictionary);
                break;
            case SEARCH:
                new SearchContact(frame,dictionary);
                break;
            case ELEMENTS:
                new ViewContacts(frame,dictionary);
                break;
            case EXIT:
                frame.dispose();
                dictionary.close();
                break;
        }



    }
}
