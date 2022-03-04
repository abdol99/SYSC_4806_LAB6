package abdalla.addressbook;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class BuddyInfo {
    private String name;
    private String phoneNumber;

    @Id
    @GeneratedValue
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId(){
        return this.id;
    }


    public BuddyInfo(){}


    /**
     * Constructor for abdalla.addressbook.BuddyInfo
     *
     * @param name name of buddy
     */
    public BuddyInfo(String name) {
        this.name = name;
    }


    /**
     * Constructor for abdalla.addressbook.BuddyInfo
     *
     * @param name name of buddy
     * @param phoneNumber phone nubmer of buddy
     */
    public BuddyInfo(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    @Transient
    public String toString() {
        return name;
    }

    public String seralize() {
        return name;
    }
}

