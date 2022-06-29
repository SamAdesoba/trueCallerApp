package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.repositories.ContactRepository;
import africa.semicolon.trueCaller.exceptions.NoContactFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
public class ContactServiceImplementer implements ContactService{
		@Autowired
		private ContactRepository contactRepository;


		@Override
		public void addContact(String firstName, String lastName, String phoneNumber) {
			Contact contact = new Contact(firstName,lastName,phoneNumber);
			contactRepository.save(contact);
		}

		@Override
		public Contact findById(String id) {
			Optional<Contact> found = contactRepository.findById(id);
			if (found.isEmpty()) throw new NoContactFoundException("No contact found");
			return found.get();
		}

//		@Override
//		public void deleteContact(Contact contact) {
//			contactRepository.deleteContact(contact);
//
//		}

	@Override
	public Contact findByPhoneNumber(String phoneNumber) {
		return contactRepository.findByPhoneNumber(phoneNumber);
	}

	@Override
	public Contact update(Contact contact) {
		return contactRepository.save(contact);
	}


	@Override
		public List<Contact> findByFirstName(String name) {
			List<Contact> result = new ArrayList<>();
			result.addAll(contactRepository.findByFirstName(name));
			result.addAll(contactRepository.findByLastName(name));
			return result;
		}
	}

