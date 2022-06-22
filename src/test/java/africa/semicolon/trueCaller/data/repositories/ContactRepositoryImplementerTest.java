package africa.semicolon.trueCaller.data.repositories;

import africa.semicolon.trueCaller.data.models.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContactRepositoryImplementerTest {
	private ContactRepository contactRepository;

	@BeforeEach public void setUp() {
		contactRepository = new ContactRepositoryImplementer();
	}

	@Test public void saveContact_countIsOneTest(){
		Contact contact = new Contact();
		contact.setFirstName("Samson");

		Contact savedContact = contactRepository.save(contact);
		assertEquals(1, savedContact.getId());
		assertEquals(1, contactRepository.count());
	}

	@Test public void saveContact_countIsTwoTest(){
		Contact contact1 = new Contact();
		Contact contact2 = new Contact();
		contact1.setFirstName("Samson");
		contact2.setFirstName("Adesoba");

		Contact savedContact = contactRepository.save(contact1);
		assertEquals(1, savedContact.getId());
		Contact savedContact2 = contactRepository.save(contact2);
		assertEquals(2, savedContact2.getId());
		assertEquals(2, contactRepository.count());
	}

	@Test public void saveContact_findByIdReturnsContactTest(){
		Contact contact1 = new Contact();
		Contact contact2 = new Contact();

		contact1.setFirstName("Samson");
		Contact savedContact1 = contactRepository.save(contact1);
		Contact foundContact1 = contactRepository.findById(1);

		contact2.setFirstName("Adesoba");
		Contact savedContact2 = contactRepository.save(contact2);
		Contact foundContact2 = contactRepository.findById(2);


		assertEquals(1, foundContact1.getId());
		assertEquals("Samson", foundContact1.getFirstName());

		assertEquals(2, foundContact2.getId());
		assertEquals("Adesoba", foundContact2.getFirstName());
	}

	@Test public void saveContact_findByFirstNameReturnsContactTest(){
		Contact contact1 = new Contact();
		Contact contact2 = new Contact();

		contact1.setFirstName("Samson");
		Contact savedContact1 = contactRepository.save(contact1);
		Contact foundContact1 = contactRepository.findByFirstName("Samson");

		contact2.setFirstName("Adesoba");
		Contact savedContact2 = contactRepository.save(contact2);
		Contact foundContact2 = contactRepository.findById(2);


		assertEquals(1, foundContact1.getId());
		assertEquals("Samson", foundContact1.getFirstName());

		assertEquals(2, foundContact2.getId());
		assertEquals("Adesoba", contactRepository.findById(2).getFirstName());
	}

}