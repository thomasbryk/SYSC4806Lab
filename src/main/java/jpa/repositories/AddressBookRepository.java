package jpa.repositories;

import jpa.models.AddressBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "addressbooks", path = "addressbooks")
public interface AddressBookRepository extends PagingAndSortingRepository<AddressBook, Long> {
    AddressBook findById(long id);
}