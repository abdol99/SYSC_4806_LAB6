package abdalla.addressbook;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * This is to be used by postman collection or restendpoints, when you hit the post it would be created
 * Abdalla EL Nakla 101080155
 */
@RestController
public class AddressBookRestController {
    private AddressBookRepository repository;

    public AddressBookRestController(AddressBookRepository repository) {
        this.repository = repository;
    }


    @PostMapping("/addressBooks")
    public AddressBook createAddressBook(@RequestBody(required = false) List<BuddyInfo> buddyInfos) {
        AddressBook addressBook = new AddressBook();
        if(buddyInfos != null) {
            for(BuddyInfo b : buddyInfos) {
                addressBook.addBuddy(b);
            }
        }
        repository.save(addressBook);
        return addressBook;
    }
    @PostMapping("/addressBooks/{id}")
    public String createBuddy(@PathVariable String id, @RequestBody BuddyInfo buddy) {
        List<AddressBook> query = repository.findById(Long.parseLong(id));
        if (query.isEmpty()) {
            return "No addressBook created";
        }
        AddressBook addressBook = query.get(0);
        addressBook.addBuddy(buddy);
        repository.save(addressBook);
        return "created";

    }

}
