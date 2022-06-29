package africa.semicolon.trueCaller.controllers;

import africa.semicolon.trueCaller.services.ContactService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact")
public class ContactController {
	@Autowired
	private ContactService contactService;

	@PostMapping("")
	public String addContact(@RequestBody RequestDto requestDto){
		contactService.addContact(requestDto.getFirstName(), requestDto.getLastName(), requestDto.getPhoneNumber());
		return "Added successfully";
	}

	@GetMapping("/{firstName}")
	public String findById(@PathVariable String firstName){
		return contactService.findByFirstName(firstName).toString();
	}

}

@Data
@NoArgsConstructor
@AllArgsConstructor
class RequestDto{
	@NonNull
	private String firstName;
	@NonNull
	private String lastName;
	@NonNull
	private String phoneNumber;
}
