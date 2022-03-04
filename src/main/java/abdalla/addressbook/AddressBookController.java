package abdalla.addressbook;

import javax.swing.*;

public class AddressBookController {

    private final AddressBook model;

    public AddressBookController(AddressBook model){
        this.model = model;
    }

    public void handleCreate(){
        String buddyInfo = JOptionPane.showInputDialog("Please enter your buddy name", "John Doe");
        model.addBuddy(new BuddyInfo(buddyInfo));
    }

    public void handleRemove(int selectedIndex){
        model.removeBuddy(selectedIndex);
    }
}
