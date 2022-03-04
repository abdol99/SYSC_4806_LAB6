package abdalla.addressbook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AddressBookApplication {

    private static final Logger log = LoggerFactory.getLogger(AddressBookApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AddressBookApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(AddressBookRepository addressBookRepository) {
        return (args) -> {
            AddressBook book = new AddressBook();
            book.addBuddy(new BuddyInfo("Buddy one"));
            book.addBuddy(new BuddyInfo("Buddy two"));
            book.addBuddy(new BuddyInfo("Buddy three"));

            AddressBook book2 = new AddressBook();
            book2.addBuddy(new BuddyInfo("Buddy"));
            book2.addBuddy(new BuddyInfo("Buddy ha"));
            book2.addBuddy(new BuddyInfo("Buddy he"));

            AddressBook book3 = new AddressBook();
            book3.addBuddy(new BuddyInfo("Buddy Abdol"));
            book3.addBuddy(new BuddyInfo("Buddy tom"));
            book3.addBuddy(new BuddyInfo("Buddy krish"));

            addressBookRepository.save(book);
            addressBookRepository.save(book2);
            addressBookRepository.save(book3);

            log.info("Created a new Address Book");
        };
    }

}
