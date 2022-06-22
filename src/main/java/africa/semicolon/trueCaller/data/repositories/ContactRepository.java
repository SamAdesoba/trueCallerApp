package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.Contact;

public interface ContactRepository {
	Contact save(Contact contact);
	int count();
	Contact findByFirstName(String firstName);
	Contact findById(int id);

	void deleteContact(Contact contact);
}
