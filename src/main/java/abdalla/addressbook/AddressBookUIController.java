package abdalla.addressbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class AddressBookUIController {

    @Autowired
    private AddressBookRepository repository;

    public AddressBookUIController(AddressBookRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/addressbook")
    public String getBook(Model model) {
        List<AddressBook> query  = repository.findById(1L);
        AddressBook book = query.get(0);
        model.addAttribute("addressbook", book);
        return "addressbook";
    }

    @PostMapping("/addressbook")
    public String addToBook(@ModelAttribute BuddyInfo buddy, Model model) {
        List<AddressBook> query  = repository.findById(1L);
        AddressBook book = query.get(0);
        book.addBuddy(buddy);
        repository.save(book);
        model.addAttribute("addressbook", book);
        model.addAttribute("newBuddy", new BuddyInfo());
        return "view";
    }


    @PostMapping("/addBuddy")
    public String addBuddySubmit(@ModelAttribute AddBuddy addBuddy, Model model) {
        List<AddressBook> query = repository.findById(1l);
        BuddyInfo buddyInfo = new BuddyInfo(addBuddy.getContent());
        AddressBook book = query.get(0);
        book.addBuddy(buddyInfo);
        repository.save(book);
        return "query";
    }

    @GetMapping("/searchBuddy")
    public String inputFormUI(Model model) {
        model.addAttribute("inputForm", new InputForm());
        return "inputForm";
    }

    @PostMapping("/searchBuddy")
    public String inputFormSubmit(@ModelAttribute InputForm inputForm, Model model){
        if (inputForm.getContent().isEmpty()){
            inputForm.setContent("1");
        }
        List<AddressBook> query = repository.findById(Long.parseLong((inputForm.getContent())));
        model.addAttribute("AddressBook", query);
        return "query";
    }

}


