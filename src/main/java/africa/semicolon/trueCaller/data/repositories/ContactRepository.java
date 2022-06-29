package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ContactRepository extends MongoRepository<Contact, String> {
	List<Contact> findByFirstName(String firstName);
	List<Contact> findByLastName(String firstName);
	Contact findByPhoneNumber(String phoneNumber);

//	void deleteContact(Contact contact);

	Optional<Contact> findById(String id);
}
