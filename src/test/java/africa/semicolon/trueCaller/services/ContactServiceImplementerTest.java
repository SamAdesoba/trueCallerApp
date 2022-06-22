package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.models.Contact;
import africa.semicolon.trueCaller.data.repositories.ContactRepository;
import africa.semicolon.trueCaller.data.repositories.ContactRepositoryImplementer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContactServiceImplementerTest {

	private ContactService contactService;
	private ContactRepository contactRepository;

	@BeforeEach
	public void setUp(){
		contactRepository = new ContactRepositoryImplementer();
		contactService = new ContactServiceImplementer(contactRepository);
	}

	@Test public void addContactTest(){
		contactService.addContact("Adesoba", "Adefolarin", "07068");
		Contact contact = contactRepository.findById(1);
		assertEquals("Adesoba", contact.getFirstName());
		assertEquals("Adefolarin", contact.getLastName());
		assertEquals("07068", contact.getPhoneNumber());
	}

	@Test public void findByIdTest(){
		contactService.addContact("Adesoba", "Adefolarin", "07068");
		contactService.addContact("Adesoba", "Adefolarin", "07068");
		Contact contact1 = contactService.findById(1);
		Contact contact2 = contactService.findById(2);
		assertEquals(1, contact1.getId());
		assertEquals(2, contact2.getId());
	}

}