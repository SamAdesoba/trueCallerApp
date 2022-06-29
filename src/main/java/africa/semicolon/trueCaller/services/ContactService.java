package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;

import java.util.List;

public interface ContactService {

	void addContact(String firstName, String lastName, String phoneNumber);
	Contact findById(String id);
//	void deleteContact(Contact contact);

	Contact findByPhoneNumber(String phoneNumber);

	Contact update (Contact contact);

	List<Contact> findByFirstName(String name);


}
