package abdalla.addressbook;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Abdalla el nakla
 * 100180155
 */

@Entity
public class AddressBook {

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<BuddyInfo> addressBookList;


    /**
     * A list of listeners subscribed to this model.
     */
    @Transient
    private final List<AddressBookListener> addressBookListeners;

    @Id
    @GeneratedValue
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId(){
        return this.id;
    }
    public AddressBook(){
        this.addressBookList = new ArrayList<>();
        this.addressBookListeners = new ArrayList<>();
    }

    public void addAddressBookListener(AddressBookListener addressBookListener) {
        addressBookListeners.add(addressBookListener);
    }


    @OneToMany(mappedBy = "AddressBook")
    public List<BuddyInfo> getBuddyList() {
        return addressBookList;
    }

    public int getAddressBookSize(){
        return addressBookList.size();
    }

    @Transient
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (BuddyInfo buddyInfo : addressBookList) {
            sb.append(buddyInfo.toString()).append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args){
        BuddyInfo buddy1 = new BuddyInfo("Abdalla", "6132121345");
        BuddyInfo buddy2 = new BuddyInfo("tim", "6132223333");

        AddressBook addressBook = new AddressBook();
        addressBook.addBuddy(buddy1);
        addressBook.addBuddy(buddy2);
        System.out.println(addressBook);
        addressBook.removeBuddy(1);
    }

    public void addBuddy(BuddyInfo b) {
        this.addressBookList.add(b);
        for(AddressBookListener listener : addressBookListeners){
            listener.handleAdd(b);
        }

    }

    public void removeBuddy(int index) {
        this.addressBookList.remove(index);
        for (AddressBookListener listener : addressBookListeners){
            listener.handleRemove(index);
        }

    }
}
