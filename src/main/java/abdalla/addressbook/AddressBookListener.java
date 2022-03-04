package abdalla.addressbook;

public interface AddressBookListener {
    void handleAdd(BuddyInfo b);

    void handleRemove(int index);
}
