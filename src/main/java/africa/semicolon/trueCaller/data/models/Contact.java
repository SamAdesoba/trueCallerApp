package africa.semicolon.trueCaller.data.models;

import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor

public class Contact {
	@Id
	private String id;
	@NonNull
	private String firstName;
	@NonNull
	private String lastName;
	@NonNull
	private String phoneNumber;


}
