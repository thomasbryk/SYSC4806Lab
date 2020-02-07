package jpa.views;
import jpa.controllers.AddressBookController;
import jpa.models.BuddyInfo;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddressBookView extends JFrame implements ActionListener, ListSelectionListener {

    private JMenuItem createItem, displayItem, addItem, removeItem;
    private AddressBookController controller;
    private JTextArea textArea;
    private JList<BuddyInfo> buddyList;
    private String selectedBuddy;

    public AddressBookView () {
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        //Initializes Address Book menu
        JMenu addressMenu = new JMenu("Address Book");
        menuBar.add(addressMenu);

        //Initializes jpa.models.BuddyInfo menu
        JMenu buddyMenu = new JMenu("jpa.models.BuddyInfo");
        menuBar.add(buddyMenu);

        //Menu items
        //Create button for Address Book menu
        createItem = new JMenuItem("Create");
        createItem.addActionListener(this);
        addressMenu.add(createItem);

        //Display button for Address Book menu
        displayItem = new JMenuItem("Display");
        displayItem.addActionListener(this);
        addressMenu.add(displayItem);
        displayItem.setEnabled(false);

        //Add button for jpa.models.BuddyInfo menu
        addItem = new JMenuItem("Add");
        addItem.addActionListener(this);
        buddyMenu.add(addItem);
        addItem.setEnabled(false);

        //Remove button for jpa.models.BuddyInfo menu
        removeItem = new JMenuItem("Remove");
        removeItem.addActionListener(this);
        buddyMenu.add(removeItem);
        removeItem.setEnabled(false);

        //Text are to display jpa.models.BuddyInfo
        textArea = new JTextArea();
        this.add(textArea);
    }

    public void initView (){
        buddyList = new JList<>(controller.getModelList());	//List using ListModel for jpa.models.BuddyInfo
        buddyList.addListSelectionListener(this);

        this.add(new JScrollPane(buddyList));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void setController (AddressBookController controller){
        this.controller = controller;
    }

    public AddressBookController getController (){
        return this.controller;
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Create":
                textArea.setText(null);
                addItem.setEnabled(true);
                controller.createAddressBook();
                break;
            case "Display":
                textArea.setText(controller.display());
                break;
            case "Add":
                textArea.setText(null);
                addItem.setEnabled(true);
                displayItem.setEnabled(true);
                final String name = JOptionPane.showInputDialog("Name");
                controller.addBuddy(name, JOptionPane.showInputDialog("Phone Number"));
                break;
            case "Remove":
                textArea.setText(null);
                controller.removeBuddy(selectedBuddy);
        }
    }

    public void valueChanged (ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            selectedBuddy = buddyList.getSelectedValue().getName();
            if (selectedBuddy==null) {
                removeItem.setEnabled(false);
            }
            else {
                removeItem.setEnabled(true);
            }
        }
    }
}
