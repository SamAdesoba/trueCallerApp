package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.Contact;

import java.util.ArrayList;


public class ContactRepositoryImplementer implements ContactRepository{
	ArrayList<Contact> contacts = new ArrayList<>();
	@Override
	public Contact save(Contact contact) {
//		if (contact.getId() != 0) update()
		contact.setId(contacts.size()+1);
		contacts.add(contact);
		return contact;
	}

	@Override
	public int count() {
		return contacts.size();
	}

	@Override
	public Contact findByFirstName(String firstName) {
		for (Contact contact : contacts) {
			if (contact.getFirstName().equalsIgnoreCase(firstName)) {
				return contact;
			}
		}
		return null;
	}
	@Override
	public Contact findById(int id) {
		return contacts.get(id-1);
	}

	@Override
	public Contact findByPhoneNumber(String phoneNumber) {
		for(Contact contact: contacts) {
			if (contact.getPhoneNumber().equals(phoneNumber))
				return contact;
		}
		return null;
	}

	@Override
	public void deleteContact(Contact contact) {
		for (Contact toBeDeleteContact : contacts){
			if (contact.equals(toBeDeleteContact))
				contacts.remove(toBeDeleteContact);
		}
	}


	@Override
	public Contact update(String oldName, String newName) {
		for (Contact toBeUpdated : contacts){
			if (toBeUpdated.getFirstName().equals(oldName))
				toBeUpdated.setFirstName(newName);
			return toBeUpdated;
		}
		return null;
	}
}
