package navkar.jewels.com.navkar.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PatientDetailsRequestDto {
	private String patientName;
	private String patientAddrs;
	private String mobileNumber;
	private String numberOfHospitalized;
	private Double billPerDay;
}
