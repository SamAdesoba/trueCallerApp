package africa.semicolon.trueCaller.controllers;

import africa.semicolon.trueCaller.services.ContactService;
import africa.semicolon.trueCaller.services.ContactServiceImplementer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContactController {

	private ContactService contactService = new ContactServiceImplementer();

	@PostMapping("/contact")
	public String addContact(@RequestBody RequestDto requestDto){
		contactService.addContact(requestDto.getFirstName(), requestDto.getLastName(), requestDto.getPhoneNumber());
		return "Added successfully";
	}

	@GetMapping("/contact/{firstName}")
	public String findById(@PathVariable String firstName){
		return contactService.findByFirstName(firstName).toString();
	}

}

@Data
@NoArgsConstructor
@AllArgsConstructor
class RequestDto{
	private String firstName;
	private String lastName;
	private String phoneNumber;
}
