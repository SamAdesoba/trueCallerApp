package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;

public interface ContactService {

	public void addContact(String firstName, String lastName, String phoneNumber);

	Contact findById(int i);

	public void deleteContact(Contact contact);

}
