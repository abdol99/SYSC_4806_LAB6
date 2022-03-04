package abdalla.addressbook;

import javax.swing.*;
import java.awt.*;

public class AddressBookView extends JFrame implements AddressBookListener {

    public DefaultListModel<BuddyInfo> buddyInfos;

    private JMenu menuBuddyInfo;
    private JMenuItem itemAddBuddy, itemRemoveBuddy;
    private JMenuBar menuBar;
    private JList display;

    /**
     * Constructor for the address book view
     *
     * @param controller controller to handle actions of buttons
     * @param model model to listen to
     */
    public AddressBookView(AddressBookController controller, AddressBook model) {
        buddyInfos = new DefaultListModel<>();
        //menu
        menuBar = new JMenuBar();
        menuBuddyInfo = new JMenu("Buddy Info");
        // Ensure the view updates on changes to the model
        model.addAddressBookListener(this);


        //items
        itemAddBuddy = new JMenuItem("Add Buddy");
        itemRemoveBuddy = new JMenuItem("Remove Buddy");

        //Add menu items
        menuBuddyInfo.add(itemAddBuddy);
        menuBuddyInfo.add(itemRemoveBuddy);
        menuBar.add(menuBuddyInfo);

        //display
        display = new JList(buddyInfos);
        display.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container panel = getContentPane();
        panel.setLayout(new BorderLayout());
        panel.add(menuBar, BorderLayout.NORTH);
        panel.add(display, BorderLayout.CENTER);
        setVisible(true);
        this.setSize(500,500);

        itemAddBuddy.addActionListener(e -> controller.handleCreate());
        itemRemoveBuddy.addActionListener(e -> controller.handleRemove(display.getSelectedIndex()));
    }


    @Override
    public void handleAdd(BuddyInfo b) {
        buddyInfos.addElement(b);
    }

    @Override
    public void handleRemove(int index) {
        buddyInfos.remove(index);
    }

    public static void main (String[] args) {
        AddressBook model = new AddressBook();
        new AddressBookView(new AddressBookController(model), model);
    }



}
