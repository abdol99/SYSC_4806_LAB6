package abdalla.addressbook;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "addressBook", path = "addressBook")
public interface AddressBookRepository extends PagingAndSortingRepository<AddressBook, Long> {

    List<AddressBook> findById(long id);

    void deleteById(long id);

}
