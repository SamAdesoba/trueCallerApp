package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.repositories.ContactRepository;
import africa.semicolon.trueCaller.data.repositories.ContactRepositoryImplementer;

public class ContactServiceImplementer implements ContactService{

	private ContactRepository contactRepository = new ContactRepositoryImplementer();


	@Override
	public void addContact(String firstName, String lastName, String phoneNumber) {
		Contact contact = new Contact(firstName,lastName,phoneNumber);
		contactRepository.save(contact);
	}

	@Override
	public Contact findById(int id) {
		return contactRepository.findById(id);
	}

	@Override
	public void deleteContact(Contact contact) {
		contactRepository.deleteContact(contact);

	}

	@Override
	public int count() {
		return contactRepository.count();
	}

	@Override
	public Contact findByFirstName(String firstName) {
		return contactRepository.findByFirstName(firstName);
	}
}
