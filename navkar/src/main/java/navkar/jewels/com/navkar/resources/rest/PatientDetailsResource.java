package navkar.jewels.com.navkar.resources.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import navkar.jewels.com.navkar.DTO.PatientDetailsRequestDto;
import navkar.jewels.com.navkar.service.PatientDetailsService;
@RestController
@RequestMapping("/api")
public class PatientDetailsResource {

	@Autowired
	private PatientDetailsService patientService;
	@RequestMapping("/generate")
	private String generateBill(@RequestBody PatientDetailsRequestDto dto)
	{
		try {
		String patientId = patientService.generateBillAndSavePatient(dto);
		return patientId;
		}catch(Exception e)
		{
			e.printStackTrace();
			return "Error occured while saving with Error Message "+ e.getMessage();
		}
	}
}
