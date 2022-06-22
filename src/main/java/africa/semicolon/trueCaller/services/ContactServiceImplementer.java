package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.repositories.ContactRepository;

public class ContactServiceImplementer implements ContactService{

	private ContactRepository contactRepository;

	public ContactServiceImplementer(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}

	@Override
	public void addContact(String firstName, String lastName, String phoneNumber) {
		Contact contact = new Contact(firstName,lastName,phoneNumber);
		contactRepository.save(contact);

	}

	@Override
	public Contact findById(int i) {
		return contactRepository.findById(i);
	}

	@Override
	public void deleteContact(Contact contact) {

	}
}
